package org.game.model.Dialogue;

import org.game.gui.GUI;

public class HeroMovementDialogue {

    public String CreateDialogue(String action)
    {
        String move = "The hero moved ";
        move += action;
        return  move;
    }
}
