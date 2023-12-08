package org.game.model.game.elements;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Drop;

import java.io.IOException;
import java.util.List;

public class Hero extends Individuo {
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public Hero() throws IOException {
        super(new LoaderStatus().renderStatus(nome), 'h');
        this.hero_inventario = new LoaderInventario().renderInventario();
        getStatus().atualizar_equipado(hero_inventario.getEquipado());
    }

    public Hero(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {
        super(new LoaderStatus().renderStatus(nome), 'h');
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
        this.hero_inventario = new LoaderInventario().renderInventario();
        getStatus().atualizar_equipado(hero_inventario.getEquipado());
    }
    public boolean add_drop(Drop drop){
        return getStatus().add_experiencia(drop.getExperiencia());
    }
    public Hero_Element getHeroElement() {
        return heroElement;
    }

    public Inventario getHero_inventario() {
        return hero_inventario;
    }

    public void setHeroElement(Integer x,Integer y,Dialogue dialogue,String hero,char desenho,String cor,String backCor) throws IOException {
        this.heroElement = new Hero_Element(x, y, dialogue, hero, desenho, cor, backCor);
    }
}
