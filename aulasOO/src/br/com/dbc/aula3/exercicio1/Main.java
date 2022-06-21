package br.com.dbc.aula3.exercicio1;

public class Main {
    public static void main(String[] args) {

        Pessoa paulo = new Pessoa();
        paulo.nome = "Paulo";
        paulo.sobrenome = "Ricardo";
        paulo.idade = 35;
        paulo.whatsApp = "619884516951";

        Pessoa joao = new Pessoa();
        joao.nome = "João";
        joao.sobrenome = "Gabriel";
        joao.idade = 17;
        joao.whatsApp = "6177884854951";

        paulo.conversar(joao);

        System.out.println(joao.retornarNomeCompleto());

        System.out.println(joao.ehMaiorDeIdade());
        System.out.println(paulo.ehMaiorDeIdade());

        paulo.mandaWhatsApp(joao, "Eu sei que você leu...");
    }
}
