package org.game.model.game.elements;

import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;

import java.io.IOException;

public class Hero extends Individuo {
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public Hero(int x, int y, Dialogue dialogue) throws IOException {
        super(new LoaderStatus().createStatus(nome), nome, 'h');
        this.heroElement = new Hero_Element(x,y, dialogue);
        this.hero_inventario = new LoaderInventario().createInventario();
    }
    public Hero_Element getHeroElement() {
        return heroElement;
    }

    public Inventario getHero_inventario() {
        return hero_inventario;
    }
}
