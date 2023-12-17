package org.game.rpg_elements.Inimigos.strategy;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.status.ataque.Ataque;

import java.util.Random;

public class NormalStrategy implements Strategy{
    @Override
    public Ataque execute(Monster monster, Hero target) {
        Random rand = new Random();
        int num_rand = rand.nextInt(monster.getStatus().getAtaques().size());

        Ataque at = monster.getStatus().getAtaques().get(num_rand);

        return at;
    }
}
