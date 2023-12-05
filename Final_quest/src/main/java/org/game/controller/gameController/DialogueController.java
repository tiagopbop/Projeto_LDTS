package org.game.controller.gameController;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.dialogue.Dialogue;
import org.game.model.dialogue.HeroMovementDialogue;
import org.game.model.game.map.Village;
import org.game.model.menu.BattleMenu;
import org.game.model.menu.InteractionMenu;
import org.game.model.menu.Menu;
import org.game.states.BattleState;
import org.game.states.InteractionState;

import java.io.IOException;

public class DialogueController extends GameController {

    public DialogueController(Village village) {
        super(village);
    }
    private GUI.ACTION pre_act;

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) {
            pre_act = GUI.ACTION.UP;
            getModel().getNarrator().setTitle(new HeroMovementDialogue().CreateDialogue("up"));

        }
        if (action == GUI.ACTION.RIGHT){
            pre_act = GUI.ACTION.RIGHT;
            getModel().getNarrator().setTitle(new HeroMovementDialogue().CreateDialogue("right"));

        }
        if (action == GUI.ACTION.DOWN){
            pre_act = GUI.ACTION.DOWN;
            getModel().getNarrator().setTitle(new HeroMovementDialogue().CreateDialogue("down"));
        }
        if (action == GUI.ACTION.LEFT){
            pre_act = GUI.ACTION.LEFT;
            getModel().getNarrator().setTitle(new HeroMovementDialogue().CreateDialogue("left"));
        }

        if(action == GUI.ACTION.SELECT)
        {
            BattleState state = new BattleState(new BattleMenu());
            game.addState(state);
        }

        if(action == GUI.ACTION.INTERACT)
        {
            Dialogue t = new Dialogue();
            if (pre_act == GUI.ACTION.UP) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getUp());
            }
            if (pre_act == GUI.ACTION.LEFT) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getLeft());
            }
            if (pre_act == GUI.ACTION.DOWN) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getDown());
            }
            if (pre_act == GUI.ACTION.RIGHT) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getRight());
            }
             if(t.getMen())
             {
                 getModel().setNarrator(new Dialogue(t));
                 InteractionState state = (new InteractionState(new InteractionMenu()));
                 game.addState(state);
             }



            else
            {
                getModel().setNarrator(new Dialogue(t));
            }
    }

}}
