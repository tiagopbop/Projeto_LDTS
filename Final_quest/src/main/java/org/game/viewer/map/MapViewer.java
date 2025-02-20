package org.game.viewer.map;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.elements.interactabel.Bossy;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.model.game.elements.Element;
import org.game.model.game.map.Map;
import org.game.viewer.Viewer;
import org.game.viewer.game.elementsViewer.*;


import java.io.IOException;
import java.util.List;


public class MapViewer extends Viewer<Map> {
    private String act;
    public MapViewer(Map map) {
        super(map);
    }


    @Override
    public void drawElements(GUI gui) throws IOException {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getHero().getHeroElement(), new HeroViewer());
        drawElements(gui, getModel().getNPC(), new NPCViewer());
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getDoors(), new DoorViewer());
        drawElements(gui, getModel().getSigns(), new SignViewer());
        drawElements(gui, getModel().getChests(), new ChestViewer());
        drawElements(gui,getModel().getBossy(), new BossyViewer());
        gui.drawText(new Position(0, 0), "Village", "#008000");

        drawNarrator(gui,getModel().getNarrator(),new DialogueViewerNarrator());
        drawElement(gui, getModel().getHero().getHeroElement(), new HeroViewer());

        gui.drawText(new Position(0,0), "Final Quest", "#008000");

        if(getModel().getOptions() == 2) {
            drawOptions2(gui);
        }else if(getModel().getOptions() == 1) {
            drawOptions1(gui);
        }
    }

    private void drawOptions2(GUI gui) {
        gui.drawText(
                new Position(56, 28),
                getModel().getEntry(0),
                getModel().isSelected(0) ? "#FFD700" : "#FFFFFF");
        gui.drawText(
                new Position(56, 30),
                getModel().getEntry(1),
                getModel().isSelected(1) ? "#FFD700" : "#FFFFFF");
    }

    private void drawOptions1(GUI gui) {
        gui.drawText(
                new Position(56, 28),
                "NEXT",
                "#FFD700");
    }




    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private void drawNarrator(GUI gui, Dialogue dialogue, DialogueViewerNarrator viewer) throws IOException {
        viewer.draw(dialogue, gui);
    }

}
