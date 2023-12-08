package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.CheckAtack;
import org.game.viewer.Viewer;

import java.io.IOException;

public class CheckAtackViewer extends Viewer<CheckAtack> {
    public CheckAtackViewer(CheckAtack model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(40, 30), "Press 'b' to back", "#FFFFFF");
        drawHero(gui);
        int morm = getModel().getPlate();

        if (morm == 0) {
            drawMelee(gui);
            gui.drawText(new Position(31, 5), "Melee Atacks", "#FFBF00");

            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(
                        new Position(32, 7 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
            }
        }


        else {
            gui.drawText(new Position(31, 5), "Magic Atacks", "#800080");
            drawMagic(gui);
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(
                        new Position(32, 7 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
            }

        }
    }

    public void drawHero(GUI gui) throws IOException {
        //branco
        gui.drawText(
                new Position(8 , 2 ),
                getModel().getHero().getStatus().getNome(),
                "#FFFFFF");
        String top;
        top = "";
        for (int i = 0; i < 13; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(4, 5), top, "#FFFFFF");

        top = "";
        for (int i = 0; i < 13; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(4, 14), top, "#FFFFFF");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 10; i++) {
            gui.drawText(new Position(17, i + 5), top, "#FFFFFF");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 10; i++) {
            gui.drawText(new Position(3, i + 5), top, "#FFFFFF");
        }
    }
    public void drawMelee(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char) 130;
        gui.drawText(new Position(0, 0), top, "#FFBF00");
        gui.drawText(new Position(0, 32), top, "#FFBF00");
        gui.drawText(new Position(60, 32), top, "#FFBF00");
        gui.drawText(new Position(60, 0), top, "#FFBF00");


        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(1, 0), top, "#FFBF00");

        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(1, 32), top, "#FFBF00");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(0, i + 1), top, "#FFBF00");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(60, i + 1), top, "#FFBF00");

        }




        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#FFBF00");
        gui.drawText(new Position(20,32),top , "#FFBF00");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#FFBF00");

        }
    }
    public void drawMagic(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char) 130;
        gui.drawText(new Position(0, 0), top, "#800080");
        gui.drawText(new Position(0, 32), top, "#800080");
        gui.drawText(new Position(60, 32), top, "#800080");
        gui.drawText(new Position(60, 0), top, "#800080");


        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 140;
        }
        gui.drawText(new Position(1, 0), top, "#800080");

        top = "";
        for (int i = 0; i < 59; i++) {
            top += (char) 141;
        }
        gui.drawText(new Position(1, 32), top, "#800080");

        top = "";
        top += (char) 142;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(0, i + 1), top, "#800080");

        }
        top = "";
        top += (char) 143;
        for (int i = 0; i < 31; i++) {
            gui.drawText(new Position(60, i + 1), top, "#800080");

        }

        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#800080");
        gui.drawText(new Position(20,32),top , "#800080");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#800080");

        }
    }
}