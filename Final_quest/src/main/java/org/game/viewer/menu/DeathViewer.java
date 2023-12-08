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
        gui.drawText(
                new Position(29, 20), "ok","#0000B3");
    }
}
