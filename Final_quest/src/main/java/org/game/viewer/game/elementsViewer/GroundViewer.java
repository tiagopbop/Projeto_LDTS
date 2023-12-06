package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.Door;
import org.game.model.game.elements.Ground;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui){
        gui.drawGround(ground.getPosition());
    }
}
