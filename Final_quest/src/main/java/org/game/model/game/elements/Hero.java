package org.game.model.game.elements;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Drop;
import org.game.rpg_elements.status.Status;

import java.io.IOException;
import java.util.List;

public class Hero implements Individuo {
    private Status status;
    private Character type;
    private boolean estado_batalha;
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public boolean map = false;

    public Hero() throws IOException {
        this.status = new LoaderStatus().renderStatusHero();
        this.type = 'h';
        this.estado_batalha = true;
        this.hero_inventario = new LoaderInventario().renderInventario();
        getStatus().atualizar_equipado(hero_inventario.getEquipado());
    }

    public Hero(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {
        this.status = new LoaderStatus().renderStatusHero();
        this.type = 'h';
        this.estado_batalha = true;
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

    public void set_in_map(boolean qq)
    {
        this.map= qq;
    }
    public boolean get_in_map()
    {
        return this.map;
    }

    @Override
    public boolean getEstado_batalha() {
        return estado_batalha;
    }

    @Override
    public Character getType() {
        return type;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setEstado_batalha(boolean estado_batalha) {
        this.estado_batalha = estado_batalha;
    }

    @Override
    public void setStatus(Status status){
        this.status = status;
    }
}
