package br.com.dbc.aula4.homework.cliente;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;

    void imprimirContaCorrente(){
        System.out.println("Conta Corrente:\nCliente: " + this.cliente + "\nNúmero da Conta: " + numeroConta
        + "\nAgência: " + agencia + "\nSaldo Atual: R$" + saldo + "\nLimite de Cheque Especial: R$" + chequeEspecial);
    }

    public Boolean sacar(Double valor){
        if(valor <= 0){
            System.out.println("O saque deve ser maior que 0 para efetuar a operação");
            return false;
        } else if (valor > retornarSaldoComChequeEspecial()){
            System.out.println("Você não tem saldo na conta para sacar");
            return false;
        } else {
            saldo -= valor;
            System.out.println(String.format("Saque de R$%.2f efetuado com sucesso", valor));
            System.out.println("Seu saldo atual é: R$" + this.saldo);
            return true;
        }
    }
    public Boolean depositar(Double valor){
        if(valor <= 0){
            System.out.println("Depósito só pode ser feito com valores acima de 0 reais");
            return false;
        }
        saldo += valor;
        System.out.println(String.format("Depósito de R$%.2f recebido com sucesso", valor));
        System.out.printf("Seu saldo atual é: R$%.2f", saldo);
            return true;
    }

    public Double retornarSaldoComChequeEspecial(){

        System.out.println("Seu saldo é de: R$ " + this.saldo);
        System.out.println("Seu cheque especial é de: R$ " + this.chequeEspecial);
        double saldoTotal = this.saldo + this.chequeEspecial;
        System.out.println("Saldo total disponível é de: R$ " + saldoTotal);
        return (this.saldo + this.chequeEspecial);
    }

    public Boolean transferir (ContaCorrente contaCorrente, Double valor){
        if(valor <= 0){
            System.out.println("Valor deve ser maior que R$ 0 para tranferência");
            return false;
        } else if (valor > retornarSaldoComChequeEspecial()){
            System.out.println("Você não tem saldo na conta para transferir");
            return false;
        } else {
            saldo -= valor;
            contaCorrente.saldo += valor;
            System.out.println(String.format("Transferência de R$%.2f efetuada com sucesso", valor));
            System.out.println("Seu saldo atual é: R$" + this.saldo);
            return true;
        }
    }
}
