package aula1;

import java.util.Scanner;

public class MinhaPrimeiraClasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mensagem = "Olá mundo";
        System.out.println(mensagem);
        System.out.println("Olá mundo");
        System.out.println(args);
        System.out.println("Olá turma VemSer 2022/2");

        System.out.println("informe o nome do usuário: ");
        String nomeDoUsuario = scanner.nextLine();

        System.out.println("informe a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        //Mesmo usando o "nextLine" na String é necessário usar antes um "nextLine para não dar erro"
        System.out.println("informe uma String qualquer: ");
        String minhaString = scanner.nextLine();

        System.out.println(nomeDoUsuario);
        System.out.println(idade);
        System.out.println(minhaString);

    }
}
