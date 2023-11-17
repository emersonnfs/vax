package br.com.vax.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "T_VAX_VACINA")
public class Vacina {
    @Id
    @GeneratedValue
    @Column(name = "ID_VACINA")
    private Long id;

    @Column(name = "NOME_VACINA")
    private String nome;

    @Column(name = "TIPO_VACINA")
    private TipoVacinaEnum tipo;

    @Column(name = "CATEGORIA_VACINA")
    private CategoriaVacinaEnum categoria;

    @Column(name = "TIPO_DOSE_VACINA")
    private TipoDoseVacinaEnum dose;

    @Nullable
    @JsonIgnore
    @OneToMany(mappedBy = "vacina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StatusVacina> statusVacina;
}
