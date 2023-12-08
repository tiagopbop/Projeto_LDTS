package org.game.model.menu;

import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.status.ataque.Ataque;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckAtack {
    private Hero hero;
    private Inventario inventario;
    private int plate;
    private final List<String> entries = new ArrayList<>();
    private int currentEntry = 0;

    public CheckAtack(int plate, Inventario inventario, Hero hero){
        this.hero = hero;
        this.inventario = inventario;
        this.plate = plate;

        switch (plate) {

        case 0:
            List<Ataque> melee = hero.getStatus().getAtaques_fisicos();
            for (Ataque entry : melee) {
                this.entries.add(entry.getNome());
            }
            break;
        case 1:
            List<Ataque> magic = hero.getStatus().getAtaques_magicos();
            for (Ataque entry : magic) {
                this.entries.add(entry.getNome());
            }
            break;


    }
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



    public int getNumberEntries() {
        return this.entries.size();
    }

    public Hero getHero() {
        return hero;
    }

    public int getPlate() {
        return plate;
    }
}
