package br.com.dbc.aula5.exercicio1;

public class Divisao implements OperacaoMatematica{
    @Override
    public int calcular(int a, int b) {
        return a / b;
    }

    public int calcular(double a, Double b, Double c){
        return (int) (a / b / c);
    }
}
