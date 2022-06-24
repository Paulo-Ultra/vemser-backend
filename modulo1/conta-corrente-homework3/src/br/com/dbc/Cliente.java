package br.com.dbc;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos_lista;
    private ArrayList<Endereco> enderecos_lista;

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos_lista,ArrayList<Endereco> enderecos_lista) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos_lista = contatos_lista;
        this.enderecos_lista = enderecos_lista;
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

    public ArrayList<Contato> getContatos_lista() {
        return contatos_lista;
    }

    public void setContatos_lista(ArrayList<Contato> contatos_lista) {
        this.contatos_lista = contatos_lista;
    }

    public ArrayList<Endereco> getEnderecos_lista() {
        return enderecos_lista;
    }

    public void setEnderecos_lista(ArrayList<Endereco> enderecos_lista) {
        this.enderecos_lista = enderecos_lista;
    }

    public void imprimirEndereco(){
       for(Endereco endereco : enderecos_lista){
           if(endereco != null){
               endereco.imprimirEndereco();
               System.out.println("\n---------------------");
           }
       }
    }

    public void imprimirContato(){
        for(Contato contato : contatos_lista){
            if(contato != null){
                contato.imprimirContato();
                System.out.println("\n---------------------");
            }
        }
    }

    public void imprimirCliente(Cliente cliente){
        System.out.println("Cliente:\nNome: " + nome + "\nCPF: " + cpf);
    }

    @Override
    public String toString() {
        return "Cliente" +
                "Nome: " + nome + '\'' +
                "CPF: " + cpf;
    }
}
