package br.com.dbc.aula5.exercicio1;

public class Soma implements OperacaoMatematica{

    @Override
    public int calcular(int a, int b) {
        return a + b;
    }

    public int calcular(double a, double b, double c) {
        return (int) ((int) a + b + c);
    }
}
