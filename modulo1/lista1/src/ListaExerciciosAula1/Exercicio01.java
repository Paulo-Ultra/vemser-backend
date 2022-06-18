package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, cidade, estado;
        int idade;

        System.out.println("Digite o seu nome: ");
        nome = sc.nextLine();
        System.out.println("Digite a sua idade: ");
        idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual a cidade que você reside? ");
        cidade = sc.nextLine();
        System.out.println("Qual o Estado que você reside?");
        estado = sc.nextLine();

        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s."
                ,nome, idade, cidade, estado);

        sc.close();
    }
}
