package Homework;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a 1ª data para comparar:");
        LocalDate data1 = LocalDate.parse(sc.nextLine());
        System.out.println("Informe a 2ª data para comparar:");
        LocalDate data2 = LocalDate.parse(sc.nextLine());
        Period periodo = Period.between(data1, data2);
        System.out.println("Diferença de " + periodo.getYears() + " Anos, " + periodo.getMonths() + " meses, "
                 + periodo.getDays() + " dias");
    }
}
