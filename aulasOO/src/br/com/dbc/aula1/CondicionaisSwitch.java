package br.com.dbc.aula1;

public class CondicionaisSwitch {
    public static void main(String[] args) {

        //comando switch
        int sorteado = 1;

        switch (sorteado) {
            case 5:
                System.out.println("Ganhou um tesla");
                break;
            case 2:
                System.out.println("Ganhou uma casa na praia de frente ao mar");
                break;
            case 10:
                System.out.println("Ganhou um halls de cereja");
                break;
            default:
                System.out.println("Infelizmente não foi dessa vez...");
                break;
        }

        sorteado = 5;
        switch (sorteado) {
            case 5 -> {
                    System.out.println("Ganhou um tesla");
            }
            case 2 -> {
                    System.out.println("Ganhou uma casa na praia de frente ao mar");
                }
            case 10 -> {
                System.out.println("Ganhou um halls de cereja");
            }
            default -> {
                System.out.println("Infelizmente não foi dessa vez...");
            }
          //        var teste = "";
//        teste = 1;
        }
    }
}
