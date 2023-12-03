package org.game.model.game.battle;

import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;

public abstract class Individuo {
    private final String name;

    private final Status status;

    private final Character type;

    private int vida_atual;
    private int mana_atual;

    public Individuo(Status status, String name,Character type) throws IOException {
        this.name = name;
        this.status = status;
        this.vida_atual = status.getAtributos().getVida();
        this.mana_atual = status.getAtributos().getMana();
        this.type = type;
    }

    public Character getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getVida_atual() {
        return vida_atual;
    }

    public int getMana_atual() {
        return mana_atual;
    }

    public void setVida_atual(int vida_atual) {
        this.vida_atual = vida_atual;
    }

    public void setMana_atual(int mana_atual) {
        this.mana_atual = mana_atual;
    }

    public void dano_recebido(int dano){
        this.vida_atual -= dano;
    }

    public void mana_usada(Ataque ataque){
        this.mana_atual -= ataque.getCusto();
    }

}
