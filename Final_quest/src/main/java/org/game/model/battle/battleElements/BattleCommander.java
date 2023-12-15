package org.game.model.battle.battleElements;

import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Inimigos.Monster_Pool;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BattleCommander {
    protected Battle battle;


    public BattleCommander(Battle battle) throws IOException {
        this.battle = battle;
    }

    public abstract void execute() throws IOException;
}
