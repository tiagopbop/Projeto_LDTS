package org.game.model.game.battle;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;
import java.util.Map;

public abstract class Individuo {
    private final Status status;

    private final Character type;

    private boolean estado_batalha;


    public Individuo(Status status,Character type) throws IOException {
        this.status = status;
        this.type = type;
        this.estado_batalha = true;
    }

    public boolean getEstado_batalha(){
        return estado_batalha;
    }
    public Character getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setEstado_batalha(boolean estado_batalha){
        this.estado_batalha = estado_batalha;
    }
}
