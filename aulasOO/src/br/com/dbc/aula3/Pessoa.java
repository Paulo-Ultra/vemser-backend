package br.com.dbc.aula3;

public class Pessoa {
    String nome;
    int idade;
    Telefone telefone;


    void imprimirDados(){
        System.out.println("Nome: " + nome + " com " + idade + " anos.");
    }

    String retornarIdade(){
        return idade + " anos.";
    }

    void conversar(Pessoa pessoa, String mensagem) {
        //nome = Maicon
        //mensagem = A edição 9 do vem ser está top!
        System.out.println(this.nome + " falou: " + mensagem + " Com " + pessoa.nome);
    }

    void mandarWhatsApp(Pessoa pessoa, String mensagem) {
        System.out.println(this.telefone + " mandou " + mensagem + " para " + pessoa.telefone);
    }

    public String toString(){
        return nome + " - " + this.retornarIdade() + this.telefone;
    }
}
