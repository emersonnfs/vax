package br.com.vax.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class AtualizacaoStatusVacinaRequest {
    private Long id;
    private boolean status;
}
