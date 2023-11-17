package br.com.vax.controllers;

import br.com.vax.entities.*;
import br.com.vax.models.AtualizacaoStatusVacinaRequest;
import br.com.vax.models.FormVacina;
import br.com.vax.repositories.StatusVacinaRepository;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
public class VacinaController {
    @Autowired
    VacinaRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    StatusVacinaRepository statusVacinaRepository;

    @GetMapping("/form-vacinas/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            List<StatusVacina> listaStatusVacinas = statusVacinaRepository.findByUsuarioId(id);

            Map<CategoriaVacinaEnum, Map<TipoVacinaEnum, List<FormVacina>>> mapaCategorias = new HashMap<>();

            for (CategoriaVacinaEnum categoriaVacinaEnum : CategoriaVacinaEnum.values()) {
                Map<TipoVacinaEnum, List<FormVacina>> mapaTipos = listarVacinas(listaStatusVacinas, categoriaVacinaEnum);

                if (!mapaTipos.isEmpty()) {
                    mapaCategorias.put(categoriaVacinaEnum, mapaTipos);
                }
            }

            LocalDate hoje = LocalDate.now();
            LocalDate dataNascimento = usuario.get().getDataNascimento();
            var idade = Period.between(dataNascimento, hoje).getYears();

            if (idade >= 60) {
                mapaCategorias.keySet().removeIf(c -> c == CategoriaVacinaEnum.Gestante);
                return ResponseEntity.ok(mapaCategorias);
            } else if (idade >= 20) {
                mapaCategorias.keySet().removeIf(c -> c == CategoriaVacinaEnum.Idoso || c == CategoriaVacinaEnum.Gestante);
                return ResponseEntity.ok(mapaCategorias);
            } else if (idade >= 11) {
                mapaCategorias.keySet().removeIf(c -> c == CategoriaVacinaEnum.Idoso || c == CategoriaVacinaEnum.Adulto ||
                        c == CategoriaVacinaEnum.Gestante);
                return ResponseEntity.ok(mapaCategorias);
            } else if (idade >= 0) {
                mapaCategorias.keySet().removeIf(c -> c == CategoriaVacinaEnum.Idoso || c == CategoriaVacinaEnum.Adulto ||
                        c == CategoriaVacinaEnum.Adolescente || c == CategoriaVacinaEnum.Gestante);
                return ResponseEntity.ok(mapaCategorias);
            } else {
                return ResponseEntity.badRequest().body("Idade inválida");
            }
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado");
    }

    @PutMapping("/atualizar-status-vacinas")
    public ResponseEntity<String> atualizarStatusVacinas(@RequestBody List<AtualizacaoStatusVacinaRequest> atualizacoes) {
        for (AtualizacaoStatusVacinaRequest atualizacao : atualizacoes) {
            Optional<StatusVacina> optionalStatusVacina = statusVacinaRepository.findById(atualizacao.getId());

            if (optionalStatusVacina.isPresent()) {
                StatusVacina statusVacina = optionalStatusVacina.get();
                statusVacina.setStatus(atualizacao.isStatus());
                statusVacinaRepository.save(statusVacina);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacina com ID " + atualizacao.getId() + " não encontrada.");
            }
        }

        return ResponseEntity.ok("Status das vacinas atualizado com sucesso.");
    }

    public void cadastrarStatusVacina(Long id, Long idVacina) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Optional<Vacina> vacina = repository.findById(idVacina);
        if(usuario.isPresent() && vacina.isPresent()){
            StatusVacina statusVacina = new StatusVacina();
            statusVacina.setUsuario(usuario.get());
            statusVacina.setVacina(vacina.get());
            statusVacina.setStatus(false);
            statusVacinaRepository.save(statusVacina);
        }
    }

    private static DescricaoVacina obterDescricaoVacina(TipoVacinaEnum vacinaEnum) {
        try {
            Field field = TipoVacinaEnum.class.getField(vacinaEnum.name());

            DescricaoVacina descricaoVacina = field.getAnnotation(DescricaoVacina.class);

            return descricaoVacina;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<TipoVacinaEnum, List<FormVacina>> listarVacinas(List<StatusVacina> statusVacinas,
                                                                CategoriaVacinaEnum categoriaVacinaEnum) {
        Map<TipoVacinaEnum, List<FormVacina>> mapaVacinas = new HashMap<>();

        for (StatusVacina statusVacina : statusVacinas) {
            Vacina vacina = statusVacina.getVacina();
            CategoriaVacinaEnum categoriaVacina = vacina.getCategoria();

            if (categoriaVacina == categoriaVacinaEnum) {
                TipoVacinaEnum tipoVacina = vacina.getTipo();
                DescricaoVacina descricaoVacina = obterDescricaoVacina(tipoVacina);

                FormVacina formVacina = new FormVacina();
                formVacina.setId(statusVacina.getId());
                formVacina.setNome(descricaoVacina.nome());
                formVacina.setDescricao(descricaoVacina.descricao());
                formVacina.setCategoria(categoriaVacina);
                formVacina.setDose(vacina.getDose());
                formVacina.setStatus(statusVacina.isStatus());

                if (!mapaVacinas.containsKey(tipoVacina)) {
                    mapaVacinas.put(tipoVacina, new ArrayList<>());
                }

                mapaVacinas.get(tipoVacina).add(formVacina);
            }
        }

        return mapaVacinas;
    }

    private Map<TipoVacinaEnum, List<FormVacina>> construirMapaVacinas(Map<TipoVacinaEnum, List<FormVacina>> vacinas) {
        Map<TipoVacinaEnum, List<FormVacina>> mapaVacinas = new HashMap<>();

        for (Map.Entry<TipoVacinaEnum, List<FormVacina>> entry : vacinas.entrySet()) {
            TipoVacinaEnum tipoVacina = entry.getKey();
            List<FormVacina> formVacinas = entry.getValue();

            DescricaoVacina descricaoVacina = obterDescricaoVacina(tipoVacina);

            FormVacina formVacina = new FormVacina();
            formVacina.setId(formVacinas.get(0).getId());

            formVacina.setNome(descricaoVacina.nome());
            formVacina.setDescricao(descricaoVacina.descricao());
            formVacina.setCategoria(formVacinas.get(0).getCategoria());
            formVacina.setDose(formVacinas.get(0).getDose());
            formVacina.setStatus(false);

            mapaVacinas.put(tipoVacina, List.of(formVacina));
        }

        return mapaVacinas;
    }


}
