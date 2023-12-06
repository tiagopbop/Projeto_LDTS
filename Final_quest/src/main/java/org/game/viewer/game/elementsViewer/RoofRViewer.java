package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.HouseWall;
import org.game.model.game.elements.RoofR;

public class RoofRViewer implements ElementViewer<RoofR> {
    @Override
    public void draw(RoofR roofr, GUI gui){
        gui.drawRoofR(roofr.getPosition());
    }
}
