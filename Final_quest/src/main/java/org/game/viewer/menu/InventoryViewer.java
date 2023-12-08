package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Inventory;
import org.game.viewer.Viewer;

import java.io.IOException;

public class InventoryViewer extends Viewer<Inventory> {
    public InventoryViewer(Inventory model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws  IOException {
        gui.drawText(new Position(34, 5), "Inventory", "#008000");
        drawInventory(gui);
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(34, 10 + 2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#0000B3" : "#FFFFFF");
    }

    public void drawInventory(GUI gui) throws IOException {
        //verde
        String top = new String("");
        top += (char)130;
        gui.drawText(new Position(0,0),top , "#008000");
        gui.drawText(new Position(0,32),top , "#008000");
        gui.drawText(new Position(60,32), top, "#008000");
        gui.drawText(new Position(60,0), top, "#008000");



        top="";
        for(int i = 0; i<59; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(1,0), top, "#008000");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(1,32), top, "#008000");

        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(0,i+1), top, "#008000");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(60,i+1), top, "#008000");

        }

        top = new String("");
        top += (char)130;
        gui.drawText(new Position(20,0),top , "#008000");
        gui.drawText(new Position(20,32),top , "#008000");
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(20,i+1), top, "#008000");

        }

        //branco
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,5), top, "#FFFFFF");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,14), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(17,i+5), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(3,i+5), top, "#FFFFFF");

        }



}}

