package br.com.dbc.aula5.exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {

        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();
        Divisao divisao = new Divisao();
        Multiplicacao multiplicacao = new Multiplicacao();

        System.out.println(soma.calcular(5.7,5.8,5.0));
        System.out.println(subtracao.calcular(10.8, 5.2, 8.0));
        System.out.println(divisao.calcular(50.0, 6.0, 3.0));
        System.out.println(multiplicacao.calcular(5.7,5.8,5.0));


    }
}
