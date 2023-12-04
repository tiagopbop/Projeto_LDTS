package org.game.model.game.elements;

import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;

import java.io.IOException;
import org.game.model.Dialogue.Dialogue;
import org.game.model.Position;
import org.game.rpg_elements.status.Atributos;

public class Hero extends Individuo {
    private static final String nome = "hero";

    private int dinheiro;



    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public Hero(int x, int y, Dialogue dialogue) throws IOException {
        super(new LoaderStatus().createStatus(nome), nome, 'h');
        this.heroElement = new Hero_Element(x,y, dialogue);
        this.hero_inventario = new LoaderInventario().createInventario();
        this.dinheiro = 0;
    }
    public Hero_Element getHeroElement() {
        return heroElement;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void add_dinheiro(int n){
        this.dinheiro += n;
    }

    public Inventario getHero_inventario() {
        return hero_inventario;
    }
}
