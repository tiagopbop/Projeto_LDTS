package org.game.model.game.battle;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;
import java.util.Map;

public  interface Individuo {
    boolean getEstado_batalha();

    Character getType();

    Status getStatus();

    void setEstado_batalha(boolean estado_batalha);

    void setStatus(Status status);

}
