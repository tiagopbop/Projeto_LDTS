package org.game.rpg_elements;

public class Ataque {
    private String origem;
    private int dano;
    private float acerto;

    public Ataque(String origem, int dano, float acerto){
        this.origem = origem;
        this.dano = dano;
        this.acerto = acerto;
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
}
