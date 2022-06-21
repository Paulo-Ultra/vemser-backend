import java.util.Random;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random numeroRandom = new Random();

        int numEscolhido;
        int numSorteado = numeroRandom.nextInt(1 + 10);
        System.out.println("Advinhe o número de 1 a 10 para ganhar: ");
        System.out.println("Digite seu número: ");
        numEscolhido = sc.nextInt();

        while(numEscolhido != numSorteado){
            if(numEscolhido < numSorteado) {
                System.out.println("Tente um número maior que " + numEscolhido);
            } else {
                System.out.println("Tente um número menor que " + numEscolhido);
            }
            System.out.println("Escolha outro número de 1 a 10: ");
            numEscolhido = sc.nextInt();
        }

        System.out.println("Parabéns o número sorteado foi " + numSorteado + "." );

        sc.close();

    }
}
