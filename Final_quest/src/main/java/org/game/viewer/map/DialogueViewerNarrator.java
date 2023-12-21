package org.game.viewer.map;

import org.game.gui.GUI;
import org.game.rpg_rules.dialogue.Dialogue;

import java.io.IOException;

public class DialogueViewerNarrator {


    public void draw(Dialogue dialogue, GUI gui) throws IOException {
        gui.drawDialogueNarrator(dialogue);
    }


}
