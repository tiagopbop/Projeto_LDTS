package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.elements.Hero;
import org.game.model.menu.Death;
import org.game.model.menu.LevelUp;
import org.game.model.menu.Receive;
import org.game.rpg_elements.itens.Item;
import org.game.states.BattleState;
import org.game.states.DeathState;
import org.game.states.LevelUpState;
import org.game.states.ReceiveState;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeleeController extends Controller<MeleeMenu> {

    public MeleeController(MeleeMenu model) {
        super(model);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().nextEntryUp();
                break;
            case DOWN:
                getModel().nextEntryDown();
                break;
            case LEFT:
                getModel().nextEntryLeft();
                break;
            case RIGHT:
                getModel().nextEntryRight();
                break;
            case BACK:
                game.previousState();
                break;
            case SELECT:
                int int_choice = getModel().int_player_choice(getModel().getCurrentEntryX(), getModel().getCurrentEntryY(), getModel().getPage());
                int res = 0;

                if(getModel().getSelection() == 0){
                    res = getModel().star_turn("melee", int_choice);
                }
                else{
                    if(getModel().getBattle().pode_usar_ataque(int_choice)){
                        res = getModel().star_turn("magic", int_choice);
                    }
                    else {
                        System.out.println("Nao tem mana suficiente");
                        break;
                    }
                }
                if(res == 1){
                    System.out.println("batalha continua");
                    //batalha continua

                }
                else if(res == 0){
                    System.out.println("heroi morreu");
                    game.addState(new DeathState(new Death(getModel().getHero().getHero_inventario(),getModel().getHero())));
                    return;
                    //heroi morreu
                }
                else {
                    System.out.println("monstro morreu");
                    boolean level_up = getModel().getBattle().generate_loot();

                    Integer dinheiro = getModel().getBattle().getDinheiro();
                    Integer xp = getModel().getBattle().getXp();
                    List<Item> itens = getModel().getBattle().getLoot();

                    if(level_up)
                    {
                        game.addState(new LevelUpState(new LevelUp(getModel().getHero().getHero_inventario(),getModel().getHero(),dinheiro,xp,itens,level_up)));
                    }
                    else game.addState(new ReceiveState(new Receive(1,getModel().getHero().getHero_inventario(),getModel().getHero(), dinheiro, xp, itens, level_up)));
                    return;
                    //monstro morreu
                }
                game.previousState();
                break;

        }

    }}

