package br.com.dbc;

public interface Movimentacao {

    public Boolean sacar(Double valor);
    public Boolean depositar(Double valor);
    public Boolean transferir(Conta conta, Double valor);

}
