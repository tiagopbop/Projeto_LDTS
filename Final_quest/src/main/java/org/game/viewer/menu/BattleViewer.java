package org.game.viewer.menu;

import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.menu.BattleMenu;
import org.game.model.menu.InteractionMenu;
import org.game.states.BattleState;
import org.game.viewer.Viewer;

import java.io.IOException;



    public class BattleViewer extends Viewer<BattleMenu> {
        public BattleViewer(BattleMenu menu) {
            super(menu);
        }

        @Override
        public void drawElements(GUI gui) throws IOException {
            gui.drawText(
                    new Position(20 , 7 ),
                    getModel().getEntry(0),
                    getModel().isSelectedMelee() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(40, 7 ),
                    getModel().getEntry(1),
                    getModel().isSelectedMagic() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(20, 13 ),
                    getModel().getEntry(2),
                    getModel().isSelectedConsume() ? "#FFD700" : "#FFFFFF");

            gui.drawText(
                    new Position(40 , 13 ),
                    getModel().getEntry(3),
                    getModel().isSelectedRun() ? "#FFD700" : "#FFFFFF");


        }
    }


