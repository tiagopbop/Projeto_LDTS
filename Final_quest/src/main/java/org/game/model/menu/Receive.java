package org.game.model.menu;

import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.inventario.Inventario;

import java.util.ArrayList;
import java.util.List;

public class Receive {
    private String entries;

    private int currentEntry;
    private int plate;
    private Inventario inventario;
    private Hero hero;

    public Receive(int plate, Inventario inventario, Hero hero) {
        this.plate = plate;
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

    public int getPlate() {
        return plate;
    }
}
