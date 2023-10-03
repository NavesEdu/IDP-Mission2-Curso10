package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    public static ReajusteService service;
    public static Funcionario funcionario;

    @BeforeAll
    public static void inicializarAntes(){
        System.out.println("INICIO");
    }

    @AfterAll
    public static void finalizarDepois(){
        System.out.println("FIM");
    }

    @BeforeEach
    public void init(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Fim");
    }

    @Test
    public void funcionarioComDesempenhoADesejarEReajusteTresPorCento(){
        //ReajusteService service = new ReajusteService();
        //Funcionario funcionario = new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void funcionarioComDesempenhoBomEReajusteQuinzePorCento(){
        //ReajusteService service = new ReajusteService();
        //Funcionario funcionario = new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void funcionarioComDesempenhoOtimoEReajusteVintePorCento(){
        //ReajusteService service = new ReajusteService();
        //Funcionario funcionario = new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }


}
