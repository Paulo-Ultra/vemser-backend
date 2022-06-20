package aula1;

public class Comparadores {
    public static void main(String[] args) {

         /*
          COMPARADORES
          == : variavel é igual a outraVariavel
          != : variavel é diferente da outraVariavel
          < : variável (< menor) outraVariavel
          > : variável (> maior) outraVariavel
          >= : variável (>= maior ou igual) outraVariavel
          <= : variável (<= menor ou igual) outraVariavel
          */

        // == : variável é igual a outra Variável
        System.out.println(1 == 1);
        System.out.println(2 == 1);
        boolean pagaPensao = false;
        System.out.println(pagaPensao == true);
// Compara se o tipo for igual, se não dá erro        System.out.println(1 == "1");

        // != : variável é diferente da outra Variável
        System.out.println(1 != 2);
        System.out.println(1 != 1);
        boolean ehCasado = true;
        System.out.println(ehCasado != false);

        // < : variável (< menor que) outra variável
        System.out.println(10 < 2);
        System.out.println(10 < 20);

        // > : variável (> maior que) outra variável
        System.out.println(10 > 2);
        System.out.println(10 > 20);

        // >= : variável (>= maior ou igual) outra variável
        System.out.println(10 >= 10);
        System.out.println(10 >= 9);
        System.out.println(10 >= 20);

        // <= : variável (<= menor ou igual) outra variável
        System.out.println(9 <= 9);
        System.out.println(9 <= 20);
        System.out.println(9 <= 8);
    }
}
