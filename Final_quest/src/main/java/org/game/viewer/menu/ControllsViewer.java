package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.ControllManual;
import org.game.viewer.Viewer;

import java.io.IOException;

public class ControllsViewer extends Viewer<ControllManual> {
    public ControllsViewer(ControllManual manual) {
        super(manual);
    }

  @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(12,10),"Press 'Z' to interact with the world" , "#008000");
        gui.drawText(new Position(12,13),"Press 'P' check your status/inventory" , "#008000");
        gui.drawText(new Position(12,13),"Press 'B' to go back in menus" , "#008000");
        gui.drawText(new Position(12,16),"Press 'ESC' to go to the menu" , "#008000");
        gui.drawText(new Position(12,19),"Use the arrows to move" , "#008000");
        gui.drawText(new Position(12,22),"In menus use enter to select" , "#008000");
        gui.drawText(new Position(12,22),"If you ever rage press 'Q' to end it all" , "#008000");




  }
}