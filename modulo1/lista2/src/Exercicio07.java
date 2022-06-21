import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[][] matriz = new Integer[4][4];
        int cont = 0;


        for (int i = 0; i < matriz.length;i++) {
            for(int j = 0; j < matriz.length; j++){
                System.out.println("Digite o valor para verificar se é maior que 10: ");
                matriz[i][j] = sc.nextInt();
                if (matriz[i][j] > 10){
                    cont += 1;
                }
                System.out.printf("Número digitado: %d %n", matriz[i][j]);
                System.out.println("Quantidade de valores maiores que 10: " + cont);
            }
        }
        sc.close();
    }
}
