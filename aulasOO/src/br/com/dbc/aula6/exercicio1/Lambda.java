package br.com.dbc.aula6.exercicio1;

import br.com.dbc.aula6.Funcao;

public class Lambda {
    public static void main(String[] args) {

        Calculo calculoSoma = (valor1, valor2) -> valor1 + valor2;
        System.out.println(calculoSoma.calcular(8, 9));

        Calculo calculoSubtrai = (valor1, valor2) -> valor1 - valor2;
        System.out.println(calculoSubtrai.calcular(19, 9));

        Calculo calculoMultiplica = (valor1, valor2) -> valor1 * valor2;
        System.out.println(calculoMultiplica.calcular(5, 5));

        Calculo calculoDivide = (valor1, valor2) -> valor1 / valor2;
        System.out.println(calculoDivide.calcular(8, 4));

    }
}
