package br.com.vax.entities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public enum TipoVacinaEnum {
    @DescricaoVacina(nome = "BCG (Bacilo Calmette-Guerin)", descricao = "Previne as formas graves de tuberculose, " +
            "principalmente miliar e meníngea.")
    BCG,
    @DescricaoVacina(nome = "Hepatite B", descricao = "Previne a hepatite B.")
    HepatiteB,
    @DescricaoVacina(nome = "Pentavalente (DTP/HB/Hib)", descricao = "Previne difteria, tétano, coqueluche, hepatite B " +
            "e meningite e infecções por HiB.")
    Pentavalente,
    @DescricaoVacina(nome = "Poliomielite", descricao = "Previne poliomielite ou paralisia infantil.")
    Poliomielite,
    @DescricaoVacina(nome = "Pneumocócica 10V", descricao = "Previne pneumonia, otite, meningite e outras doenças " +
            "causadas pelo Pneumococo.")
    Pneumococica10V,
    @DescricaoVacina(nome = "Vacina rotavírus humano G1P1", descricao = "Previne diarreia por rotavírus.")
    Rotavirus,
    @DescricaoVacina(nome = "Meningocócica C conjugada", descricao = "Previne a doença meningocócica C.")
    MeningococicaC,
    @DescricaoVacina(nome = "Febre amarela", descricao = "Previne a febre amarela.")
    FebreAmarela,
    @DescricaoVacina(nome = "Tríplice viral (sarampo, caxumba e rubéola)", descricao = "Previne sarampo, caxumba e rubéola.")
    TripliceViral,
    @DescricaoVacina(nome = "Hepatite A", descricao = "Previne a hepatite A.")
    HepatiteA,
    @DescricaoVacina(nome = "Tetra viral ou tríplice viral + varicela", descricao = "Previne sarampo, rubéola, " +
            "caxumba e varicela/catapora.")
    TetraViral,
    @DescricaoVacina(nome = "HPV", descricao = "Previne o papiloma, vírus humano que causa cânceres e verrugas " +
            "genitais.")
    HPV,
    @DescricaoVacina(nome = "Dupla Adulto (dT)", descricao = "Previne difteria e tétano.")
    DuplaAdulto,
    @DescricaoVacina(nome = "dTPa (Tríplice bacteriana acelular do tipo adulto)", descricao = "Previne difteria, tétano e coqueluche." +
            "Uma dose a cada gestação a partir da 20ª semana de gestação ou no puerpério (até 45 dias após o parto).")
    dTPa

}
