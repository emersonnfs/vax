package br.com.vax.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
@Table(name = "T_VAX_USUARIO")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotNull(message = "O nome do usuário é obrigatório")
    @Column(name = "NOME_USUARIO")
    private String nome;

    @NotNull(message = "O email do usuário é obrigatório")
    @Column(name = "EMAIL_USUARIO")
    private String email;

    @NotNull(message = "A senha do usuário é obrigatória")
    @Column(name = "SENHA_USUARIO")
    private String senha;

    @NotNull(message = "A data de nascimento do usuário é obrigatória")
    @Column(name ="DATA_USUARIO")
    private LocalDate dataNascimento;

    @NotNull(message = "O CEP do usuário é obrigatório")
    @Column(name = "CEP_USUARIO")
    private String cep;

    @NotNull(message = "O gênero do usuário é obrigatório")
    @Column(name = "GENERO_USUARIO")
    private GeneroEnum genero;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
