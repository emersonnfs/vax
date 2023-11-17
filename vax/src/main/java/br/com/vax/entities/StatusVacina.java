package br.com.vax.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
@Table(name = "T_VAX_STATUS_VACINA")
public class StatusVacina {
    @Id
    @GeneratedValue
    @Column(name = "ID_STATUS_VACINA")
    private Long id;

    @NotNull(message ="O status da vacina é obrigatório")
    @Column(name = "STATUS_VACINA")
    private boolean status;

    @NotNull(message ="O id do usuário é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @NotNull(message ="O id da vacina é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VACINA")
    private Vacina vacina;
}
