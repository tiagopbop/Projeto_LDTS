package org.game.model.menu;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.status.ataque.Ataque;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Selection {
    private List<Item> l_itens = new ArrayList<>();
    private List<Ataque> l_ataque = new ArrayList<>();
    private final List<String> entries = new ArrayList<>();
    private final List<Integer> quantidade = new ArrayList<>();
    private Inventario inventario;
    private Item uso;
    private int currentEntry = 0;
    private Hero hero;
    private Integer plate;

    public Selection(int plate, Hero hero) {
        this.plate = plate;
        this.hero = hero;
        this.inventario = hero.getHero_inventario();

        switch (plate) {

            case 0:
                Map<Item, Integer> equipamento = inventario.lista_capacetes();
                for (Map.Entry<Item, Integer> entry : equipamento.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.l_itens.add(entry.getKey());
                    this.quantidade.add(entry.getValue());
                }
                break;
            case 1:
                Map<Item, Integer> peitorais = inventario.lista_peitoral();
                for (Map.Entry<Item, Integer> entry : peitorais.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.l_itens.add(entry.getKey());
                    this.quantidade.add(entry.getValue());
                }
                break;

            case 2:
                Map<Item, Integer> calcas = inventario.lista_calcas();
                for (Map.Entry<Item, Integer> entry : calcas.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.l_itens.add(entry.getKey());
                    this.quantidade.add(entry.getValue());
                }
                break;

                case 3:
                Map<Item, Integer> consumiveis = inventario.getConsumiveis();
                for (Map.Entry<Item, Integer> entry : consumiveis.entrySet()) {
                    this.entries.add(entry.getKey().getNome());
                    this.l_itens.add(entry.getKey());
                    this.quantidade.add(entry.getValue());
                }
                break;
            case 4:
                List<Ataque> melee = hero.getStatus().getAtaques_fisicos();
                for (Ataque entry : melee) {
                    this.entries.add(entry.getNome());
                    this.l_ataque.add(entry);
                }
                break;
            case 5:
                List<Ataque> magic = hero.getStatus().getAtaques_magicos();
                for (Ataque entry : magic) {
                    this.entries.add(entry.getNome());
                    this.l_ataque.add(entry);
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

    public int getCurrentEntry() {
        return currentEntry;
    }

    public Integer getPlate() {
        return plate;
    }

    public List<Item> getL_itens() {
        return l_itens;
    }

    public List<Ataque> getL_ataque() {
        return l_ataque;
    }
}
