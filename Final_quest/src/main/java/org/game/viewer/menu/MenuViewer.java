package org.game.viewer.menu;


import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.Menu;
import org.game.music.Music;
import org.game.viewer.Viewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws  IOException {
        gui.drawText(new Position(25, 5), "FINAL QUEST", "#880808");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(27, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
