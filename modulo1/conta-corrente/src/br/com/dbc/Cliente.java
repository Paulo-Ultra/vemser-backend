package br.com.dbc;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new  Endereco[2];

    void imprimirEndereco(){
       for(int i = 0; i < enderecos.length; i++){
           if(contatos[i] != null){
               enderecos[i].imprimirEndereco();
               System.out.println(i + 1 +"º Endereço\n---------------------");
           }
       }
    }

    void imprimirContato(){
        for(int i = 0; i < contatos.length; i++){
            if(contatos[i] != null) {
                contatos[i].imprimirContato();
                System.out.println(i+ 1 +"º Contato\n---------------------");
            }
        }
    }

    void imprimirCliente(Cliente cliente){
        System.out.println("Cliente:\nNome: " + nome + "\nCPF: " + cpf);
    }

    @Override
    public String toString() {
        return nome;
    }
}
