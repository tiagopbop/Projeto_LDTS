package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.HouseWall;
import org.game.model.game.elements.RoofC;

public class RoofCViewer implements ElementViewer<RoofC> {
    @Override
    public void draw(RoofC roofc, GUI gui){
        gui.drawRoofC(roofc.getPosition());
    }
}
