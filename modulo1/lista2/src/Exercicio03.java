import java.util.Locale;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = "", nomeMaisAlto = "", nomeMaisVelho = "", nomePesado = "";
        double altura = 0.0, peso = 0.0, alturaMaior = 0.0, pesoMaisPesado = 0.0, mediaAlturas = 0.0;
        int idade, idadeVelho = 0, numJogadores = 0;

        while(!"SAIR".toUpperCase().equals(nome)){
            System.out.println("+--------------------------------------+");
            System.out.println("| Cadastro de Jogadores de Basquete         |");
            System.out.println("| Para sair digite 'SAIR' ao invés do nome  |");
            System.out.println("+--------------------------------------+");

            System.out.println("Nome: ".toUpperCase(Locale.ROOT));
            nome = sc.nextLine();

            if (nome.toUpperCase().equals("SAIR")){
                break;
            } else {
                numJogadores++;
            }

            System.out.println("Altura: ".toUpperCase(Locale.ROOT));
            altura = sc.nextDouble();
            System.out.println(("Idade: ").toUpperCase(Locale.ROOT));
            idade = sc.nextInt();
            System.out.println("Peso: ".toUpperCase(Locale.ROOT));
            peso = sc.nextDouble();

            sc.nextLine();

            if (altura >= alturaMaior) {
                alturaMaior = altura;
                nomeMaisAlto = nome;
            }
            if (idade >= idadeVelho) {
                idadeVelho = idade;
                nomeMaisVelho = nome;
            }
            if (peso >= pesoMaisPesado) {
                pesoMaisPesado = peso;
                nomePesado = nome;
            }
            mediaAlturas+= altura;
        }
        mediaAlturas /= numJogadores;

        System.out.println("Quantidade de jogadores cadastrados: " + numJogadores);
        System.out.println(String.format("Altura do maior jogador: %.2f. Jogador: %s ", alturaMaior, nomeMaisAlto));
        System.out.println(String.format("Jogador mais velho: %d anos de idade. Jogador: %s", idadeVelho, nomeMaisVelho));
        System.out.println(String.format("Jogador mais pesado: %.2fkg. Jogador: %s", pesoMaisPesado, nomePesado));
        System.out.printf("Média das alturas: %.2f metros", mediaAlturas);

    }
}
