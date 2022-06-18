package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorDaHora, horaNormalTrabalhada, horaExtra50, horaExtra100, salarioBruto;

        System.out.println("Digite o valor da hora trabalhada: ");
        valorDaHora = sc.nextDouble();
        System.out.println("Digite o número de horas trabalhadas: ");
        horaNormalTrabalhada = sc.nextDouble();
        System.out.println("Digite o número de horas extras com 50% de acréscimo: ");
        horaExtra50 = sc.nextDouble();
        System.out.println("Digite o número de horas extras com 100% de acréscimo: ");
        horaExtra100 = sc.nextDouble();

        salarioBruto = (horaNormalTrabalhada * valorDaHora) + (horaExtra50 * horaNormalTrabalhada * 1.5)
                + (horaExtra100 * valorDaHora * 2);

        System.out.println(String.format("O salário bruto é: R$%.2f", salarioBruto));
    }
}
