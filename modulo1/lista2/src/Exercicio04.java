import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetor = new int[3];
        int menor = 0, controle = 999999999;


        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o número: ");
            vetor[i] = sc.nextInt();
            if(vetor[i] < controle) {
                menor = i;
                controle = vetor[i];
            }
        }
        sc.close();
        System.out.println("O menor número é da posição: " + (menor + 1));
    }
}
