package br.com.dbc.aula7.Exercicio1;

public enum TipoComida {
    COMIDA_JAPONESA(50),
    FAST_FOOD(30),
    TRADICIONAL(20);

    private Integer custo;

    TipoComida(Integer custo) {
        this.custo = custo;
    }

    public Integer getCusto(){
        return custo;
    }
}
