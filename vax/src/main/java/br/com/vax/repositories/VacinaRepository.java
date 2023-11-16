package br.com.vax.repositories;

import br.com.vax.entities.CategoriaVacinaEnum;
import br.com.vax.entities.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.catalog.Catalog;
import java.util.List;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long>{
    @Query("SELECT v FROM Vacina v WHERE v.categoria = :categoria")
    List<Vacina> findByCategoriaVacinaEnum(CategoriaVacinaEnum categoria);
}
