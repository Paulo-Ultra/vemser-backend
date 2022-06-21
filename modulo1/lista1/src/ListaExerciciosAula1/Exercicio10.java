package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTotEleitores, votBrancos, votNulos, votValidos;
        double percVotBrancos, percVotNulos, percVotValidos;


        System.out.println("Informe o número total de eleitores:");
        numTotEleitores = sc.nextInt();
        System.out.println("Informe o número total de votos em branco:");
        votBrancos = sc.nextInt();
        System.out.println("Informe o número total de votos nulos:");
        votNulos = sc.nextInt();
        System.out.println("Informe o número total de votos válidos:");
        votValidos = sc.nextInt();

        percVotBrancos = ((double) votBrancos / numTotEleitores) * 100;
        percVotNulos = ((double) votNulos / numTotEleitores) * 100;
        percVotValidos = ((double) votValidos / numTotEleitores) * 100;

        System.out.println("Representação de votos com relação ao número de eleitores:");
        System.out.printf("\n%.2f%% de votos em branco.", percVotBrancos);
        System.out.printf("\n%.2f%% de votos nulos.", percVotNulos);
        System.out.printf("\n%.2f%% de votos validos.", percVotValidos);

    }
}
