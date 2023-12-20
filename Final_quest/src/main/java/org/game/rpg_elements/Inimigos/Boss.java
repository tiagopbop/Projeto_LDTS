package org.game.rpg_elements.Inimigos;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_elements.Inimigos.strategy.Strategy;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Boss implements Individuo {
    private String name;
    private Status status;
    private Character type;
    private boolean estado_batalha;
    private Strategy strategy;

    public Boss() throws IOException {

        this.status = new LoaderStatus().renderBoss();
        this.type = 'b';
        this.name = status.getNome();

        this.estado_batalha = true;
        this.strategy = new AgressiveStrategy();

        createmember();
    }

    private void createmember() throws IOException {
        List<Status> t = new ArrayList<>();

        t = new LoaderStatus().renderMemberBoss();

        for(Status status1 : t){
            add_member(status1);
        }
    }

    public void add_member(Status member){
        this.name += " " + status.getNome();

        status.getAtributos_real().add_vida(member.getAtributos_real().getVida());
        status.getAtributos_real().add_mana(member.getAtributos_real().getMana());
        status.getAtributos_real().add_forca(member.getAtributos_real().getForca());
        status.getAtributos_real().add_inteligencia(member.getAtributos_real().getInteligencia());
        status.getAtributos_real().add_velocidade(member.getAtributos_real().getVelocidade());
    }

    @Override
    public boolean getEstado_batalha() {
        return this.estado_batalha;
    }

    @Override
    public Character getType() {
        return this.type;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setEstado_batalha(boolean estado_batalha) {
        this.estado_batalha = estado_batalha;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
