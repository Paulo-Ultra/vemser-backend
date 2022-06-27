package br.com.dbc.aula7;

import java.util.Scanner;

public class Calcular {
    public static void main(String[] args) {
        System.out.println(calcularDivisao(1, 0));
    }

    public static int calcularDivisao(int numero1, int numero2) {
        Scanner scanner = new Scanner(System.in);
        try {
            Integer.parseInt(scanner.nextLine());
            return numero1 / numero2;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            System.out.println("não é possível dividir por zero");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("valor digitado não corresponde ao tipo");
        } finally {
            System.out.println("finally calculo");
        }
        return 0;
    }
}