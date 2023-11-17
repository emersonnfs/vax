package br.com.vax.repositories;

import br.com.vax.entities.StatusVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusVacinaRepository extends JpaRepository<StatusVacina, Long> {
    List<StatusVacina> findByUsuarioId(Long id);
}
