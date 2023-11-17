package br.com.vax.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class UpdateSenhaUsuario {
    private Long id;
    private String senhaAntiga;
    private String senhaNova;
}
