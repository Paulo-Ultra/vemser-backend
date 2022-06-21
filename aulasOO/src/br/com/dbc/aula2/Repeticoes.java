package br.com.dbc.aula2;

import java.util.Scanner;

public class Repeticoes {
    public static void main(String[] args) {

//        System.out.println("Iniciou o for");
//        for (int variavelControle = 0; variavelControle < 5; variavelControle++){
//            System.out.println(variavelControle);
//        }
//        System.out.println("Finalizou o for");
//        System.out.println("");
//
//        int[] notas ={10, 5, 4, 8};
////       o que couber ou for maior que o int pode ser usado Ex: for (float nota: notas) {
//        for (int nota: notas) {
//            System.out.println(nota);
//        }
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite um número: ");
//        int numero = sc.nextInt();
//        sc.nextLine();
//
//        while (numero != 0){
//            System.out.println("O número é: " + numero);
//            System.out.println("Digite um número: ");
//            numero = sc.nextInt();
//            sc.nextLine();
//        }
//        System.out.println("Fim do laço");

        int numero = 0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite um número: ");
            numero = sc.nextInt();
            sc.nextLine();
        } while(numero != 0);

        System.out.println("Fim do laço");
    }
}
