package br.com.vax.controllers;

import br.com.vax.entities.CategoriaVacinaEnum;
import br.com.vax.entities.Usuario;
import br.com.vax.entities.Vacina;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@RestController
public class VacinaController {
    @Autowired
    VacinaRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

    private List<Vacina> listarVacinaCrianca() {
        return repository.findByCategoriaVacinaEnum(CategoriaVacinaEnum.Criança);
    }
    private List<Vacina> listarVacinaAdolescente() {
        return repository.findByCategoriaVacinaEnum(CategoriaVacinaEnum.Adolescente);
    }
    private List<Vacina> listarVacinaAdulto() {
        return repository.findByCategoriaVacinaEnum(CategoriaVacinaEnum.Adulto);
    }
    private List<Vacina> listarVacinaIdoso() {
        return repository.findByCategoriaVacinaEnum(CategoriaVacinaEnum.Idoso);
    }
    @GetMapping("/form-vacinas")
    ResponseEntity<?> listar(Long id) {
        Optional<Usuario > usuario = usuarioRepository.findById(id);
        List<Vacina> crianca = listarVacinaCrianca();
        List<Vacina> adolescente = listarVacinaAdolescente();
        List<Vacina> adulto = listarVacinaAdulto();
        List<Vacina> idoso = listarVacinaIdoso();
        if(usuario.isPresent()){
            LocalDate hoje = LocalDate.now();
            LocalDate dataNascimento = usuario.get().getDataNascimento();
            var idade = Period.between(dataNascimento, hoje).getYears();
            if(idade >= 60){
                return ResponseEntity.ok(List.of(crianca,adolescente,adulto,idoso));
            }else if(idade >= 20) {
                return ResponseEntity.ok(List.of(crianca, adolescente, adulto));
            }else if(idade >= 11) {
                return ResponseEntity.ok(List.of(crianca, adolescente));
            }else if(idade >= 0) {
                return ResponseEntity.ok(List.of(crianca));
            }else {
                return ResponseEntity.badRequest().body("Idade inválida");
            }
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado");
    }

}
