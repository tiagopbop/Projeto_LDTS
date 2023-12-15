package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_elements.Inimigos.Monster;
import org.game.rpg_elements.Loader;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.LoaderItem;

import java.io.IOException;
import java.util.Queue;

public class Start_Turn extends BattleCommander {
    private Item player_item;
    private String player_choice;
    private Integer int_list;
    private int result;
    public Start_Turn(Battle battle) throws IOException {
        super(battle);

        player_item = new LoaderItem().renderConsumivel("1");
        player_choice = "atacar";
        int_list = 0;
    }

    @Override
    public void execute() throws IOException {
        boolean flag = true;

        new CreatePriorityQueue(battle).execute();
        Queue<Individuo> vez_ataque = battle.getVez_ataque();

        while(!vez_ataque.isEmpty()){
            if(vez_ataque.peek().getType() == 'm'){
                new MonsterTurn(battle).execute();

                if(!fainted_hero()){
                    if(all_hero_fainted()){
                        battle.getParty().getParty().get(0).setEstado_batalha(true);
                        this.result = 0;

                        flag = false;
                        break;
                    }
                }
            }
            else{
                Hero_Turn heroTurn = new Hero_Turn(battle);

                heroTurn.setPlayer_option(player_choice);
                heroTurn.setInt_list(int_list);
                heroTurn.setPlayer_item(player_item);

                heroTurn.execute();

                if(!fainted_monster()){
                    if(all_monster_fainted()){
                        this.result = 2;

                        flag = false;
                        break;
                    }
                }
            }
            vez_ataque.remove();
            battle.setVez_ataque(vez_ataque);
        }
        if(flag){
            this.result = 1;
        }

    }

    private boolean all_monster_fainted(){
        for(Monster monster1: battle.getListMonster()){
            if(monster1.getEstado_batalha()){
                return false;
            }
        }
        return true;
    }

    private boolean all_hero_fainted(){
        for(Hero hero: battle.getParty().getParty()){
            if(hero.getEstado_batalha()){
                return false;
            }
        }
        return true;
    }

    private boolean fainted_monster(){
        boolean res = false;
        for(Monster monster1 : battle.getListMonster()){
            if(monster1.getStatus().getVida_atual() <= 0 && monster1.getEstado_batalha()){
                monster1.setEstado_batalha(false);
            }
            else{
                res = true;
            }
        }
        return res;
    }

    private boolean fainted_hero(){
        boolean res = false;

        for(Hero hero : battle.getParty().getParty()){
            if((hero.getStatus().getVida_atual() <= 0) && hero.getEstado_batalha()){
                hero.setEstado_batalha(false);
            }
            else{
                res = true;
            }
        }
        return res;
    }

    public int getResult() {
        return result;
    }

    public void setPlayer_choice(String player_choice) {
        this.player_choice = player_choice;
    }

    public void setInt_list(Integer int_list) {
        this.int_list = int_list;
    }

    public void setPlayer_item(Item player_item) {
        this.player_item = player_item;
    }
}
