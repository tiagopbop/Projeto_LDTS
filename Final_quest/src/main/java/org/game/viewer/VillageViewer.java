package org.game.viewer;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.elements.Element;
import org.game.model.game.map.Village;
import org.game.viewer.game.elementsViewer.*;


import java.util.List;


public class VillageViewer extends  Viewer<Village> {
    public VillageViewer(Village village){
        super(village);
    }

    @Override
    public void drawElements(GUI gui){
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
        drawElements(gui, getModel().getNPC(), new NPCViewer());
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getDoors(), new DoorViewer());
        gui.drawText(new Position(0,0), "Final Quest", "#008000");
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
