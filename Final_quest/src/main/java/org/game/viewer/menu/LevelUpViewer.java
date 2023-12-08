package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.LevelUp;
import org.game.viewer.Viewer;

import java.io.IOException;

public class LevelUpViewer extends Viewer<LevelUp> {
    public LevelUpViewer(LevelUp model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(27, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

        drawDesign(gui);
    }

    public void drawDesign(GUI gui)
    {
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
        for(int i = 0; i<22; i++){
            gui.drawText(new Position(0,i+1), top, "#008000");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<22; i++){
            gui.drawText(new Position(60,i+1), top, "#008000");

        }






         top = new String("");
        top += (char)130;
        gui.drawText(new Position(5,5),top , "#008000");
        gui.drawText(new Position(0,27),top , "#008000");
        gui.drawText(new Position(55,27), top, "#008000");
        gui.drawText(new Position(55,0), top, "#008000");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(6,0), top, "#008000");

        top="";
        for(int i = 0; i<49; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(6,32), top, "#008000");

        top = "";
        top += (char)142;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(0,i+6), top, "#008000");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<31; i++){
            gui.drawText(new Position(55,i+6), top, "#008000");

        }






/*

         top = new String("");
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

        }*/
    }
}
