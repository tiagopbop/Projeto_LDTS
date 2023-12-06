package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.Path;

public class PathViewer implements ElementViewer<Path> {
    @Override
    public void draw(Path path, GUI gui){
        gui.drawPath(path.getPosition());
    }
}
