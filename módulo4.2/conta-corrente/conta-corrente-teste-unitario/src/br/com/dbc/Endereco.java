package br.com.dbc;

public class Endereco {

    private Integer tipo; //1 residencial, 2 comercial
    private String lograduro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(Integer tipo, String lograduro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.lograduro = lograduro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLograduro() {
        return lograduro;
    }

    public void setLograduro(String lograduro) {
        this.lograduro = lograduro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void imprimirEndereco(){
        if(tipo == 1) {
            System.out.println("Endereço:\nResidencial: " + tipo + "\nLogradouro: " +  lograduro + ", Número: " + numero
                    + "\nComplemento: " + complemento + "\nCEP: " + cep + "\nCidade: " + cidade
                    + "\nEstado: " + estado + "\nPaís: " + pais);
        } else if(tipo == 2) {
            System.out.println("Endereço:\nComercial: " + tipo + "\nLogradouro: " +  lograduro + ", Número: " + numero
                + "\nComplemento: " + complemento + "\nCEP: " + cep + "\nCidade: " + cidade
                + "\nEstado: " + estado + "\nPaís: " + pais);
        } else {
            System.out.println("Número inválido, digite um tipo de endereço correto.");
        }
    }
}
