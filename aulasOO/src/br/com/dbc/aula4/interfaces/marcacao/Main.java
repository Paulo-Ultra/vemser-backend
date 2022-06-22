package br.com.dbc.aula4.interfaces.marcacao;

public class Main {
    public static void main(String[] args) {
        Coordenador coodernador = new Coordenador(10000);
        double bonusColaborador = CalculoSalarioColaborador.calcularBonusColaborador(coodernador);
        System.out.printf("R$%.2f", coodernador.getSalario() * bonusColaborador);
    }
}