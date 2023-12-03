package org.game.rpg_elements.itens;

import java.util.List;
import java.util.Map;

public class Item {
    private String nome;

    private String type;
    private Map<String, Integer> efeitos;

    private Map<String, Integer> requirements;

    public Item(String nome, String type,  Map<String, Integer> efeitos, Map<String, Integer> requirements){
        this.nome = nome;
        this.type = type;
        this.efeitos = efeitos;
        this.requirements = requirements;
    }

    public Item(String nome, String type, Map<String, Integer> efeitos){
        this.nome = nome;
        this.type = type;
        this.efeitos = efeitos;
        this.requirements = null;
    }

    public String getNome() {
        return nome;
    }

    public String getType() {
        return type;
    }

    public Map<String, Integer> getEfeitos() {
        return efeitos;
    }

    public Map<String, Integer> getRequirements() {
        return requirements;
    }
}
