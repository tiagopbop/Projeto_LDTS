package org.game.rpg_rules.Inimigos.strategy;

import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;

import java.io.IOException;

public interface Strategy {
    Ataque execute(Monster monster) throws IOException;
}
