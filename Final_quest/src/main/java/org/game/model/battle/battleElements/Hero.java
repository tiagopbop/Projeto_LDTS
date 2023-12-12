package org.game.model.battle.battleElements;

import org.game.model.game.elements.nonInteractabel.Hero_Element;
import org.game.rpg_elements.dialogue.Dialogue;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.Inimigos.drop.Drop;
import org.game.rpg_elements.status.Status;

import java.io.IOException;

public class Hero implements Individuo {
    private static Hero instance;
    private Status status;
    private Character type;
    private boolean estado_batalha;
    private static final String nome = "hero";

    private Hero_Element heroElement;

    public Inventario hero_inventario;

    public boolean map = false;

    private Hero() throws IOException {

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }

        this.status = new LoaderStatus().renderStatusHero();
        this.type = 'h';
        this.estado_batalha = true;
        this.hero_inventario = new LoaderInventario().renderInventario();
        getStatus().atualizar_equipado(hero_inventario.getEquipado(), true);
    }

    private Hero(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }

        this.status = new LoaderStatus().renderStatusHero();
        this.type = 'h';
        this.estado_batalha = true;
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
        this.hero_inventario = new LoaderInventario().renderInventario();
        getStatus().atualizar_equipado(hero_inventario.getEquipado(), true);
    }

    public static Hero getInstance() throws IOException {
        if(instance == null){
            instance = new Hero();
        }
        return instance;
    }

    public static Hero getInstance(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {
        if(instance == null){
            instance = new Hero(x, y, dialogue, desenho, cor, backCor);
        }
        else{
            instance.setHeroElement(x, y, dialogue, desenho, cor, backCor);
        }
        return instance;
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

    public void setHeroElement(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
    }
}
