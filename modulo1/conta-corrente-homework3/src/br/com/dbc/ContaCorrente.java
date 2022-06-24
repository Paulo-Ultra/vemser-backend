package br.com.dbc;

public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial;

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public Boolean sacar(Double valor){
        if(valor <= 0){
            System.out.println("O saque deve ser maior que 0 para efetuar a operação");
            return false;
        } else if (valor > retornarSaldoComChequeEspecial()){
            System.out.println("Você não tem saldo na conta para sacar");
            return false;
        } else {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
    }

    public Double retornarSaldoComChequeEspecial(){
        System.out.println("Seu saldo é de: R$ " + this.getSaldo());
        System.out.println("Seu cheque especial é de: R$ " + this.chequeEspecial);
        double saldoTotal = this.getSaldo() + this.chequeEspecial;
        System.out.println("Saldo total disponível é de: R$ " + saldoTotal);
        return saldoTotal;
    }

    @Override
    public void imprimir(){
        System.out.println("------------------\nConta Corrente:\nCliente: " + getCliente().getNome()
                + "\nNumero da conta: " + this.getNumeroConta() + "\nAgencia: " + this.getAgencia() + "\nSaldo: "
                + this.getSaldo() + "\nCheque Especial: "+ this.chequeEspecial);
    }
}
