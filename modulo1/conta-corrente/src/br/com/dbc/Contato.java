package br.com.dbc;

public class Contato {
    String descricao;
    String telefone;
    Integer tipo;

    void imprimirContato(){
        if(tipo == 1) {
            System.out.println("Contato:\nDescrição: " + descricao + "\nTelefone: " + telefone
                    + "\nTipo - Telefone Residencial: " + tipo);
        } else {
            System.out.println("Contato:\nDescrição: " + descricao + "\nTelefone: " + telefone
                    + "\nTipo - Telefone Comercial: " + tipo);
        }
    }
}
