package org.game.model.battle.battleElements.battleCommands;

import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.BattleCommander;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.Individuo;
import org.game.rpg_rules.Inimigos.Monster;
import org.game.rpg_rules.itens.Item;
import org.game.rpg_rules.itens.inventario.inventario_commands.itens.InventarioRemoveConsumivel;
import org.game.rpg_rules.status.ataque.Ataque;
import org.game.rpg_rules.status.ataque.Formula_Dano;
import org.game.rpg_rules.status.statusCommands.Usar_Item;

import java.io.IOException;

public class Hero_Turn extends BattleCommander {
    private Individuo target;
    private String player_option;
    private Integer int_list;
    private Item player_item;
    private Formula_Dano formulaDano;
    private InventarioRemoveConsumivel inventarioRemoveConsumivel;
    public Hero_Turn(Battle battle, InventarioRemoveConsumivel inventarioRemoveConsumivel) throws IOException {
        super(battle);
        this.inventarioRemoveConsumivel = inventarioRemoveConsumivel;
    }
    public Hero_Turn(Battle battle, Formula_Dano formulaDano) throws IOException {
        super(battle);
        this.formulaDano = formulaDano;
    }

    public Hero_Turn(Battle battle) throws IOException {
        super(battle);
        formulaDano = new Formula_Dano();
    }

    @Override
    public void execute() throws IOException {
        String player_choice = player_option;
        int int_player_choice = int_list;

        Hero hero = battle.getParty().getParty().get(0);

        if(player_choice.equals("melee")){
            int num_target = 0;

            Individuo target = battle.getListMonster().get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_fisicos().get(int_player_choice);

            Individuo new_one = Hero_Attack_Turn(hero, ataque, target);
            this.target = new_one;

            battle.getListMonster().set(num_target, new_one);
        }
        else if(player_choice.equals("magic")){
            int num_target = 0;

            Individuo target = battle.getListMonster().get(num_target);
            Ataque ataque = hero.getStatus().getAtaques_magicos().get(int_player_choice);

            Individuo new_one = Hero_Attack_Turn(hero, ataque, target);
            battle.getListMonster().set(num_target, new_one);
            this.target = new_one;

            Hero new_hero = hero;
            new_hero.getStatus().mana_usada(ataque);

            battle.getParty().remove_hero(hero);
            battle.getParty().add_hero(new_hero);

        } else if (player_choice.equals("item")) {
            Individuo target;

            if(inventarioRemoveConsumivel == null){
                inventarioRemoveConsumivel = new InventarioRemoveConsumivel(hero.getHero_inventario(), player_item);
            }

            inventarioRemoveConsumivel.execute();

            if(this.player_item.getType().equals("essencio") || this.player_item.getType().equals("bomba")){
                target = battle.getListMonster().get(0);
            }
            else{
                target = battle.getParty().getParty().get(0);
            }

            new Usar_Item(target.getStatus(), this.player_item).execute();

        } else if (player_choice.equals("run")) {


        }
    }

    private Individuo Hero_Attack_Turn(Hero hero, Ataque ataque, Individuo target){
        int dano = formulaDano.Dano(ataque, hero.getStatus().getAtributos_atualizados(), target.getStatus().getAtributos_atualizados().getVelocidade());
        target.getStatus().dano_recebido(dano);

        return target;
    }

    public void setPlayer_option(String player_option) {
        this.player_option = player_option;
    }

    public void setInt_list(Integer int_list) {
        this.int_list = int_list;
    }

    public void setPlayer_item(Item player_item) {
        this.player_item = player_item;
    }

    public Individuo getTarget() {
        return target;
    }
}
