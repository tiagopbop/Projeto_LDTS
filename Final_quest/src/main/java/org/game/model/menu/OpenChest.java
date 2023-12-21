package org.game.model.menu;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;

public class OpenChest {
    private Item item;
    private Hero hero;

    public OpenChest(Item item, Hero hero)
    {
        this.hero=hero;
        this.item=item;
    }



    public Item getItem() {
        return item;
    }

    public Hero getHero() {
        return hero;
    }

}
