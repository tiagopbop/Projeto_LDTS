package org.game.rpg_elements;

public class Ataque {
    private String nome;
    private String origem;
    private int dano;
    private float acerto;

    private int custo;

    public Ataque(String nome, String origem, int dano, float acerto, int custo){
        this.nome = nome;
        this.origem = origem;
        this.dano = dano;
        this.acerto = acerto;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origem;
    }

    public int getDano() {
        return dano;
    }

    public float getAcerto() {
        return acerto;
    }

    public int getCusto() {
        return custo;
    }
}
