package org.game.model.battle.menus;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;

import java.util.List;

public class Receive {
    private String entries;

    private int currentEntry;
    private int plate;
    private Inventario inventario;
    private Hero hero;
    private Integer dinheiro;
    private Integer xp;
    private List<Item> items;
    private boolean level_up;

    public Receive(int plate, Inventario inventario, Hero hero, int dinheiro, int xp, List<Item> itens, boolean level_up){
        this.plate = plate;
        this.hero = hero;
        this.inventario = inventario;
        this.entries = "ok";
        this.dinheiro = dinheiro;
        this.xp = xp;
        this.items = itens;
        this.level_up = level_up;
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

    public int getPlate() {
        return plate;
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
