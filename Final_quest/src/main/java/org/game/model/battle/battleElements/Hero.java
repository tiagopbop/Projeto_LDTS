package org.game.model.battle.battleElements;

import org.game.model.game.elements.nonInteractabel.Hero_Element;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.rpg_rules.itens.inventario.Inventario;
import org.game.rpg_rules.itens.inventario.LoaderInventario;
import org.game.rpg_rules.status.LoaderStatus;
import org.game.rpg_rules.Inimigos.drop.Drop;
import org.game.rpg_rules.status.Status;
import org.game.rpg_rules.status.statusCommands.Add_Experiencia;
import org.game.rpg_rules.status.statusCommands.Atualizar_Equipado;

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
        new Atualizar_Equipado(getStatus(), hero_inventario.getEquipado(), true).execute();
    }

    private Hero(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.status = new LoaderStatus().renderStatusHero();
        this.type = 'h';
        this.estado_batalha = true;
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
        this.hero_inventario = new LoaderInventario().renderInventario();
        new Atualizar_Equipado(getStatus(), hero_inventario.getEquipado(), true).execute();
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



    public boolean add_drop(Drop drop) throws IOException {
        Add_Experiencia addExperiencia = new Add_Experiencia(getStatus(), drop.getExperiencia());
        addExperiencia.execute();
        return addExperiencia.getRes();
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

    @Override
    public Strategy getStrategy() {
        return null;
    }

    public void setHeroElement(int x, int y, Dialogue dialogue, char desenho, String cor, String backCor) throws IOException {
        this.heroElement = new Hero_Element(x, y, dialogue, "hero", desenho, cor, backCor);
    }
}
