package org.game.viewer.game.elementsViewer;
import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.Door;

public class DoorViewer implements ElementViewer<Door>{
    @Override
    public void draw(Door door, GUI gui){
        gui.drawDoor(door);
    }
}
