package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.HouseWall;

public class HouseWallViewer implements ElementViewer<HouseWall> {
    @Override
    public void draw(HouseWall housewall, GUI gui){
        gui.drawHouseWall(housewall.getPosition());
    }
}
