package org.game.model.game.elements.nonInteractabel;

import org.game.model.game.elements.Element;
import org.game.rpg_elements.dialogue.Dialogue;

import java.io.IOException;

public class Hero_Element extends Element {
    public Hero_Element(int x, int y, Dialogue dialogue, String type, char desenho, String cor, String backCor) throws IOException {
        super(x, y, dialogue, type, desenho, cor, backCor);
    }
}
