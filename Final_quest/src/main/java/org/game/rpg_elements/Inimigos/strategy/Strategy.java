package org.game.rpg_elements.Inimigos.strategy;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.status.ataque.Ataque;

import java.io.IOException;

public interface Strategy {
    Ataque execute(Monster monster, Hero target) throws IOException;
}
