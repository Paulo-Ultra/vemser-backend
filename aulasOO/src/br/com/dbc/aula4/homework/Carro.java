package br.com.dbc.aula4.homework;

public class Carro {

    private String modelo;
    private Integer quilometragem;

    public Carro(){
    }

    public Carro(String modelo){
        this.modelo = modelo;
    }

    public Carro (String modelo, Integer quilometragem){
        this.modelo = modelo;
        this.quilometragem = quilometragem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "modelo='" + modelo + '\'' +
                ", quilometragem=" + quilometragem +
                '}';
    }
}
