package org.game.rpg_rules.status.ataque;

import org.game.rpg_rules.status.Atributos;

import java.util.Random;

public class Formula_Dano {

    public int Dano(Ataque ataque, Atributos atributos, int speed){
        int dano = 0, max = 100, min = 0, acerto = ataque.getAcerto();

        Random rand = new Random();
        int int_rand = rand.nextInt((max - min + 1) + min);

        if(speed > atributos.getVelocidade()){
            acerto -= (speed - atributos.getVelocidade());
        }

        if(acerto >= int_rand) {
            if(ataque.getOrigem().equals("fisico")){
                dano = atributos.getForca() + ataque.getDano();
            }
            else if (ataque.getOrigem().equals("magico")) {
                dano = atributos.getInteligencia() + ataque.getDano();
            }
            else if (ataque.getOrigem() == "elementar") {
                dano = 0;
            }
        }

        return dano;
    }
}
