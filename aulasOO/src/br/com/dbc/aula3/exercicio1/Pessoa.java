package br.com.dbc.aula3.exercicio1;

public class Pessoa {
    String nome;
    String sobrenome;
    Integer idade;
    String whatsApp;

    void conversar (Pessoa pessoa) {
        System.out.println(this.nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto (){
        return nome + " " + sobrenome;
    }

    public boolean ehMaiorDeIdade(){
        if(idade > 18) {
            return true;
        } else{
            return false;
        }
    }
    void mandaWhatsApp( Pessoa pessoa, String mensagem){
        System.out.println(this.nome + " enviou: " + mensagem + " para " + pessoa.nome);
    }
}
