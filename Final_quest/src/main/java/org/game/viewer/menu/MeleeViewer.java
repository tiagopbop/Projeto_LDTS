package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.battle.BattleMenu;
import org.game.model.game.battle.MeleeMenu;
import org.game.viewer.Viewer;

import java.io.IOException;

public class MeleeViewer extends Viewer<MeleeMenu> {
    public MeleeViewer(MeleeMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {

        drawCombatZone(gui);


        gui.drawText(
                new Position(27, 23 ),
                getModel().getEntry(0),
                getModel().isSelectedMelee() ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(44, 23 ),
                getModel().getEntry(1),
                getModel().isSelectedMagic() ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(25, 27 ),
                getModel().getEntry(2),
                getModel().isSelectedConsume() ? "#FFD700" : "#FFFFFF");

        gui.drawText(
                new Position(45 , 27 ),
                getModel().getEntry(3),
                getModel().isSelectedRun() ? "#FFD700" : "#FFFFFF");


    }


    public void drawCombatZone(GUI gui) throws IOException {
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

        top ="";
        top += (char)130;
        gui.drawText(new Position(20,20),top , "#BF40BF");
        gui.drawText(new Position(20,30),top , "#BF40BF");
        gui.drawText(new Position(56,30), top, "#BF40BF");
        gui.drawText(new Position(56,20), top, "#BF40BF");

        //rosa
        top="";
        for(int i = 0; i<35; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(21,20), top, "#BF40BF");

        top="";
        for(int i = 0; i<35; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(21,30), top, "#BF40BF");

        top = "";
        top += (char)142;
        for(int i = 0; i<9; i++){
            gui.drawText(new Position(20,i+21), top, "#BF40BF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<9; i++){
            gui.drawText(new Position(56,i+21), top, "#BF40BF");

        }





        //azul
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,25), top, "#0000B3");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,30), top, "#0000B3");

        top = "";
        top += (char)142;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(17,i+25), top, "#0000B3");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(3,i+25), top, "#0000B3");

        }


        //branco
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(4,14), top, "#FFFFFF");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(4,23), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(17,i+14), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<10; i++){
            gui.drawText(new Position(3,i+14), top, "#FFFFFF");

        }





        //monster
        top="";
        for(int i = 0; i<20; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(20,2), top, "#FFFFFF");

        top="";
        for(int i = 0; i<20; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(20,17), top, "#FFFFFF");

        top = "";
        top += (char)142;
        for(int i = 0; i<16; i++){
            gui.drawText(new Position(40,i+2), top, "#FFFFFF");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<16; i++){
            gui.drawText(new Position(20,i+2), top, "#FFFFFF");

        }


        //monster status
        top="";
        for(int i = 0; i<13; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(42,2), top, "#0000B3");

        top="";
        for(int i = 0; i<13; i++){
            top+=(char)141;
        }
        gui.drawText(new Position(42,7), top, "#0000B3");

        top = "";
        top += (char)142;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(55,i+2), top, "#0000B3");

        }
        top = "";
        top += (char)143;
        for(int i = 0; i<6; i++){
            gui.drawText(new Position(42,i+2), top, "#0000B3");

        }


    }
}
