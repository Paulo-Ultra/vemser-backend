package br.com.dbc.aula4.exercicio1;

public class Main {
    public static void main(String[] args) {

        Pessoa paulo = new Pessoa();
        paulo.setNome("Paulo");
        paulo.setSobrenome ("Ricardo");
        paulo.setIdade (35);
        paulo.setWhatsApp ("619884516951");

        Pessoa joao = new Pessoa();

        joao.setNome("João");
        joao.setSobrenome ("Gabriel");
        joao.setIdade (17);
        joao.setWhatsApp ("6177884854951");

        System.out.println(paulo.getNome());
        System.out.println(paulo.getSobrenome());
        System.out.println(paulo.getIdade());
        System.out.println(paulo.getWhatsApp());
        System.out.println("---------------------");
        System.out.println(joao.getNome());
        System.out.println(joao.getSobrenome());
        System.out.println(joao.getIdade());
        System.out.println(joao.getWhatsApp());

//        paulo.conversar(joao);
//
//        System.out.println(joao.retornarNomeCompleto());
//
//        System.out.println(joao.ehMaiorDeIdade());
//        System.out.println(paulo.ehMaiorDeIdade());
//
//        paulo.mandaWhatsApp(joao, "Eu sei que você leu...");
    }
}
