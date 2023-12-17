package org.game.rpg_elements.Inimigos.strategy;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.IOException;

public class PassiveStrategy implements Strategy{
    @Override
    public Ataque execute(Monster monster, Hero target) throws IOException {
        Ataque at = new LoaderAtaque().renderAtaque("1");
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
