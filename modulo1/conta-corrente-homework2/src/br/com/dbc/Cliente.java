package br.com.dbc;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new  Endereco[2];

    public Cliente(String nome, String cpf, Contato contatos, Contato contatos1, Endereco enderecos, Endereco enderecos1) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contatos;
        this.contatos[1] = contatos1;
        this.enderecos[0] = enderecos;
        this.enderecos[1] = enderecos1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirEndereco(){
       for(int i = 0; i < enderecos.length; i++){
           if(enderecos[i] != null){
               enderecos[i].imprimirEndereco();
               System.out.println(i + 1 +"º Endereço\n---------------------");
           }
       }
    }

    public void imprimirContato(){
        for(int i = 0; i < contatos.length; i++){
            if(contatos[i] != null) {
                contatos[i].imprimirContato();
                System.out.println(i+ 1 +"º Contato\n---------------------");
            }
        }
    }

    public void imprimirCliente(Cliente cliente){
        System.out.println("Cliente:\nNome: " + nome + "\nCPF: " + cpf);
    }

    @Override
    public String toString() {
        return nome;
    }
}
