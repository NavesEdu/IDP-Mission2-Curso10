package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

public class BonusServiceTest {

    private static BonusService service;

    @BeforeAll
    public static void init(){
        service = new BonusService();
    }

    @Test
    public void bonusDeveriaSerZero(){
        //BonusService service = new BonusService();
//        Assertions.assertThrows(IllegalArgumentException.class,
//                ()-> service.
//                        calcularBonus(new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("25000"))));
        try{
            service.calcularBonus(new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("25000")));
            fail("Não deu a exception");
        } catch(Exception e){
            Assertions.assertEquals("Funcionário com salario maior que 10 mil não recebe bonus", e.getMessage());
        }
    }

    @Test
    public void bonusDeveriaSerDezPorCento(){
        //BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("2500")));
        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil(){
        //BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("aaaaa", LocalDate.now(),new BigDecimal("10000")));
        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
