package org.game.controller.gameController;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.Dialogue.Dialogue;
import org.game.model.Dialogue.HeroMovementDialogue;
import org.game.model.game.elements.*;
import org.game.model.game.map.Village;
import org.game.model.game.map.VillageLoader;
import org.game.model.menu.InteractionMenu;
import org.game.states.InteractionState;
import org.game.states.VillageState;

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
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("up"));

        }
        if (action == GUI.ACTION.RIGHT){
            pre_act = GUI.ACTION.RIGHT;
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("right"));

        }
        if (action == GUI.ACTION.DOWN){
            pre_act = GUI.ACTION.DOWN;
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("down"));
        }
        if (action == GUI.ACTION.LEFT){
            pre_act = GUI.ACTION.LEFT;
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("left"));
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



            t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getUp());

            //switch (near_elements)
            getModel().setNarrator(new Dialogue(t));
            InteractionState state = (new InteractionState(new InteractionMenu()));
            game.addState(state);

        }
    }

}
