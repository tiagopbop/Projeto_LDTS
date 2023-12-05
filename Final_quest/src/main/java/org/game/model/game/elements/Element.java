package org.game.model.game.elements;

import org.game.model.Position;
import org.game.model.dialogue.Dialogue;

public abstract class Element {
    private  Position position;
    private Dialogue dialogue;
    private String type;
    public Element(int x, int y, Dialogue dialogue, String type){
        this.position = new Position(x, y);
        this.dialogue = dialogue;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
