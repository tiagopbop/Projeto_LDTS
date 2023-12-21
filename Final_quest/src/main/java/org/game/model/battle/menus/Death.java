package org.game.model.battle.menus;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.inventario.Inventario;

public class Death {
    private String entries;

    private int currentEntry;
    private Inventario inventario;
    private Hero hero;

    public Death(Inventario inventario, Hero hero) {
        this.hero = hero;
        this.inventario = inventario;
        this.entries = "ok";

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
