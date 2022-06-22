package br.com.dbc.aula4.exercicio1;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String whatsApp;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public void conversar (Pessoa pessoa) {
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
    public void mandaWhatsApp( Pessoa pessoa, String mensagem){
        System.out.println(this.nome + " enviou: " + mensagem + " para " + pessoa.nome);
    }
}
