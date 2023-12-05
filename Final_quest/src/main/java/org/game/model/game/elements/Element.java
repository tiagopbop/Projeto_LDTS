package org.game.model.game.elements;

import org.game.model.Position;

public abstract class Element {
    private  Position position;
    private Dialogue dialogue;

    public Element(int x, int y, Dialogue dialogue){
        this.position = new Position(x, y);
        this.dialogue = dialogue;
    }



    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void setDialogue(Dialogue dialogue){this.dialogue = dialogue;}

    public Dialogue getDialogue() {
        return dialogue;
    }
}
