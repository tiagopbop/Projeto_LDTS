package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;

import java.io.IOException;
import java.util.*;

public class CreatePriorityQueue extends BattleCommander {
    private Queue<Individuo> vez_ataque;
    public CreatePriorityQueue(Battle battle) throws IOException {
        super(battle);
    }

    @Override
    public void execute(){
        List<Individuo> merge = new ArrayList<>();

        for(Individuo monster1: battle.getListMonster()) {
            if (monster1.getEstado_batalha()) {
                merge.add(monster1);
            }
        }
        for(Hero hero: battle.getParty().getParty()){
            if(hero.getEstado_batalha()){
                merge.add(hero);
            }
        }
        Collections.sort(merge, new Comparator<Individuo>() {
            @Override
            public int compare(Individuo a, Individuo b) {
                return - a.getStatus().getAtributos_atualizados().getVelocidade() + b.getStatus().getAtributos_atualizados().getVelocidade();
            }
        });
        battle.setVez_ataque(new ArrayDeque<>(merge));
        this.vez_ataque = new ArrayDeque<>(merge);
    }

    public Queue<Individuo> getVez_ataque() {
        return vez_ataque;
    }
}
