package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1, nota2, nota3, nota4, media;

        System.out.println("Digite a primeira nota: ");
        nota1 = sc.nextDouble();
        System.out.println("Digite a segunda nota: ");
        nota2 = sc.nextDouble();
        System.out.println("Digite a terceira nota: ");
        nota3 = sc.nextDouble();
        System.out.println("Digite a quarta nota: ");
        nota4 = sc.nextDouble();
        media = (nota1 + nota2 + nota3 + nota4) / 4;

        if(media <= 5){
            System.out.printf("Sua nota é: %.2f. Aluno(a) reprovado(a)!", media);
        } else if (media >= 5.1 && media <= 6.9){
            System.out.printf("Sua nota é: %.2f. Aluno(a) em exame!", media);
        } else {
            System.out.printf("Sua nota é: %.2f. Aluno(a) aprovado(a)!", media);
        }

        sc.close();
    }
}
