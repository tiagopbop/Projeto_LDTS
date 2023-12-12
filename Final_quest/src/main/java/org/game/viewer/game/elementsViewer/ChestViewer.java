package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.Chest;

public class ChestViewer implements ElementViewer<Chest>{
    @Override
    public void draw(Chest chest, GUI gui){
        gui.drawChest(chest);
    }


}
