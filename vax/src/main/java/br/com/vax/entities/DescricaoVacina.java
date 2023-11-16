package br.com.vax.entities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DescricaoVacina {
    String nome();
    String descricao();
}
