package org.game.model.menu;

import org.game.model.game.elements.Hero;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.status.ataque.Ataque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Selection {
    private final List<String> entries = new ArrayList<>();
    private final List<Integer> quantidade = new ArrayList<>();


    private int currentEntry = 0;
    private Inventario inventario;
    private Hero hero;

    public Selection(int plate, Inventario inventario, Hero hero) {
        this.hero = hero;
        this.inventario = inventario;

        switch (plate) {

            case 0:
                Map<Item, Integer> equipamento = inventario.getEquipamentos();
                for (Map.Entry<Item, Integer> entry : equipamento.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.quantidade.add(entry.getValue());
                }
                break;
            case 1:
                Map<Item, Integer> peitorais = inventario.getEquipamentos();
                for (Map.Entry<Item, Integer> entry : peitorais.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.quantidade.add(entry.getValue());
                }
                break;

            case 2:
                Map<Item, Integer> calcas = inventario.getEquipamentos();
                for (Map.Entry<Item, Integer> entry : calcas.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.quantidade.add(entry.getValue());
                }
                break;

                case 3:
                Map<Item, Integer> consumiveis = inventario.getConsumiveis();
                for (Map.Entry<Item, Integer> entry : consumiveis.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.quantidade.add(entry.getValue());
                }
                break;
            case 4:
                List<Ataque> melee = hero.getStatus().getAtaques_fisicos();
                for (Ataque entry : melee) {
                    this.entries.add(entry.getNome());
                }
                break;
            case 5:
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


    public int getQuantidade(int i)
    {
        return quantidade.get(i);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public Hero getHero() {
        return hero;
    }
}
