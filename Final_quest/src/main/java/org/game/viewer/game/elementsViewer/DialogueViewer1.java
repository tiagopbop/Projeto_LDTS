package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.DialogueT;

public class DialogueViewer1 implements ElementViewer<DialogueT> {
    @Override
    public void draw(DialogueT dialogueT, GUI gui){
        gui.drawDialogue1(dialogueT.getPosition());
    }
}
