package aula1;

public class CondicionaisIf {
    public static void main(String[] args) {
        // comando if(se)
        boolean ehSolteiro = true;
//        if(ehSolteiro == true) {
//            System.out.println("É solteiro");
//        }
        if(ehSolteiro) {
            System.out.println("É solteiro");
        }

        // comando else
//        int numero = 9;
//        int restoDaDivisaoPor2 = numero % 2;
//        if(restoDaDivisaoPor2 == 0){  //true
//            System.out.println(numero + " é par");
//        } else {
//            System.out.println(numero + " é ímpar");
//        }

        //comando else if
        int numero = 9;
        int restoDaDivisaoPor2 = numero % 2;
        if(restoDaDivisaoPor2 == 0){
            System.out.println(numero + " é par");
        } else if (restoDaDivisaoPor2 < 0){
            System.out.println( numero + " é negativo");
        } else {
            System.out.println(numero + " é positivo");
        }
    }
}
