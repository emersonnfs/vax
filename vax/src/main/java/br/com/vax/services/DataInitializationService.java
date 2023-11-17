package br.com.vax.services;

import br.com.vax.controllers.UsuarioController;
import br.com.vax.entities.*;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DataInitializationService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    PasswordEncoder encoder;

    public void initializeData() {
        if (vacinaRepository.count() == 0) {
            //Vacinas BCG
            Vacina vacina1 = new Vacina(1L, "BCG", TipoVacinaEnum.BCG, CategoriaVacinaEnum.Criança,
                    TipoDoseVacinaEnum.DoseUnica,null);

            //Vacinas Hepatite B
            Vacina vacina2 = new Vacina(2L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Criança,
                    TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina3 = new Vacina(3L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adolescente
                    ,TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina4 = new Vacina(4L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adolescente
                    ,TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina5 = new Vacina(5L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adolescente
                    ,TipoDoseVacinaEnum.TerceiraDose,null);
            Vacina vacina6 = new Vacina(6L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adulto
                    ,TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina7 = new Vacina(7L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adulto
                    ,TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina8 = new Vacina(8L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Adulto
                    ,TipoDoseVacinaEnum.TerceiraDose,null);
            Vacina vacina9 = new Vacina(9L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Idoso
                    ,TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina10 = new Vacina(10L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Idoso
                    ,TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina11 = new Vacina(11L, "Hepatite B", TipoVacinaEnum.HepatiteB, CategoriaVacinaEnum.Idoso
                    ,TipoDoseVacinaEnum.TerceiraDose,null);

            //Vacinas Pentavalente
            Vacina vacina12 = new Vacina(12L, "Pentavalente (DTP/HB/Hib)", TipoVacinaEnum.Pentavalente,
                    CategoriaVacinaEnum.Criança
                    ,TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina13 = new Vacina(13L, "Pentavalente (DTP/HB/Hib)", TipoVacinaEnum.Pentavalente,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina14 = new Vacina(14L, "Pentavalente (DTP/HB/Hib)", TipoVacinaEnum.Pentavalente,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.TerceiraDose,null);
            Vacina vacina15 = new Vacina(15L, "DTP", TipoVacinaEnum.Pentavalente,
                    CategoriaVacinaEnum.Criança
                    ,TipoDoseVacinaEnum.PrimeiroReforco,null);
            Vacina vacina16 = new Vacina(16L, "DTP", TipoVacinaEnum.Pentavalente,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundoReforco,null);

            //Vacinas Poliomielite
            Vacina vacina17 = new Vacina(17L, "VIP (Poliomielite inativada)", TipoVacinaEnum.Poliomielite,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina18 = new Vacina(18L, "VIP (Poliomielite inativada)", TipoVacinaEnum.Poliomielite,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina19 = new Vacina(19L, "VIP (Poliomielite inativada)", TipoVacinaEnum.Poliomielite,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.TerceiraDose,null);
            Vacina vacina20 = new Vacina(20L, "Poliomielite oral VOP", TipoVacinaEnum.Poliomielite,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiroReforco,null);
            Vacina vacina21 = new Vacina(21L, "Poliomielite oral VOP", TipoVacinaEnum.Poliomielite,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundoReforco,null);

            //Vacinas Pneumocócica 10V
            Vacina vacina22 = new Vacina(22L,"Pneumocócica 10V", TipoVacinaEnum.Pneumococica10V,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina23 = new Vacina(23L,"Pneumocócica 10V", TipoVacinaEnum.Pneumococica10V,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina24 = new Vacina(24L,"Pneumocócica 10V", TipoVacinaEnum.Pneumococica10V,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiroReforco,null);

            //Vacinas Rotavirus
            Vacina vacina25 = new Vacina(25L, "Vacina rotavírus humano G1P1", TipoVacinaEnum.Rotavirus,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina26 = new Vacina(26L, "Vacina rotavírus humano G1P1", TipoVacinaEnum.Rotavirus,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundaDose,null);

            //Vacinas Monigácia C
            Vacina vacina27 = new Vacina(27L, "Meningocócica C conjugada", TipoVacinaEnum.MeningococicaC,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina28 = new Vacina(28L, "Meningocócica C conjugada", TipoVacinaEnum.MeningococicaC,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina29 = new Vacina(29L, "Meningocócica C conjugada", TipoVacinaEnum.MeningococicaC,
                    CategoriaVacinaEnum.Adolescente, TipoDoseVacinaEnum.DoseUnica,null);

            //Vacinas Febre Amarela
            Vacina vacina30 = new Vacina(30L, "Febre amarela", TipoVacinaEnum.FebreAmarela,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.DoseUnica,null);
            Vacina vacina31 = new Vacina(31L, "Febre amarela", TipoVacinaEnum.FebreAmarela,
                    CategoriaVacinaEnum.Adolescente, TipoDoseVacinaEnum.DoseUnica,null);
            Vacina vacina32 = new Vacina(32L, "Febre amarela", TipoVacinaEnum.FebreAmarela,
                    CategoriaVacinaEnum.Adulto, TipoDoseVacinaEnum.DoseUnica,null);
            Vacina vacina33 = new Vacina(33L, "Febre amarela", TipoVacinaEnum.FebreAmarela,
                    CategoriaVacinaEnum.Idoso, TipoDoseVacinaEnum.DoseUnica,null);

            //Vacinas Tríplice Viral
            Vacina vacina34 = new Vacina(34L, "Tríplice viral (sarampo, caxumba e rubéola)",
                    TipoVacinaEnum.TripliceViral,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina35 = new Vacina(35L, "Tríplice viral (sarampo, caxumba e rubéola)",
                    TipoVacinaEnum.TripliceViral,
                    CategoriaVacinaEnum.Adolescente, TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina36 = new Vacina(36L, "Tríplice viral (sarampo, caxumba e rubéola)",
                    TipoVacinaEnum.TripliceViral,
                    CategoriaVacinaEnum.Adolescente, TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina37 = new Vacina(37L, "Tríplice viral (sarampo, caxumba e rubéola)",TipoVacinaEnum.TetraViral,
                    CategoriaVacinaEnum.Adulto, TipoDoseVacinaEnum.DoseUnica,null);

            //Vacinas Hepatite A
            Vacina vacina38 = new Vacina(38L, "Hepatite A", TipoVacinaEnum.HepatiteA,
                    CategoriaVacinaEnum.Criança, TipoDoseVacinaEnum.DoseUnica,null);

            //Vacinas HPV
            Vacina vacina39 = new Vacina(39L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Adolescente,
                    TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina40 = new Vacina(40L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Adolescente,
                    TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina41 = new Vacina(41L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Adulto,
                    TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina42 = new Vacina(42L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Adulto,
                    TipoDoseVacinaEnum.SegundaDose,null);
            Vacina vacina43 = new Vacina(43L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Idoso,
                    TipoDoseVacinaEnum.PrimeiraDose,null);
            Vacina vacina44 = new Vacina(44L, "HPV", TipoVacinaEnum.HPV, CategoriaVacinaEnum.Idoso,
                    TipoDoseVacinaEnum.SegundaDose,null);

            //Vacinas Dupla Adulto
            Vacina vacina45 = new Vacina(45L, "Dupla Adulto (dT)", TipoVacinaEnum.DuplaAdulto,
                    CategoriaVacinaEnum.Adolescente, TipoDoseVacinaEnum.Periodica,null);
            Vacina vacina46 = new Vacina(46L, "Dupla Adulto (dT)", TipoVacinaEnum.DuplaAdulto,
                    CategoriaVacinaEnum.Adulto, TipoDoseVacinaEnum.Periodica,null);
            Vacina vacina47 = new Vacina(47L, "Dupla Adulto (dT)", TipoVacinaEnum.DuplaAdulto,
                    CategoriaVacinaEnum.Idoso, TipoDoseVacinaEnum.Periodica,null);

            //Vacinas dTPa
            Vacina vacina48 = new Vacina(48L, "dTPa (Tríplice bacteriana acelular do tipo adulto)", TipoVacinaEnum.dTPa,
                    CategoriaVacinaEnum.Gestante, TipoDoseVacinaEnum.DoseUnica,null);

            vacinaRepository.saveAll(List.of(vacina1, vacina2, vacina3, vacina4, vacina5, vacina6, vacina7, vacina8, vacina9, vacina10,
                    vacina11, vacina12, vacina13, vacina14, vacina15, vacina16, vacina17, vacina18, vacina19, vacina20, vacina21,
                    vacina22, vacina23, vacina24, vacina25, vacina26, vacina27, vacina28, vacina29, vacina30, vacina31, vacina32,
                    vacina33, vacina34, vacina35, vacina36, vacina37, vacina38, vacina39, vacina40, vacina41, vacina42, vacina43,
                    vacina44, vacina45, vacina46, vacina47, vacina48));


        }

        if(usuarioRepository.count() == 0){
            //Usuários todas as idades
            Usuario usuario1 = new Usuario(1L, "João", "joão@email.com", "senha123",
                    LocalDate.of(2020,1,1), "12345678", GeneroEnum.Masculino,null);
            Usuario usuario2 = new Usuario(2L, "Maria", "maria@email.com", "senha123",
                    LocalDate.of(2010,1,1), "98765432", GeneroEnum.Feminino,null);
            Usuario usuario3 = new Usuario(3L, "José", "jose@email", "senha123",
                    LocalDate.of(1990,1,1), "75465358", GeneroEnum.Masculino,null);
            Usuario usuario4 = new Usuario(4L, "Ana", "ana@email.com", "senha123",
                    LocalDate.of(1960,1,1), "01789258", GeneroEnum.Feminino,null);

            usuarioController.registrar(usuario1);
            usuarioController.registrar(usuario2);
            usuarioController.registrar(usuario3);
            usuarioController.registrar(usuario4);
        }
    }
}
