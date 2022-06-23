package br.com.dbc;

public class Main {
    public static void main(String[] args) {

        Endereco enderecoMaicon = new Endereco(1, "Rua Presidente Dutra", 9
                , "Esquina com Adalberto Barreto", "44915-000", "São Gabriel"
                , "Bahia", "Brasil");
        Endereco enderecoMaicon1 = new Endereco(2, "Avenida São Jorge", 701
                , "Apartamento", "33915-000", "Vila Velha"
                , "Santa Catarina", "Brasil");
        Endereco enderecoPaulo = new Endereco(1, "Rua Getulio Vargas", 54
                , "Centro", "01112-000", "São Paulo"
                , "São Paulo", "Brasil");
        Endereco enderecoPaulo1 = new Endereco(2, "Avenida dos Milagres", 178
                , "", "77115-000", "Recife", "Pernambuco", "Brasil");

//        //Método da Classe Endereço
        enderecoPaulo.imprimirEndereco();
        System.out.println("----------------------------------");

        Contato contatoMaicon = new Contato("Somente WhatsApp", "(51)98757-5848", 2);
        Contato contatoMaicon1 = new Contato("Instrutor da DBC", "\"(51)98757-5848", 1);

        Contato contatoPaulo = new Contato("WhatsApp", "(61)98888-5731", 1);
        Contato contatoPaulo1 = new Contato("Telefone para ligação", "(61)954128-5731", 1);

        //Método da Classe Contato
        contatoPaulo.imprimirContato();
        System.out.println("----------------------------------");

        Cliente clienteMaicon = new Cliente("Maicon", "720.968.440-96", contatoMaicon, contatoMaicon1
                , enderecoMaicon, enderecoMaicon1);

        Cliente clientePaulo = new Cliente("Paulo", "970.467.670-09", contatoPaulo, contatoPaulo1
                , enderecoPaulo, enderecoPaulo1);

//        //Métodos da Classe Cliente
        clienteMaicon.imprimirCliente(clienteMaicon);
        System.out.println("----------------------------------");
        clienteMaicon.imprimirEndereco();
        System.out.println("----------------------------------");
        clienteMaicon.imprimirContato();
        System.out.println("----------------------------------");
        clientePaulo.imprimirCliente(clientePaulo);
        System.out.println("----------------------------------");
        clientePaulo.imprimirEndereco();
        System.out.println("----------------------------------");
        clientePaulo.imprimirContato();
        System.out.println("----------------------------------");

        ContaCorrente contaCorrente = new ContaCorrente(clienteMaicon, "1451-X", "1710", 1000.00, 200.00);
        ContaCorrente contaCorrente1 = new ContaCorrente(clientePaulo, "54558-0", "1888", 200.00, 800.00);

//        //Métodos da ContaCorrente
        contaCorrente.imprimir();
        System.out.println("---------------------");
        contaCorrente.sacar(200.00);
        contaCorrente.depositar(50.00);
        contaCorrente.retornarSaldoComChequeEspecial();
        contaCorrente.transferir(contaCorrente1, 500.00);
        contaCorrente.imprimir();
        System.out.println("-------------------------------");

        contaCorrente1.imprimir();
        System.out.println("---------------------");
        contaCorrente1.sacar(200.00);
        //Teste caso deposite valor além do disponível e sacar nada (0)
        contaCorrente1.sacar(5000.00);
        contaCorrente1.sacar(0.0);
        contaCorrente1.depositar(50.00);
        //Teste caso deposite valor além do disponível, zero ou negativo
        contaCorrente1.depositar(0.0);
        contaCorrente1.depositar(2000.00);
        contaCorrente1.depositar(-5.0);
        contaCorrente1.retornarSaldoComChequeEspecial();
        contaCorrente1.transferir(contaCorrente, 100.00);
        //Teste Transferência valores além do disponível, zero ou negativo
        contaCorrente1.transferir(contaCorrente, 0.0);
        contaCorrente1.transferir(contaCorrente, 5000.00);
        contaCorrente1.transferir(contaCorrente, -500.00);
        contaCorrente1.imprimir();
        System.out.println("-----------------------------");
        //Teste de conta negativa caso seja sacado o valor do saldo + cheque especial
        contaCorrente1.sacar(3300.00);
        contaCorrente1.sacar(3250.00);
        contaCorrente1.imprimir();
        System.out.println("-------------------------------");

        ContaPoupanca contaPoupanca = new ContaPoupanca(clienteMaicon, "1451-X", "1710", 1000.00);
        //Teste Métodos Conta Poupança
        contaPoupanca.creditarTaxa();
        contaPoupanca.imprimir();
    }
}
