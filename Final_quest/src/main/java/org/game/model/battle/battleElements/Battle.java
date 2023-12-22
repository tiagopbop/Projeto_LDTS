package org.game.model.battle.battleElements;

import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.Monster_Pool;
import java.io.IOException;
import java.util.*;

public class Battle {
    private Queue<Individuo> vez_ataque;
    private Party party;
    private List<Individuo> monster;
    public Battle(Party party, int floor) throws IOException {
        this.party = party;
        if(floor==3)
        {
            this.monster=new Monster_Pool(floor).Generate_Boss();
            return;
        }
        this.monster = new Monster_Pool(floor).Generate_Monster();


    }


    public Individuo getMonster() {return this.monster.get(0);}

    public boolean pode_usar_ataque(int int_choice){
        int mana_atual = this.party.getParty().get(0).getStatus().getMana_atual();
        int mana_ataque = this.party.getParty().get(0).getStatus().getAtaques_magicos().get(int_choice).getCusto();

        if((mana_atual - mana_ataque) < 0){
            return false;
        }
        return true;
    }

    public List<Individuo> getListMonster(){return this.monster;}

    public Party getParty() {
        return party;
    }

    public void setVez_ataque(Queue<Individuo> vez_ataque) {
        this.vez_ataque = vez_ataque;
    }

    public Queue<Individuo> getVez_ataque() {
        return vez_ataque;
    }

}

