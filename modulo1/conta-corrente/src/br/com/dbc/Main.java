package br.com.dbc;

import br.com.dbc.Endereco;

public class Main {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.tipo = 1;
        endereco.lograduro = "Rua Presidente Dutra";
        endereco.numero = 9;
        endereco.complemento = "Esquina com Adalberto Barreto";
        endereco.cep = "44915-000";
        endereco.cidade = "São Gabriel";
        endereco.estado = "Bahia";
        endereco.pais = "Brasil";

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 2;
        endereco1.lograduro = "Avenida São Jorge";
        endereco1.numero = 701;
        endereco1.complemento = "Apartamento";
        endereco1.cep = "33915-000";
        endereco1.cidade = "Vila Velha";
        endereco1.estado = "Santa Catarina";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 1;
        endereco2.lograduro = "Rua Getulio Vargas";
        endereco2.numero = 54;
        endereco2.complemento = "Centro";
        endereco2.cep = "01112-000";
        endereco2.cidade = "São Paulo";
        endereco2.estado = "São Paulo";
        endereco2.pais = "Brasil";

        Endereco endereco3 = new Endereco();
        endereco3.tipo = 2;
        endereco3.lograduro = "Avenida dos Milagres";
        endereco3.numero = 178;
        endereco3.complemento = "";
        endereco3.cep = "77115-000";
        endereco3.cidade = "Recife";
        endereco3.estado = "Pernambuco";
        endereco3.pais = "Brasil";

        //Método da Classe Endereço
        endereco.imprimirEndereco();
        System.out.println("----------------------------------");

        Contato contato = new Contato();
        contato.descricao = "Instrutor da DBC";
        contato.telefone = "(51)98757-5848";
        contato.tipo = 2;

        Contato contato1 = new Contato();
        contato1.descricao = "Jovem Aprendiz";
        contato1.telefone = "(61)98888-5731";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "Mãe";
        contato2.telefone = "(51)98757-5848";
        contato2.tipo = 1;

        Contato contato3 = new Contato();
        contato3.descricao = "Telefone RH Trabalho";
        contato3.telefone = "(51)3354-5544";
        contato3.tipo = 2;

        //Método da Classe Contato
        contato.imprimirContato();
        System.out.println("----------------------------------");

        Cliente cliente = new Cliente();
        cliente.nome = "Maicon";
        cliente.cpf = "720.968.440-96";
        cliente.enderecos[0] = endereco;
        cliente.contatos[0] = contato;
        cliente.enderecos[1] = endereco1;
        cliente.contatos[1] = contato1;


        Cliente cliente1 = new Cliente();
        cliente1.nome = "Paulo";
        cliente1.cpf = "970.467.670-09";
        cliente1.enderecos[0] = endereco2;
        cliente1.contatos[0] = contato2;
        cliente1.enderecos[1] = endereco3;
        cliente1.contatos[1] = contato3;

        //Métodos da Classe Cliente
        cliente.imprimirCliente(cliente);
        System.out.println("----------------------------------");
        cliente.imprimirEndereco();
        System.out.println("----------------------------------");
        cliente.imprimirContato();
        System.out.println("----------------------------------");
        cliente1.imprimirCliente(cliente1);
        System.out.println("----------------------------------");
        cliente1.imprimirEndereco();
        System.out.println("----------------------------------");
        cliente1.imprimirContato();
        System.out.println("----------------------------------");

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.cliente = cliente;
        contaCorrente.numeroConta = "1451-X";
        contaCorrente.agencia = 1710;
        contaCorrente.saldo = 1000.00;
        contaCorrente.chequeEspecial = 200.00;

        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "54558-0";
        contaCorrente1.agencia = 1888;
        contaCorrente1.saldo = 200.00;
        contaCorrente1.chequeEspecial = 800.00;

        //Métodos da ContaCorrente
        contaCorrente.imprimirContaCorrente();
        System.out.println("---------------------");
        contaCorrente.sacar(200.00);
        contaCorrente.depositar(50.00);
        contaCorrente.retornarSaldoComChequeEspecial();
        contaCorrente.transferir(contaCorrente1, 500.00);
        contaCorrente.imprimirContaCorrente();
        System.out.println("-------------------------------");


        contaCorrente1.imprimirContaCorrente();
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
        contaCorrente1.imprimirContaCorrente();
        System.out.println("-----------------------------");
        //Teste de conta negativa caso seja sacado o valor do saldo + cheque especial
        contaCorrente1.sacar(3300.00);
        contaCorrente1.sacar(3250.00);
        contaCorrente1.imprimirContaCorrente();
        System.out.println("-------------------------------");

        contaCorrente.imprimirContaCorrente();
        System.out.println("--------------------------------");
        contaCorrente1.imprimirContaCorrente();


    }
}
