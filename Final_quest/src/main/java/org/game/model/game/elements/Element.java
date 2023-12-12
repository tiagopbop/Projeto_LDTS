package org.game.model.game.elements;

import org.game.model.Position;
import org.game.rpg_elements.dialogue.Dialogue;

public abstract class Element {
    private  Position position;
    private Dialogue dialogue;
    private String type;

    private char desenho;
    private String cor;

    private String backCor;


    public Element(int x, int y, Dialogue dialogue, String type, char desenho, String cor, String backCor) {
        this.position = new Position(x, y);
        this.dialogue = dialogue;
        this.type = type;
        this.desenho = desenho;
        this.cor = cor;
        this.backCor = backCor;
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

    public void setDesenho(char desenho) { this.desenho = desenho; }

    public char getDesenho() { return this.desenho; }

    public void setCor(String cor) { this.cor = cor; }

    public String getCor() { return this.cor; }

    public void setBackCor(String backCor) { this.backCor = backCor; }

    public String getBackCor() { return this.backCor; }
}
