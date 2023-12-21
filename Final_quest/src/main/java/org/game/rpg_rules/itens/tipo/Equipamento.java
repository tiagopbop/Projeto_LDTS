package org.game.rpg_rules.itens.tipo;

import org.game.rpg_rules.itens.Item;

import java.util.Map;

public class Equipamento extends Item {
    public Equipamento(String nome, String type, Map<String, Integer> efeitos, Map<String, Integer> requirements){
        super(nome, type, efeitos, requirements);
    }

}
