package br.com.vax.services;

import br.com.vax.entities.*;
import br.com.vax.models.AtualizacaoStatusVacinaRequest;
import br.com.vax.models.FormVacina;
import br.com.vax.repositories.StatusVacinaRepository;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Console;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class VacinaService {
    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusVacinaRepository statusVacinaRepository;

    public ResponseEntity<?> listarFormVacinas(Long id) {
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
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<String> atualizarStatusVacinas(List<AtualizacaoStatusVacinaRequest> atualizacoes) {
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

    private DescricaoVacina obterDescricaoVacina(TipoVacinaEnum vacinaEnum) {
        try {
            Field field = TipoVacinaEnum.class.getField(vacinaEnum.name());

            DescricaoVacina descricaoVacina = field.getAnnotation(DescricaoVacina.class);

            return descricaoVacina;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cadastrarStatusVacina(Long id, Long idVacina) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Optional<Vacina> vacina = vacinaRepository.findById(idVacina);
        if(usuario.isPresent() && vacina.isPresent()){
            StatusVacina statusVacina = new StatusVacina();
            statusVacina.setUsuario(usuario.get());
            statusVacina.setVacina(vacina.get());
            statusVacina.setStatus(false);
            statusVacinaRepository.save(statusVacina);
        }
    }
    public List<String> numeroCategorias(Long id){
        ResponseEntity<?> listaResponse =  listarFormVacinas(id);
        if (listaResponse.getStatusCode() == HttpStatus.OK){
            Map<CategoriaVacinaEnum, Map<TipoVacinaEnum, List<FormVacina>>> mapaCategorias = (Map<CategoriaVacinaEnum, Map<TipoVacinaEnum, List<FormVacina>>>) listaResponse.getBody();
            List<String> listaCategorias = new ArrayList<>();
            for (CategoriaVacinaEnum categoriaVacinaEnum : mapaCategorias.keySet()){
                listaCategorias.add(categoriaVacinaEnum.name());
            }
            return listaCategorias;
        }
        return null;
    }

    public List<String> numeroTipos(Long id, String categoria){
        ResponseEntity<?> listaResponse =  listarFormVacinas(id);
        if (listaResponse.getStatusCode() == HttpStatus.OK){
            Map<CategoriaVacinaEnum, Map<TipoVacinaEnum, List<FormVacina>>> mapaCategorias = (Map<CategoriaVacinaEnum, Map<TipoVacinaEnum, List<FormVacina>>>) listaResponse.getBody();
            List<String> listaTipos = new ArrayList<>();
            for (TipoVacinaEnum tipoVacinaEnum : mapaCategorias.get(CategoriaVacinaEnum.valueOf(categoria)).keySet()){
                listaTipos.add(tipoVacinaEnum.name());
            }
            return listaTipos;
        }
        return null;
    }
    public int contagemVacinas(List<StatusVacina> listaStatusVacinas,TipoVacinaEnum tipoVacinaEnum){
        int contagem = 0;
        for (StatusVacina statusVacina : listaStatusVacinas) {
            if(statusVacina.getVacina().getTipo().equals(tipoVacinaEnum)){
                if(statusVacina.isStatus()){
                    contagem++;
                }
            }
        }
        return contagem;
    }

    public boolean pendenteHepatiteB(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            List<StatusVacina> listaStatusVacinas = statusVacinaRepository.findByUsuarioId(id);
            int contagemHepatiteB = contagemVacinas(listaStatusVacinas,TipoVacinaEnum.HepatiteB);
            if(contagemHepatiteB == 0) {
                int contagemPentavalente = contagemVacinas(listaStatusVacinas, TipoVacinaEnum.Pentavalente);
                if (contagemPentavalente < 5){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

