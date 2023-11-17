package br.com.vax.models;

import br.com.vax.entities.CategoriaVacinaEnum;
import br.com.vax.entities.TipoDoseVacinaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormVacina {
    private Long id;
    private String nome;
    private String descricao;
    private CategoriaVacinaEnum categoria;
    private TipoDoseVacinaEnum dose;
    private boolean status;
}
