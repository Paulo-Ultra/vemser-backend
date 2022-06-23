package br.com.dbc;

public class Contato {
    private String descricao;
    private String telefone;
    private Integer tipo;

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato(){
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
