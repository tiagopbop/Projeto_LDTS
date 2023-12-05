package org.game.model.game.battle;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;
import java.util.Map;

public abstract class Individuo {
    private final String name;

    private final Status status;

    private final Character type;


    public Individuo(Status status, String name,Character type) throws IOException {
        this.name = name;
        this.status = status;
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

}
