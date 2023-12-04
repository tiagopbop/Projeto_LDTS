package org.game.controller.gameController;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.Dialogue.Dialogue;
import org.game.model.Dialogue.HeroMovementDialogue;
import org.game.model.game.elements.*;
import org.game.model.game.map.Village;

import java.io.IOException;

public class DialogueController extends GameController {

    public DialogueController(Village village) {
        super(village);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) {
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("up"));

        }
        if (action == GUI.ACTION.RIGHT){
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("right"));

        }
        if (action == GUI.ACTION.DOWN){
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("down"));
        }
        if (action == GUI.ACTION.LEFT){
            getModel().getNarrator().setText(new HeroMovementDialogue().CreateDialogue("left"));
        }
        if(action == GUI.ACTION.INTERACT)
        {
            Dialogue t = new Dialogue();

            t = getModel().isInteractable(getModel().getHero().getPosition().getUp());



            //switch (near_elements)
            getModel().setNarrator(new Dialogue(t));
        }
    }

}
