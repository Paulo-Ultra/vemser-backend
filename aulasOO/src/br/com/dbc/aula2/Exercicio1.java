package br.com.dbc.aula2;

public class Exercicio1 {
    public static void main(String[] args) {
        int soma;
        double media;
        int[]vetor = {5, 17, 7};
        soma = vetor[0] + vetor[1] + vetor[2];
//        media = (double) soma / 3;
        media = soma / 3.0;

        System.out.println("A soma dos valores do vetor é: " + soma);
        System.out.println(String.format("A média é %.2f", media));
    }
}
