package br.com.dbc;

public class Contato {
    String descricao;
    String telefone;
    Integer tipo;

    void imprimirContato(){
        if(tipo == 1) {
            System.out.println("Contato:\nDescrição: " + descricao + "\nTelefone: " + telefone
                    + "\nTipo - Telefone Residencial: " + tipo);
        } else if(tipo == 2){
            System.out.println("Contato:\nDescrição: " + descricao + "\nTelefone: " + telefone
                    + "\nTipo - Telefone Comercial: " + tipo);
        } else {
            System.out.println("Número inválido, digite um tipo de contato correto.");
        }
    }
}
