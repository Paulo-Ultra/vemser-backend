import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] vetor = {5, 7, 8, 11, 34, 22, 5, 35, 99, 100};
        Integer numeroDigitado;
        boolean numeroAchado = false;

        System.out.println("Informe o número para conferir se existe no vetor: ");
        numeroDigitado = sc.nextInt();
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i].equals(numeroDigitado)) {
                System.out.println("Número encontrado na posição: " + i + " do vetor");
                numeroAchado = true;
            }
        }
        if (!numeroAchado) {
            System.out.println("O número informado não existe no vetor.");
        }
        sc.close();
    }
}