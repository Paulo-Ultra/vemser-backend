package br.com.dbc.aula1;

public class Operadores {
    public static void main(String[] args) {

        /*
          OPERADORES ARITMÉTICOS
          + : soma
          - : subtração
          / : divisão
          * : multiplicação
          % : módulo / resto da divisão
          ++ : incrementa o valor
          -- : decrementa
          += : soma com o valor que já tem na variável
          -= : diminui com o valor que já tem na variável
          *= : multiplica com o valor que já tem na variável
          /= : divide com o valor que já tem na variável
          */

        // + : soma
        System.out.println(5 + 3);;
        System.out.println("Paulo " + "Ricardo");

        int salarioMeu = 10000;
        int salarioMinhaEsposa = 15000;
        System.out.println(salarioMeu + salarioMinhaEsposa);

        // - : subtração
        System.out.println(100- 30);

        float valor1 = 5.0f;
        double va1 = 5.0;
        int valor2 = 5;
        int res = (int) valor1 + valor2;

        // / : divisão
//        System.out.println(6 / 2);
// Aqui ocorrerá um erro -> System.out.println(6 / 0);
//        System.out.println(6 / 4);
//        System.out.println(6 / 4.0f);

        // * : multiplicação
        System.out.println( 6 * 2);

        // ++ : incrementa o valor
        int numero = 10;
        numero++;
        System.out.println(numero++);
        System.out.println(numero);

        // -- : decrementa
        int numeroDesc = 10;
        numeroDesc--;
        System.out.println(numeroDesc);

        // += : soma com o valor da variável
        int numeroMaisVariavel = 10;
        numeroMaisVariavel += 10;
        System.out.println(numeroMaisVariavel);
        String str = "Paulo ";
        str+= "Ricardo";
        System.out.println(str);

        // -= : subtrai com o valor da variável
        int numeroMenosVariavel = 10;
        numeroMenosVariavel -= 5;
        System.out.println(numeroMenosVariavel);

        // *= : multiplica com o valor da variável
        int numeroVezesVariavel = 10;
        numeroVezesVariavel *= 2;
        System.out.println(numeroVezesVariavel);

        // /= : divide com o valor da variável
        int numeroDivideVariavel = 10;
        numeroDivideVariavel /= 2;
        System.out.println(numeroDivideVariavel);
    }
}
