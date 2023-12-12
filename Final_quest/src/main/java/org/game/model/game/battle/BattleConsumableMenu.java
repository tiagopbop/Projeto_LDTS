package org.game.model.game.battle;

import org.game.model.Position;
import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Item;

import java.util.ArrayList;
import java.util.List;

public class BattleConsumableMenu extends BattleMenu{
    private final List<String> entries;

    private int currentEntry;
    private  int page = 1;

    private Hero hero;
    private Battle battle;

    private int abilities;


    public BattleConsumableMenu(Hero hero, Battle battle) {
        super(hero, battle);
        entries = new ArrayList<>();
        for(Item a: hero.getHero_inventario().getInventario().keySet())
        {
            this.entries.add(a.getNome());
        }
        this.currentEntry = 0;
        this.hero  = hero;
        this.battle = battle;
    }
    public void setCurrentEntry(int currentEntry) {
        this.currentEntry = currentEntry;
        if(currentEntry>1 && abilities >4) page = 2;
        else page = 1;
    }


    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }







    public String getEntry(int i) {
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



    public int getAbilities() {
        return abilities;
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


}
