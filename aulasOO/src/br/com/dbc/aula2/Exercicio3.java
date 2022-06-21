package br.com.dbc.aula2;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidadeVet;
        int vetor[];
        double media = 0;


        System.out.println("Qual o tamanho do vetor para fazer a media?");
        quantidadeVet = sc.nextInt();
        vetor = new int[quantidadeVet];
        for(int i = 0; i < vetor.length; i++){
            System.out.println("Digite o " + (i + 1) +"º valor: ");
            vetor[i] = sc.nextInt();
            media += vetor[i];
        }

        sc.close();

        media /= vetor.length;
        System.out.printf("A média dos valores é: %.2f", media);

    }
}
