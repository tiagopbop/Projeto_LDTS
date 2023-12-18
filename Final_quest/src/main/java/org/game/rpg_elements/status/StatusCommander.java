package org.game.rpg_elements.status;

import org.game.model.battle.battleElements.Battle;

import java.io.IOException;

public abstract class StatusCommander {
    protected Status status;

    public StatusCommander(Status status) throws IOException {
        this.status = status;
    }

    public abstract void execute() throws IOException;
}
