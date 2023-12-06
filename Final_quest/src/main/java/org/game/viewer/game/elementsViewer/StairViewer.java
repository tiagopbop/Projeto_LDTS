package org.game.viewer.game.elementsViewer;
import org.game.gui.GUI;
import org.game.model.game.elements.Stairs;

public class StairViewer implements ElementViewer<Stairs>{
    @Override
    public void draw(Stairs stair, GUI gui){
        gui.drawStairs(stair);
    }
}
