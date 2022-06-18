package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idadeEmAnos, idadeEmMeses, idadeEmDias, totalEmDias;

        System.out.println("Informe sua idade em anos:");
        idadeEmAnos = sc.nextInt();
        System.out.println("Informe sua idade em meses:");
        idadeEmMeses = sc.nextInt();
        System.out.println("Informe sua idade em dias:");
        idadeEmDias = sc.nextInt();

        totalEmDias = idadeEmDias + (idadeEmMeses * 30) + (idadeEmAnos * 365);
        System.out.println("Sua idade total em dias é: " + totalEmDias + " dias");

    }
}
