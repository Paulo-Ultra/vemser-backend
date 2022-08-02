package br.com.dbc;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatosLista;
    private ArrayList<Endereco> enderecosLista;

    public Cliente(){}

    public Cliente(String nome, String cpf, ArrayList<Contato> contatosLista,ArrayList<Endereco> enderecosLista) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatosLista = contatosLista;
        this.enderecosLista = enderecosLista;
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

    public ArrayList<Contato> getContatosLista() {
        return contatosLista;
    }

    public void setContatosLista(ArrayList<Contato> contatosLista) {
        this.contatosLista = contatosLista;
    }

    public ArrayList<Endereco> getEnderecosLista() {
        return enderecosLista;
    }

    public void setEnderecosLista(ArrayList<Endereco> enderecosLista) {
        this.enderecosLista = enderecosLista;
    }

    public void imprimirEndereco(){
        if(enderecosLista != null){
            for(Endereco endereco : enderecosLista) {
                if (endereco != null) {
                    endereco.imprimirEndereco();
                    System.out.println("\n---------------------");
                }
            }
        }
    }

    public void imprimirContato() {
        if (contatosLista != null) {
            for (Contato contato : contatosLista) {
                if (contato != null) {
                    contato.imprimirContato();
                    System.out.println("\n---------------------");
                }
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
