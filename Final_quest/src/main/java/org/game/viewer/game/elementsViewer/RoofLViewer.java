package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.HouseWall;
import org.game.model.game.elements.RoofL;

public class RoofLViewer implements ElementViewer<RoofL> {
    @Override
    public void draw(RoofL roofl, GUI gui){
        gui.drawRoofL(roofl.getPosition());
    }
}
