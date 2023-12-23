package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.NPC;

public class NPCViewer implements ElementViewer<NPC>{
    @Override
    public void draw( NPC NPC, GUI gui){
        gui.drawNPC(NPC);
    }

}