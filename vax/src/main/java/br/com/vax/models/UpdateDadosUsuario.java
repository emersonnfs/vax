package br.com.vax.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor@NoArgsConstructor
public class UpdateDadosUsuario {
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String cep;
}
