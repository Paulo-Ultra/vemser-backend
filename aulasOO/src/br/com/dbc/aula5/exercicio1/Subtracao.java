package br.com.dbc.aula5.exercicio1;

public class Subtracao implements OperacaoMatematica{

    @Override
    public int calcular(int a, int b) {
        return a - b;
    }

    public int calcular(double a, double b, double c){
        return (int) (a - b - c);
    }
}
