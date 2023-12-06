package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.HouseDoor;
import org.game.model.game.elements.HouseWall;

public class HouseDoorViewer implements ElementViewer<HouseDoor> {
    @Override
    public void draw(HouseDoor housedoor, GUI gui){
        gui.drawHouseDoor(housedoor.getPosition());
    }
}
