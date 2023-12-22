package org.game.rpg_rules.Inimigos.strategy;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;

import java.io.IOException;

public interface Strategy {
    Ataque execute(Individuo monster) throws IOException;
}
