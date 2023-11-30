package org.game.viewer.game.elementsViewer;
import org.game.gui.GUI;
import org.game.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui){
        gui.drawWall(wall.getPosition());
    }
}
