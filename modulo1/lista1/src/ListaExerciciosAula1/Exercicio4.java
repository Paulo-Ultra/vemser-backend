package ListaExerciciosAula1;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int estado, cidade;

        System.out.println("Digite o número do Estado escolhido: \n1 - Distrito Federal" +
                "\n2 - Minas Gerais \n3 - Bahia");
        estado = sc.nextInt();
        switch (estado) {
            case 1 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - Brasília" +
                        "\n2 - Ceilândia");
                cidade = sc.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("Brasília/Distrito Federal \nPopulação: 3.094.325 milhões de habitantes " +
                                "\nPrincipal festa: Festival Brasília de Cultura Popular \nIDH: 0,783");
                    }
                    case 2 -> {
                        System.out.println("Ceilândia/Distrito Federal \nPopulação: 400 mil habitantes " +
                                "\nPrincipal festa: O maior São João do cerrado \nIDH: 0,850");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }
            }
            case 2 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - Uberaba" +
                        "\n2 - Uberlândia");
                cidade = sc.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("Uberaba/Minas Gerais \nPopulação: 337.092 mil habitantes " +
                                "\nPrincipal festa: Festa do 13 de maio \nIDH: 0,772");
                    }
                    case 2 -> {
                        System.out.println("Uberlândia/Minas Gerais \nPopulação: 699.097 mil habitantes " +
                                "\nPrincipal festa: O Congado de Uberlândia \nIDH: 0,789");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }

            }
            case 3 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - São Gabriel" +
                        "\n2 - Salvador");
                cidade = sc.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("São Gabriel/Bahia \nPopulação: 18.785 mil habitantes " +
                                "\nPrincipal festa: Festa Junina \nIDH: 0,592");
                    }
                    case 2 -> {
                        System.out.println("Salvador/Bahia \nPopulação: 2.900.319 milhões de habitantes " +
                                "\nPrincipal festa: Carnaval \nIDH: 0,673");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }
            }
        }

    }
}
