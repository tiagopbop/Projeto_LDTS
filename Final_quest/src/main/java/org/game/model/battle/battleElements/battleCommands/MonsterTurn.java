package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.status.ataque.Ataque;
import org.game.rpg_elements.status.ataque.Formula_Dano;

import java.io.IOException;
import java.util.Random;

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
    private Hero Monster_Attack_Turn(Monster monster, Hero target){
        Random rand = new Random();
        int num_rand = rand.nextInt(monster.getStatus().getAtaques().size());

        Ataque at = monster.getStatus().getAtaques().get(num_rand);
        target.getStatus().dano_recebido(new Formula_Dano().Dano(at, monster.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade()));

        return target;
    }
}
