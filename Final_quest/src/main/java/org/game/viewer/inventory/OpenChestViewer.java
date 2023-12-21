package org.game.viewer.inventory;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.OpenChest;
import org.game.viewer.Viewer;

import java.io.IOException;

public class OpenChestViewer extends Viewer<OpenChest> {
    public OpenChestViewer(OpenChest model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {

        drawDesign(gui);

        gui.drawText(
                new Position(22,9),
                "You have received:",
                "#FFFFFF");
            gui.drawText(
                    new Position(30, 18),
                    "ok","#FFD700");

            gui.drawText(new Position( 24, 13), getModel().getItem().getNome(),"#FFFFFF");
    }

    public void drawDesign(GUI gui)
    {
        String top = new String("");
        top += (char)130;
        gui.drawText(new Position(0,0),top , "#E4D00A");
        gui.drawText(new Position(0,32),top , "#E4D00A");
        gui.drawText(new Position(60,32), top, "#E4D00A");
        gui.drawText(new Position(60,0), top, "#E4D00A");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(1,0), top, "#E4D00A");

        top="";
        for(int i = 0; i<59; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(1,32), top, "#E4D00A");

        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(0,i+1), top, "#E4D00A");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(60,i+1), top, "#E4D00A");

        }






        top = new String("");
        top += (char)130;
        gui.drawText(new Position(5,5),top , "#808080");
        gui.drawText(new Position(5,27),top , "#808080");
        gui.drawText(new Position(55,27), top, "#808080");
        gui.drawText(new Position(55,5), top, "#808080");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(6,5), top, "#808080");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(6,27), top, "#808080");

        top = "";
        top += (char)142;
        for(int i = 0; i<21; i++){
            gui.drawText(new Position(5,i+6), top, "#808080");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<21; i++){
            gui.drawText(new Position(55,i+6), top, "#808080");

        }


    }}


