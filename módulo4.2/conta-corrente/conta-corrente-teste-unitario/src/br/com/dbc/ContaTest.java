package br.com.dbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.00);
        contaCorrente.setChequeEspecial(1000.00);
        double saque = 1500.00;

        //act
        boolean conseguiuSacar = contaCorrente.sacar(saque);


        //assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.00);
        contaCorrente.setChequeEspecial(1000.00);
        double valorSaque = 3000.00;

        //act
        boolean conseguiuSacar = contaCorrente.sacar(valorSaque);

        //assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }
}
