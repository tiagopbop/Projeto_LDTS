package org.game.model.menu;

import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelUp {
    private List<String> entries;

    private int currentEntry;
    private Inventario inventario;
    private Hero hero;
    private Integer dinheiro;
    private Integer xp;
    private List<Item> items;
    private boolean level_up;

    public LevelUp( Inventario inventario, Hero hero, int dinheiro, int xp, List<Item> itens, boolean level_up){
        this.hero = hero;
        this.inventario = inventario;
        this.entries = Arrays.asList("HEALTH","MANA","STRENGHT", "INTELLIGENCE", "SPEED" );;
        this.dinheiro = dinheiro;
        this.xp = xp;
        this.items = itens;
        this.level_up = level_up;
        this.currentEntry = 0;
        getHero().getStatus().getAtributos_real().add_level(1);
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public boolean isSelectedStr() {
        return isSelected(2);
    }
    public boolean isSelectedIntel() {
        return isSelected(3);
    }
    public boolean isSelectedHP() {
        return isSelected(0);
    }
    public boolean isSelectedMana() {
        return isSelected(1);
    }
    public boolean isSelectedSpeed() {
        return isSelected(4);
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

    public boolean isSelected(int i) {
        return currentEntry == i;
    }


    public Hero getHero() {
        return hero;
    }


    public Integer getDinheiro() {
        return dinheiro;
    }

    public Integer getXp() {
        return xp;
    }

    public List<Item> getItems() {
        return items;
    }
    public boolean getLevel_up(){
        return level_up;
    }
}
