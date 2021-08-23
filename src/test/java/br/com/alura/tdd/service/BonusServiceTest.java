package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

//        try {
//            Assertions.assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
//            fail("Não deu Exception!");
//        }catch (Exception e){
//            Assertions.assertEquals("Funcionario com salario maior que R$ 10.000.", e.getMessage());
//        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService bonusService= new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BonusService bonusService= new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }


}
