package br.com.dbc.aula2;

public class Exercicio2 {
    public static void main(String[] args) {
        int somaVet, somaL1, somaL2;
        int[][] matriz = {
                {12, 8},
                {9, 15}
        };
        somaL1 = matriz[0][0] + matriz [0][1];
        somaL2 = matriz[1][0] + matriz[1][1];
        somaVet = somaL1 + somaL2;

        System.out.printf("A soma dos valores da matriz é: %d", somaVet);
        System.out.printf("%nA soma dos valores da primeira linha da matriz é: %d", somaL1);
        System.out.printf("%nA soma dos valores da segunda linha da matriz é: %d", somaL2);
        System.out.println("\nA soma dos valores da primeira linha da matriz menos a soma da segunda linha da matriz é: "
                + (somaL1 - somaL2));

    }
}
