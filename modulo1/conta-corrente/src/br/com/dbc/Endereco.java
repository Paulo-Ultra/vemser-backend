package br.com.dbc;

public class Endereco {

    Integer tipo; //1 residencial, 2 comercial
    String lograduro;
    Integer numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco(){
        if(tipo == 1) {
            System.out.println("Endereço:\nResidencial: " + tipo + "\nLogradouro: " +  lograduro + ", Número: " + numero
                    + "\nComplemento: " + complemento + "\nCEP: " + cep + "\nCidade: " + cidade
                    + "\nEstado: " + estado + "\nPaís: " + pais);
        } else { System.out.println("Endereço:\nComercial: " + tipo + "\nLogradouro: " +  lograduro + ", Número: " + numero
                + "\nComplemento: " + complemento + "\nCEP: " + cep + "\nCidade: " + cidade
                + "\nEstado: " + estado + "\nPaís: " + pais);

        }
    }
}
