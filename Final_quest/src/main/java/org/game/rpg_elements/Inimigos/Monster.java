package org.game.rpg_elements.Inimigos;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.strategy.AgressiveStrategy;
import org.game.rpg_elements.Inimigos.strategy.NormalStrategy;
import org.game.rpg_elements.Inimigos.strategy.PassiveStrategy;
import org.game.rpg_elements.Inimigos.strategy.Strategy;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Status;
import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.IOException;

public class Monster implements Individuo {
    private Status status;
    private Character type;
    private boolean estado_batalha;
    private Strategy strategy;

    public Monster(String file_path) throws IOException {
        this.status = new LoaderStatus().renderStatusMonster(file_path);
        this.type = 'm';

        this.estado_batalha = true;
        this.strategy = new NormalStrategy();

        if(status.getStrg().equals("n")){
            strategy = new NormalStrategy();
        } else if (status.getStrg().equals("a")) {
            strategy = new AgressiveStrategy();
        }
        else {
            strategy = new PassiveStrategy();
        }
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

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
