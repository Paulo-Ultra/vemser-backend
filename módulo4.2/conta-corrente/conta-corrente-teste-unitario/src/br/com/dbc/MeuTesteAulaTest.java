package br.com.dbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeuTesteAulaTest {

    @Test
    public void deveTestarSeOSexoEhMasculino(){
        //setup(Criar nossas variáveis)
        String sexo = "masculino";

        //Act(Método a ser executado) (Ação de Teste)
        boolean ehMasculino = sexo.equalsIgnoreCase("masculino");

        //Assert(Ver se a ação retornou o valor esperado)
        Assertions.assertTrue(ehMasculino);
    }

    @Test
    public void deveTestarSeOSexoNaoEhMasculino(){
        //setup(Criar nossas variáveis)
        String sexo = "feminino";

        //Act(Método a ser executado) (Ação de Teste)
        boolean ehMasculino = sexo.equalsIgnoreCase("masculino");

        //Assert(Ver se a ação retornou o valor esperado)
        Assertions.assertFalse(ehMasculino);
    }

    @Test
    public void deveTestarSoma(){
        //setup(Criar nossas variáveis)
        int v1 = 10;
        int v2 = 20;

        //Act(Método a ser executado) (Ação de Teste)
        int resultado = v1 + v2;

        //Assert(Ver se a ação retornou o valor esperado)
        Assertions.assertEquals(30, resultado);
        Assertions.assertEquals(20, v2);
        Assertions.assertEquals(10, v1);
    }

}
