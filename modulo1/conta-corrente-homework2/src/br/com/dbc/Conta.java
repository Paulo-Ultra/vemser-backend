package br.com.dbc;

public abstract class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar(Double valor){
        if(valor <= 0){
            System.out.println("O saque deve ser maior que 0 para efetuar a operação");
            return false;
        } else if (valor > this.getSaldo()){
            System.out.println("Você não tem saldo na conta para sacar");
            return false;
        } else {
            this.setSaldo(getSaldo() - valor);
            System.out.println(String.format("Saque de R$%.2f efetuado com sucesso", valor));
            System.out.println("Seu saldo atual é: R$" + this.saldo);
            return true;
        }
    }

    @Override
    public Boolean depositar(Double valor){
        if(valor <= 0){
            System.out.println("Depósito só pode ser feito com valores acima de 0 reais");
            return false;
        }
        this.setSaldo(getSaldo() + valor);;
        System.out.println(String.format("Depósito de R$%.2f recebido com sucesso", valor));
        System.out.printf("Seu saldo atual é: R$%.2f", getSaldo());
            return true;
    }

    @Override
    public Boolean transferir (Conta conta, Double valor) {
        if (valor <= 0) {
            System.out.println("Valor deve ser maior que R$ 0 para tranferência");
            return false;
        } else if (valor > saldo) {
            System.out.println("Você não tem saldo na conta para transferir");
            return false;
        } else {
            saldo -= valor;
            conta.saldo += valor;
            System.out.println(String.format("Transferência de R$%.2f efetuada com sucesso", valor));
            System.out.println("Seu saldo atual é: R$" + this.saldo);
            return true;
        }
    }
}
