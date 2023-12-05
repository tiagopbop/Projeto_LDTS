package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.InteractionMenu;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;

import java.io.IOException;

public class InteractionViewer extends Viewer<InteractionMenu> {
    public InteractionViewer(InteractionMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(27, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
