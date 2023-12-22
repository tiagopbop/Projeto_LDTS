package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.Inimigos.strategy.Strategy;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Formula_Dano;

import java.io.IOException;

public class MonsterTurn extends BattleCommander {
    private Individuo target;
    private Strategy strategy;
    private Formula_Dano formulaDano;

    public MonsterTurn(Battle battle, Strategy strategy, Formula_Dano formulaDano) throws IOException {
        super(battle);
        this.strategy = strategy;
        this.formulaDano = formulaDano;
    }

    public MonsterTurn(Battle battle) throws IOException {
        super(battle);
        formulaDano = new Formula_Dano();
    }

    @Override
    public void execute() throws IOException {
        int monster_target = 0;
        String monster_choice = "atacar";

        if(monster_choice.equals("atacar")){
            Hero target = battle.getParty().getParty().get(monster_target);
            Hero new_one = Monster_Attack_Turn(battle.getMonster(), target);

            battle.getParty().set_hero(monster_target, new_one);
            this.target = new_one;
        }
    }
    private Hero Monster_Attack_Turn(Individuo monster, Hero target) throws IOException {
        if(strategy == null){
            strategy = monster.getStrategy();
        }

        Ataque ataque = strategy.execute(monster);
        int dano = formulaDano.Dano(ataque, monster.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade());

        target.getStatus().dano_recebido(dano);
        return target;
    }

    public Individuo getTarget() {
        return target;
    }
}
