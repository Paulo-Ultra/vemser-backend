package br.com.dbc.aula7.Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoComida tipoComidaJP = TipoComida.COMIDA_JAPONESA;
        TipoComida tipoComidaFF = TipoComida.FAST_FOOD;
        TipoComida tipoComidaTrad = TipoComida.TRADICIONAL;
        System.out.println("Informe o tipo de comida que deseja comprar: ");
        System.out.println("Para comida japonesa digite '1': ");
        System.out.println("Para fast-food digite '2': ");
        System.out.println("Para comida tradicional digite '3': ");
        System.out.println("Digite '0' para sair");
        int opcao = 0;
        opcao = sc.nextInt();
        if(opcao != 0){
            switch (opcao) {
                case 1 -> {
                    System.out.println("Valor da comida: " + tipoComidaJP.getCusto());
                }
                case 2 -> {
                    System.out.println("Valor da comida: " + tipoComidaFF.getCusto());
                }
                case 3 -> {
                    System.out.println("Valor da comida: " + tipoComidaTrad.getCusto());
                }
                default -> {
                    System.out.println("Número inválido");
                }
            }
        }
    }
}
