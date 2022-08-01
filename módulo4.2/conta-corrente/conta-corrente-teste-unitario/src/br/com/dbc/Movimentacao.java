package br.com.dbc;

public interface Movimentacao {

    Boolean sacar(Double valor);
    Boolean depositar(Double valor);
    Boolean transferir(Conta conta, Double valor);

}
