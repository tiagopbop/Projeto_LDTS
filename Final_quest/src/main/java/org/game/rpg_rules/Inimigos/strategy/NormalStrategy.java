package org.game.rpg_rules.Inimigos.strategy;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;

import java.util.Random;

public class NormalStrategy implements Strategy{
    @Override
    public Ataque execute(Individuo monster) {
        Random rand = new Random();
        int num_rand = rand.nextInt(monster.getStatus().getAtaques().size());

        Ataque at = monster.getStatus().getAtaques().get(num_rand);

        return at;
    }
}
