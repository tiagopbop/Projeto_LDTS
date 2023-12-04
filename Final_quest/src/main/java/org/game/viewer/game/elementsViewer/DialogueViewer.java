package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.DialogueT;
import org.game.model.game.elements.Door;

public class DialogueViewer implements ElementViewer<DialogueT> {
    @Override
    public void draw(DialogueT dialogueT, GUI gui){
        gui.drawDialogue(dialogueT.getPosition());
    }
}
