package org.game.model.battle.battleElements;

import java.io.IOException;

public abstract class BattleCommander {
    protected Battle battle;

    public BattleCommander(Battle battle) throws IOException {
        this.battle = battle;
    }

    public abstract void execute() throws IOException;
}
