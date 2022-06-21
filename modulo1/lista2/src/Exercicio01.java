import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String produto;
        Double valor = 0.0;
        Double desconto = 5.0;

        System.out.println("Digite o produto: ");
        produto = sc.nextLine();
        System.out.println("Digite o seu valor: ");
        valor = sc.nextDouble();

        Double[] lista = new Double[10];
        for(int i = 0; i < lista.length; i++) {
            lista[i] = valor - (valor * desconto / 100);
            desconto += 5.0;
        }
        System.out.println(produto + " em promoção: ");
        for(int i = 0; i < lista.length; i++) {
            System.out.printf("%d x por R$ %.2f = R$ %.2f%n", i + 1, lista[i], (i + 1) * lista[i]);
        }
        sc.close();
    }
}
