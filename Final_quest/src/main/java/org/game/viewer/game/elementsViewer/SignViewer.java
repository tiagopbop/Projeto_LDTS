package org.game.viewer.game.elementsViewer;

import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.Sign;

public class SignViewer implements ElementViewer<Sign>{
    @Override
    public void draw(Sign sign, GUI gui) {{gui.drawSign(sign);}

    }
}
