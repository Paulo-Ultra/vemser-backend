package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double baseRetang, alturaRetang, areaRetang;

        System.out.println("Digite o tamanho da base do Retângulo: ");
        baseRetang = sc.nextDouble();
        System.out.println("Digite o tamanho da altura do Retângulo: ");
        alturaRetang = sc.nextDouble();

        areaRetang = baseRetang * alturaRetang;
        System.out.println(String.format("A área do Retângulo é: %.2f", areaRetang));

    }
}
