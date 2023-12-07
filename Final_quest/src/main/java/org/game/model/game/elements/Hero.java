package org.game.model.game.elements;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Drop;

import java.io.IOException;

public class Hero extends Individuo {
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public Hero() throws IOException {
        super(new LoaderStatus().renderStatus(nome), nome, 'h');
    }

    public Hero(int x, int y, Dialogue dialogue, String type, char desenho, String cor, String backCor) throws IOException {
        super(new LoaderStatus().renderStatus(nome), nome, 'h');
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
        this.hero_inventario = new LoaderInventario().renderInventario();
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
