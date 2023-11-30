package org.game.viewer;

import org.game.gui.GUI;
import org.game.model.game.elements.Element;
import org.game.model.game.map.Village;
import org.game.viewer.game.elementsViewer.ElementViewer;
import org.game.viewer.game.elementsViewer.WallViewer;
import org.game.viewer.game.elementsViewer.HeroViewer;


import java.util.List;


public class VillageViewer extends  Viewer<Village> {
    public VillageViewer(Village village){
        super(village);
    }

    @Override
    public void drawElements(GUI gui){
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer){
        for(T element : elements){
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer){
        viewer.draw(element, gui);
    }
}
