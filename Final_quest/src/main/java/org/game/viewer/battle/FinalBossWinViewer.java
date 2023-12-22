package org.game.viewer.battle;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.battle.menus.FinalBossWin;
import org.game.viewer.Viewer;

import java.io.IOException;

public class FinalBossWinViewer extends Viewer<FinalBossWin> {
    public FinalBossWinViewer(FinalBossWin model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {


        gui.drawText(
                new Position(25, 31), "LETS GOOOOO","#0000B3");
        String top;
        top="";
        for(int i = 0; i<61; i++){
            top+=(char)140;
        }
        gui.drawText(new Position(0,3), top, "#006400");
        gui.drawText(new Position(0,5), top, "#89ff67");
        gui.drawText(new Position(0,25), top, "#89ff67");
        gui.drawText(new Position(0,28), top, "#006400");

        String texto_final1 = "after a decisive battle against the cruel mclaren,";
        String texto3 = "our brave hero won! with that, the villages are";
        String texto2 = "finally able to expirience joy again and above all,";
        String t3 = "enjoy the cabages that their village is so proud off.";
        String t5 = "with the end of an era new mysterys emerge from ";
        String t4 = "the shadows in the super mega duper FINAL QUEST!";

        gui.drawText(new Position(5,9), texto_final1, "#FFFFFF");
        gui.drawText(new Position(5,11), texto3, "#FFFFFF");
        gui.drawText(new Position(5,13), texto2, "#FFFFFF");

        gui.drawText(new Position(5,15), t3, "#FFFFFF");
        gui.drawText(new Position(5,17), t5, "#FFFFFF");
        gui.drawText(new Position(5,19), t4, "#FFFFFF");


    }
}
