package org.game.rpg_rules.itens.tipo;

import org.game.rpg_rules.itens.Item;

import java.util.Map;

public class Consumivel extends Item {

    public Consumivel(String nome, String type, Map<String, Integer> efeitos, Map<String, Integer> requesitos){
        super(nome, type, efeitos, requesitos);
    }

}
