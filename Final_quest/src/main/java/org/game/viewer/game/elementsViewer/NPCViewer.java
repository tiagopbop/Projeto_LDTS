package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.NPC;

public class NPCViewer implements ElementViewer<NPC>{
    private int count = 1;
    @Override
    public void draw( NPC NPC, GUI gui){
        gui.drawNPC(NPC);
    }

}