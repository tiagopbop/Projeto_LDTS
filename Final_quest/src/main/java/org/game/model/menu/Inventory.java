package org.game.model.menu;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.inventario.Inventario;

import java.util.Arrays;
import java.util.List;

public class Inventory {
    private final List<String> entries;
    private int currentEntry = 0;
    private Inventario inventario;
    private Hero hero;

    public Inventory(Inventario inventario, Hero hero) {
        this.entries = Arrays.asList("Helmets", "ChestPlates", "Pants","Consumables", "Melee", "Magic", "Exit");
        this.inventario = inventario;
        this.hero = hero;
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

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(6);
    }

    public boolean isSelectedHelmets() {
        return isSelected(0);
    }

    public boolean isSelectedChestplates() {
        return isSelected(1);
    }

    public boolean isSelectedPants() {return  isSelected(2);}

    public boolean isSelectedConsumables(){return isSelected(3);}

    public boolean isSelectedMelee(){return  isSelected(4);}
    public boolean isSelectedMagic(){return isSelected((5));}
    public int getNumberEntries() {
        return this.entries.size();
    }

    public Inventario getInventario() {
        return inventario;
    }
    public Hero getHero()
    {
        return hero;
    }
}
