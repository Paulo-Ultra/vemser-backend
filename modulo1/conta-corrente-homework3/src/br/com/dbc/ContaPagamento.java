package br.com.dbc;

public class ContaPagamento extends Conta implements Impressao{
    static final Double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        this.getCliente().imprimirCliente(getCliente());
        System.out.println("------------------\nConta Pagamento:\nCliente: " + getCliente().getNome() +"\nNúmero da Conta: "
                + getNumeroConta() + "\nAgencia: " + this.getAgencia() + "\nSaldo: " + this.getSaldo());
    }
    @Override
    public Boolean sacar(Double valor) {
        if (valor <= 0) {
            System.out.println("O saque deve ser maior que 0 para efetuar a operação");
            return false;
        } else if (valor > this.getSaldo() + TAXA_SAQUE) {
            System.out.println("Você não tem saldo na conta para sacar");
            return false;
        } else {
            this.setSaldo(this.getSaldo() - TAXA_SAQUE - valor);
            return true;
        }
    }

        @Override
        public Boolean transferir(Conta conta, Double valor){
            if (this.sacar(valor)) {
                System.out.println(String.format("Transferência de R$%.2f efetuada com sucesso", valor));
                return conta.depositar(valor);
            } else if (valor > getSaldo()) {
                System.out.println("Você não tem saldo na conta para transferir");
                return false;
            } else {
                System.out.println("Valor deve ser maior que R$ 0 para tranferência");
                return false;
            }
        }
}
