package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Dialogue.Dialogue;

import java.io.IOException;

public class DialogueViewerNarrator {


    public void draw(Dialogue dialogue,GUI gui) throws IOException {
        gui.drawDialogueNarrator(dialogue);
    }


}
