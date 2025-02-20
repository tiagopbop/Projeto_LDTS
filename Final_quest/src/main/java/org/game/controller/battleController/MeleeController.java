package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.battleElements.battleCommands.Generate_Loot;
import org.game.model.battle.menus.*;
import org.game.rpg_rules.itens.Item;
import org.game.states.State;
import org.game.states.battle.DeathState;
import org.game.states.battle.FinalBossWinState;
import org.game.states.battle.LevelUpState;
import org.game.states.battle.ReceiveState;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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
                    res = getModel().start_turn("melee", int_choice);
                }
                else{
                    if(getModel().getBattle().pode_usar_ataque(int_choice)){
                        res = getModel().start_turn("magic", int_choice);
                    }
                    else {
                        break;
                    }
                }
                if(res == 1){
                    //batalha continua

                }
                else if(res == 0){
                    game.addState(new DeathState(new Death(getModel().getHero().getHero_inventario(),getModel().getHero())));
                    game.setinside_castle(false);
                    game.setFloor();
                    return;
                    //heroi morreu
                }
                else {
                    if(game.getFloor()==3)
                    {
                        FinalBossWinState state = new FinalBossWinState(new FinalBossWin(game,getModel().getHero()));
                        game.addState(state);
                        return;
                    }
                    Generate_Loot generateLoot = new Generate_Loot(getModel().getBattle());
                    generateLoot.execute();

                    boolean level_up = generateLoot.getLevel_up();

                    Integer dinheiro = generateLoot.getDinheiro();
                    Integer xp = generateLoot.getXp();

                    List<Item> itens = generateLoot.getLoot();

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

