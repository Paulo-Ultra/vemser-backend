package br.com.dbc.aula2;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = null;

        while (!"fim".equals(palavra)){
            System.out.println("Escreva uma palavra: ");
            palavra = sc.nextLine();
            System.out.println("A palavra é: " + palavra);
            palavra = palavra.toLowerCase(Locale.ROOT);
        }

//        String palavra = null;
//
//        do {
//                System.out.println("Escreva uma palavra: ");
//                palavra = sc.nextLine();
//                System.out.println("A palavra é: " + palavra);
//                palavra = palavra.toLowerCase(Locale.ROOT);
//            } while (!palavra.equals("fim"));

    }
}
