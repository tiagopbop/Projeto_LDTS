package org.game.model.game.elements.nonInteractabel;

import org.game.model.game.elements.Element;
import org.game.rpg_rules.dialogue.Dialogue;

public class Wall extends Element {
    public Wall(int x, int y, Dialogue dialogue, String type, char desenho, String cor, String backCor){
        super(x, y, dialogue, type, desenho, cor, backCor);
    }


}
