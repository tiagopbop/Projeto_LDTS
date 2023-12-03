package org.game.rpg_elements.itens;

import java.util.Map;

public class Equipamento extends Item{
    public Equipamento(String nome, String type, Map<String, Integer> efeitos, Map<String, Integer> requirements){
        super(nome, type, efeitos, requirements);
    }

}
