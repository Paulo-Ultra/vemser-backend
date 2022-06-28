package br.com.dbc.aula7.Exercicio2;

import br.com.dbc.aula7.DivisaoNegativaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;

        boolean dadosValidados = false;
        while (!dadosValidados) {
            try {
                System.out.println("Digite n1 ");
                n1 = Integer.parseInt(scanner.nextLine()); // 1

                System.out.println("Digite n2 ");
                n2 = Integer.parseInt(scanner.nextLine()); // 0

                System.out.println(dividir(n1, n2));

                dadosValidados = true;
            } catch (InputMismatchException | NumberFormatException ex) {
                ex.printStackTrace();
                System.out.println("Digite novamente as informações");
            } catch (ArithmeticException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println("Executou finally");
                if (dadosValidados) {
                    scanner.close();
                }
            }
        }
    }

    public static int dividir(int numero1, int numero2) throws ArithmeticException {
        return numero1/numero2;
    }

}
