package org.game.rpg_rules.Inimigos.strategy;

import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;

import java.io.IOException;

public class AgressiveStrategy implements Strategy{
    @Override
    public Ataque execute(Monster monster) throws IOException {
        Ataque at = new Ataque();
        int damage = 0;
        int test;

        for(Ataque ataque: monster.getStatus().getAtaques()){
            if(ataque.getOrigem().equals("fisico")){
                test = ataque.getDano() + monster.getStatus().getAtributos_atualizados().getForca();

                if(test > damage){
                    damage = test;
                    at = ataque;
                }
            }
            else if(ataque.getOrigem().equals("magico")){
                test = ataque.getDano() + monster.getStatus().getAtributos_atualizados().getInteligencia();

                if(test > damage){
                    damage = test;
                    at = ataque;
                }
            }
        }

        return at;
    }
}
