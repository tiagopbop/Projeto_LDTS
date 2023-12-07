package org.game.rpg_elements.Inimigos;

import org.game.model.game.battle.Individuo;
import org.game.rpg_elements.status.LoaderStatus;

import java.io.IOException;

public class Monster extends Individuo {

    public Monster(String nome) throws IOException {
        super(new LoaderStatus().renderStatus("inimigos/" + nome), nome, 'm');
    }

}
