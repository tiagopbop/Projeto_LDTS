package org.game.rpg_elements.Inimigos;

import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.status.LoaderStatus;
import org.game.rpg_elements.status.Status;

import java.io.IOException;

public class Monster implements Individuo {
    private Status status;
    private Character type;
    private boolean estado_batalha;

    public Monster(String file_path) throws IOException {
        this.status = new LoaderStatus().renderStatusMonster(file_path);
        this.type = 'm';
        this.estado_batalha = true;
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
