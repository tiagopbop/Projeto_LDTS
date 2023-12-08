package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.elements.Hero;
import org.game.states.BattleState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeleeController extends Controller<MeleeMenu> {

    public MeleeController(MeleeMenu model) {
        super(model);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
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
                    //heroi morreu
                }
                else {
                    System.out.println("monstro morreu");
                    //monstro morreu
                }
                game.previousState();
                break;

        }

    }}

