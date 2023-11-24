package br.com.vax.models;

import br.com.vax.entities.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class LoginResponse {
    private Token token;
    private UsuarioLoginResponse usuario;
}
