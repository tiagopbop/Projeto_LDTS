package org.game.model.game.elements;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.Drop;
import org.game.rpg_elements.status.LoaderStatus;

import java.io.IOException;

public class Hero extends Individuo {
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;


    public Hero(int x, int y, Dialogue dialogue, String type) throws IOException {
        super(new LoaderStatus().createStatus(nome), nome, 'h');
        this.heroElement = new Hero_Element(x,y, dialogue,"hero");
        this.hero_inventario = new LoaderInventario().createInventario();
    }

    public boolean add_drop(Drop drop){
        this.hero_inventario.add_drop(drop);
        return getStatus().add_experiencia(drop.getExperiencia());
    }
    public Hero_Element getHeroElement() {
        return heroElement;
    }

    public Inventario getHero_inventario() {
        return hero_inventario;
    }
}
