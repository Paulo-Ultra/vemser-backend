package br.com.dbc.aula5;

import br.com.dbc.aula4.heranca.Veiculo;

public class Carro extends Veiculo {

    private String modeloMotor;
    private Integer potencia;
    private Integer velocidadeMaxima;

    public Carro(String modeloMotor, Integer potencia, Integer velocidadeMaxima) {
        this.modeloMotor = modeloMotor;
        this.potencia = potencia;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro(String nome, String modeloMotor, Integer potencia, Integer velocidadeMaxima) {
        super(nome);
        this.modeloMotor = modeloMotor;
        this.potencia = potencia;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int acelerar(){
        return ++velocidadeMaxima;
    }
}
