package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Death;
import org.game.viewer.Viewer;

import java.io.IOException;

public class DeathViewer extends Viewer<Death> {
    public DeathViewer(Death model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        for(int i = 0; i<33; i++)
        {
            gui.drawText(new Position(3,i+1), "GAME OVER", "#F31414");
            gui.drawText(new Position(50,i+1), "GAME OVER", "#F31414");
        }
        String lost = "YOU HAVE LOST " + String.valueOf(getModel().getHero().getHero_inventario().getDinheiro())   + " GOLD";
        gui.drawText(new Position(29, 20), "ok","#2ECC71");
        gui.drawText(new Position(20, 15), lost,"#F31414");

    }
}
