package org.game.model.battle.battleElements;

import org.game.rpg_rules.status.Status;

public  interface Individuo {
    boolean getEstado_batalha();

    Character getType();

    Status getStatus();

    void setEstado_batalha(boolean estado_batalha);

    void setStatus(Status status);

}
