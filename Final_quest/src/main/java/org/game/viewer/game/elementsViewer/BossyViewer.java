package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.Bossy;

public class BossyViewer implements ElementViewer<Bossy>{
    @Override
    public void draw(Bossy bossy, GUI gui){
        gui.drawBossy(bossy);
    }
}
