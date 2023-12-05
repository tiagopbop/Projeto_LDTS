package org.game.model.dialogue;

public class HeroMovementDialogue {

    public String CreateDialogue(String action)
    {
        String move = "The hero moved ";
        move += action;
        return  move;
    }
}
