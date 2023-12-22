package org.game.model.battle.menus;

import org.game.Game;
import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.inventario.Inventario;

import java.net.URISyntaxException;

public class FinalBossWin {
    private String entries;

    private int currentEntry;
    private Hero hero;

    public FinalBossWin(Game game,Hero hero) throws URISyntaxException {
        this.entries = "ok";
        this.hero=hero;

    }

    public String getEntry(int i) {
        return entries;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public Hero getHero() {
        return hero;
    }

}
