package br.com.dbc;

public class ContaPoupanca extends Conta implements Impressao {

    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(){}
    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir(){
        System.out.println("------------------\nConta Poupança:\nCliente: " + getCliente().getNome() +"\nNúmero da Conta: "
        + getNumeroConta() + "\nAgencia: " + this.getAgencia() + "\nSaldo: " + this.getSaldo()
        + "\nJuros mensal: " + JUROS_MENSAL);
    }
}
