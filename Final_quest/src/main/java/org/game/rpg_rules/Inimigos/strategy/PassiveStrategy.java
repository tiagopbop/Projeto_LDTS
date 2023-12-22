package org.game.rpg_rules.Inimigos.strategy;

import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;

import java.io.IOException;

public class PassiveStrategy implements Strategy{
    @Override
    public Ataque execute(Individuo monster) throws IOException {
        Ataque at = new Ataque();
        int damage = 0;
        int test;
        boolean flag = true;

        for(Ataque ataque: monster.getStatus().getAtaques()){
            if(ataque.getOrigem().equals("fisico")){
                test = ataque.getDano() + monster.getStatus().getAtributos_atualizados().getForca();

                if(flag){
                    damage = test;
                    at = ataque;
                    flag = false;
                }
                else if(test < damage){
                    damage = test;
                    at = ataque;
                }
            }
            else if(ataque.getOrigem().equals("magico")){
                test = ataque.getDano() + monster.getStatus().getAtributos_atualizados().getInteligencia();

                if(flag){
                    damage = test;
                    at = ataque;
                    flag = false;
                }
                if(test < damage){
                    damage = test;
                    at = ataque;
                }
            }
        }

        return at;
    }
}
