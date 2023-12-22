package org.game.model.battle.menus;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BattleConsumableMenu extends BattleMenu {
    private final List<Item> entries;
    private List<Map<Item, Integer>> inv;
    private int currentEntry;
    private  int page = 1;

    private Hero hero;
    private Battle battle;

    public BattleConsumableMenu(Hero hero, Battle battle, int floor) {
        super(hero, battle,floor);
        entries = new ArrayList<>();
        for(Item a: hero.getHero_inventario().getConsumiveis().keySet()) {
            this.entries.add(a);
        }
        this.currentEntry = 0;
        this.hero  = hero;
        this.battle = battle;
    }



    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1) {
            currentEntry = 0;
            this.page = 1;
        }
        if (currentEntry >= 8 && this.entries.size() > 8) {
            this.page = 2;
        }

    }



    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
        {
            this.page = 2;
            currentEntry = this.entries.size() - 1;

            return;
        }

        if(currentEntry<8 && this.entries.size() >8)
        {
            this.page=1;
        }

    }







    public Item getEntryi(int i) {
        return entries.get(i);
    }



    public boolean isSelected(int entry) {
        return currentEntry == entry;
    }



    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public int getPage() {
        return page;
    }

    public int int_player_choice(int x, int y, int page){
        int res = (page - 1) * 4;
        if(x == 0 && y == 0){
            res += 0;
        }
        else if(x == 1 && y == 0){
            res += 1;
        }
        else if(x == 0 && y == 1){
            res += 2;
        }
        else if(x == 1 && y == 1){
            res += 3;
        }

        return res;
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public Battle getBattle() {
        return battle;
    }
}
