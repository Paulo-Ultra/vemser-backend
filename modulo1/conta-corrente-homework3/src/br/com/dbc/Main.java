package br.com.dbc;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Endereco> enderecosListaMaicon = new ArrayList<>();
        ArrayList<Contato> contatosListaMaicon = new ArrayList<>();

        contatosListaMaicon.add(new Contato("Telefone duvidas", "\"(51)97254-5108", 2));
        contatosListaMaicon.add(new Contato("Instrutor da DBC", "\"(51)98757-5848", 1));
        enderecosListaMaicon.add(new Endereco(1, "Rua das Flores", 1502
                , "Apartamento", "30915-000", "Vila Velha"
                , "Santa Catarina", "Brasil"));
        enderecosListaMaicon.add(new Endereco(2, "Avenida São Jorge", 701
                , "Apartamento", "33915-000", "Vila Velha"
                , "Santa Catarina", "Brasil"));

        ArrayList<Endereco> enderecosListaPaulo = new ArrayList<>();
        ArrayList<Contato> contatosListaPaulo = new ArrayList<>();

        contatosListaPaulo.add(null);
        enderecosListaPaulo.add(null);

        contatosListaPaulo.add(new Contato("WhatsApp", "(61)98888-5731", 1));
        contatosListaPaulo.add(new Contato("Telefone para ligação", "(61)954128-5731", 1));
        enderecosListaPaulo.add(new Endereco(1, "Rua Presidente Dutra", 9
                , "Esquina com Adalberto Barreto", "44915-000", "São Gabriel"
                , "Bahia", "Brasil"));

        Cliente clientePaulo = new Cliente("Paulo", "015.151.561-20", contatosListaPaulo, enderecosListaPaulo);
        Cliente clienteMaicon = new Cliente("Maicon", "584.874.021-20", contatosListaMaicon, enderecosListaMaicon);

        //Método da Classe Contato
        clientePaulo.imprimirContato();
        System.out.println("----------------------------------");
        //Método da Classe Endereço
        clientePaulo.imprimirEndereco();
        System.out.println("----------------------------------");


//        //Métodos da Classe Cliente

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

        ContaCorrente contaCorrenteMaicon = new ContaCorrente(clienteMaicon, "1451-X", "1710", 1000.00, 200.00);
        ContaPagamento contaPagamentoMaicon = new ContaPagamento(clienteMaicon, "1451-X", "1710", 1000.00);
        ContaPoupanca contaPoupancaPaulo = new ContaPoupanca(clientePaulo, "4852-X", "7956", 1000.00);

        //Métodos da ContaCorrente
        contaCorrenteMaicon.imprimir();
        System.out.println("---------------------");
        contaCorrenteMaicon.sacar(200.00);
        contaCorrenteMaicon.depositar(50.00);
        contaCorrenteMaicon.setChequeEspecial(200.00);
        contaCorrenteMaicon.retornarSaldoComChequeEspecial();
        contaCorrenteMaicon.transferir(contaPoupancaPaulo, 500.00);
        contaCorrenteMaicon.imprimir();
        System.out.println("-------------------------------");

        //Teste Métodos Conta Poupança
        contaPoupancaPaulo.creditarTaxa();
        contaPoupancaPaulo.imprimir();

        contaPoupancaPaulo.sacar(200.00);
        System.out.println("----------------------");
        //Teste caso deposite valor além do disponível e sacar nada (0)
        contaPoupancaPaulo.sacar(5000.00);
        System.out.println("----------------------");
        contaPoupancaPaulo.sacar(0.0);
        System.out.println("----------------------");
        contaPoupancaPaulo.depositar(50.00);
        System.out.println("----------------------");
        //Teste caso deposite valor além do disponível, zero ou negativo
        contaPoupancaPaulo.depositar(0.0);
        System.out.println("----------------------");
        contaPoupancaPaulo.depositar(2000.00);
        System.out.println("----------------------");
        contaPoupancaPaulo.depositar(-5.0);
        System.out.println("----------------------");
        contaPoupancaPaulo.transferir(contaCorrenteMaicon, 100.00);
        System.out.println("----------------------");
        //Teste Transferência valores além do disponível, zero ou negativo
        contaPoupancaPaulo.transferir(contaCorrenteMaicon, 0.0);
        System.out.println("----------------------");
        contaPoupancaPaulo.transferir(contaCorrenteMaicon, 5000.00);
        System.out.println("----------------------");
        contaPoupancaPaulo.transferir(contaCorrenteMaicon, -500.00);
        System.out.println("----------------------");
        contaPoupancaPaulo.imprimir();
        System.out.println("-----------------------------");
        //Teste de conta negativa caso seja sacado o valor do saldo
        contaPoupancaPaulo.sacar(3300.00);
        System.out.println("-----------------------------");
        contaPoupancaPaulo.sacar(2760.00);
        System.out.println("-----------------------------");
        contaPoupancaPaulo.imprimir();
        System.out.println("-------------------------------");


        contaPagamentoMaicon.sacar(200.00);
        contaPagamentoMaicon.imprimir();
        System.out.println("-----------------------------");
        contaPoupancaPaulo.transferir(contaPagamentoMaicon, 100.00);
        contaPagamentoMaicon.imprimir();
        System.out.println("----------------------------");
        contaPagamentoMaicon.sacar(5000.00);
        contaPagamentoMaicon.sacar(0.0);
        contaPagamentoMaicon.imprimir();
        System.out.println("----------------------------------");
        contaPagamentoMaicon.transferir(contaPoupancaPaulo, 500.00);
        System.out.println("-------------------------");
        contaPagamentoMaicon.imprimir();

    }
}
