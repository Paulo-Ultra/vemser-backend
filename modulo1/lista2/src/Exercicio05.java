import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[20];

        for(int i = 0; i < numeros.length; i++){
        System.out.print("Digite o " + (i+1) + "º valor: ");
        numeros[i] = sc.nextInt();
    }
        System.out.println("Ordem inversa dos números digitados: ");
        for(int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[(numeros.length - 1) - i] + " ");
        }

        sc.close();
    }
}
