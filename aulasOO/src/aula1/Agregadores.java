package aula1;

public class Agregadores {
    public static void main(String[] args) {
          // ! = não ... !ehSolteiro (Não ehSolteiro) PS: se variável estiver TRUE, ela se torna FALSE e vice-versa.
//        boolean ehSolteiro = true;
//        System.out.println(!ehSolteiro);

          //&& = E ... ehSolteiro e temVidaSocial
          //as duas condições tem que ser verdadeiras para o && ser verdadeiro
//        boolean ehSolteiro = true;
//        boolean temVidaSocial = true;
//        System.out.println(ehSolteiro && temVidaSocial);


//        boolean ehSolteiro = true;
//        boolean temVidaSocial = false;
//        System.out.println(ehSolteiro || temVidaSocial);
          // || = OU ... ehSolteiro ou ehCasado
          // Uma das duas condições tem que ser verdadeira para o || ser verdadeiro...
          boolean ehSolteiro = false;
          boolean ehCasado = false;
          System.out.println(ehSolteiro || ehCasado);


    }
}
