package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorPago, valorConsumido;

        System.out.println("Valor consumido: ");
        valorConsumido = sc.nextDouble();
        System.out.println("Valor pago: ");
        valorPago = sc.nextDouble();
        double troco = valorPago - valorConsumido;

        if(valorPago < valorConsumido){
            System.out.println("O valor pago deve ser maior ou igual o valor consumido!");
        } else {
            System.out.println(String.format("O valor consumido foi de: %.2f e o valor pago foi de: %.2f. Seu troco será: R$%.2f", valorConsumido, valorPago, troco));
        }

        sc.close();
    }
}
