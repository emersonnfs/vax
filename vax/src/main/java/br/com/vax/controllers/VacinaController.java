package br.com.vax.controllers;

import br.com.vax.entities.*;
import br.com.vax.models.AtualizacaoStatusVacinaRequest;
import br.com.vax.models.FormVacina;
import br.com.vax.repositories.StatusVacinaRepository;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.repositories.VacinaRepository;
import br.com.vax.services.VacinaService;
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
    private VacinaService vacinaService;

    @GetMapping("/form-vacinas/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id) {
        return vacinaService.listarFormVacinas(id);
    }

    @PutMapping("/status-vacinas")
    public ResponseEntity<String> atualizarStatusVacinas(@RequestBody List<AtualizacaoStatusVacinaRequest> atualizacoes) {
        return vacinaService.atualizarStatusVacinas(atualizacoes);
    }

    @GetMapping("/vacinas-pendententes/{id}")
    public ResponseEntity<?> listarVacinasPendentes(@PathVariable Long id) {
        List<String> listaResponse = vacinaService.listaPendentes(id);
        if (listaResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listaResponse);
        }
        return ResponseEntity.ok(listaResponse);
    }

}
