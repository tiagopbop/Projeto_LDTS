package org.game.rpg_elements.Inimigos.drop;
import org.game.rpg_elements.itens.Item;

import java.util.Map;

public class Drop {
    private Integer mim_dinheiro;
    private Integer max_dinheiro;
    private Map<Item, Integer> itens_droped;

    private Integer experiencia;

    public Drop(Integer max_dinheiro, Integer mim_dinheiro, Map<Item, Integer> itens_droped, Integer experiencia){
        this.max_dinheiro = max_dinheiro;
        this.mim_dinheiro = mim_dinheiro;
        this.itens_droped = itens_droped;
        this.experiencia = experiencia;
    }

    public Integer getMim_dinheiro() {
        return mim_dinheiro;
    }
    public Integer getMax_dinheiro() {
        return max_dinheiro;
    }

    public Map<Item, Integer> getItens_droped() {
        return itens_droped;
    }

    public Integer getExperiencia() {
        return experiencia;
    }
}
