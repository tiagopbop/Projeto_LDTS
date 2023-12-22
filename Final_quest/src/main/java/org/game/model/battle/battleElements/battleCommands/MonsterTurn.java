package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Formula_Dano;

import java.io.IOException;

public class MonsterTurn extends BattleCommander {

    public MonsterTurn(Battle battle) throws IOException {
        super(battle);
    }

    @Override
    public void execute() throws IOException {
        int monster_target = 0;
        String monster_choice = "atacar";

        if(monster_choice.equals("atacar")){
            Hero target = battle.getParty().getParty().get(monster_target);
            Hero new_one = Monster_Attack_Turn(battle.getMonster(), target);

            battle.getParty().set_hero(monster_target, new_one);
        }
    }
    private Hero Monster_Attack_Turn(Individuo monster, Hero target) throws IOException {
        Ataque ataque = monster.getStrategy().execute(monster);
        target.getStatus().dano_recebido(new Formula_Dano().Dano(ataque, monster.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade()));

        return target;
    }
}
