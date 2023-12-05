package org.game.viewer;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.elements.Element;
import org.game.model.game.map.Village;
import org.game.viewer.game.elementsViewer.*;
import org.game.viewer.menu.DialogueViewerNarrator;


import java.io.IOException;
import java.util.List;


public class VillageViewer extends  Viewer<Village> {
    private String act;
    public VillageViewer(Village village) {
        super(village);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getHero().getHeroElement(), new HeroViewer());
        drawElements(gui, getModel().getNPC(), new NPCViewer());
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getDoors(), new DoorViewer());
        drawElements(gui, getModel().getDialogues1(), new DialogueViewer1());
        drawElements(gui, getModel().getDialogues2(), new DialogueViewer2());
        drawElements(gui, getModel().getDialogues3(), new DialogueViewer3());
        drawElements(gui, getModel().getDialogues4(), new DialogueViewer4());
        drawElements(gui, getModel().getDialogues5(), new DialogueViewer5());
        drawElements(gui, getModel().getSigns(), new SignViewer());
        drawElements(gui, getModel().getChests(), new ChestViewer());
        gui.drawText(new Position(0, 0), "Village", "#008000");

        drawNarrator(gui,getModel().getNarrator(),new DialogueViewerNarrator());
        drawElement(gui, getModel().getHero().getHeroElement(), new HeroViewer());

        gui.drawText(new Position(0,0), "Final Quest", "#008000");
    }

    public void set_last(String action)
    {this.act = action;}

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
