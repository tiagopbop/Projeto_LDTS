package org.game.rpg_elements.Inimigos.strategy;

import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.LoaderAtaque;

import java.io.IOException;

public class AgressiveStrategy implements Strategy{
    @Override
    public Ataque execute(Monster monster, Hero target) throws IOException {
        Ataque at = new LoaderAtaque().renderAtaque("1");
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
