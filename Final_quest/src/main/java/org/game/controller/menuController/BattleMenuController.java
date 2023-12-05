package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.VillageLoader;
import org.game.model.menu.BattleMenu;
import org.game.model.menu.Menu;
import org.game.states.VillageState;

import java.io.IOException;

public class BattleMenuController extends Controller<BattleMenu> {
    public BattleMenuController(BattleMenu bm) {
        super(bm);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().nextEntryUp();
                break;
            case DOWN:
                getModel().nextEntryDown();
                break;
            case LEFT:
                getModel().nextEntryLeft();
                break;
            case RIGHT:
                getModel().nextEntryRight();
                break;

            case SELECT:
                if (getModel().isSelectedMelee())
                {
                    game.previousState();
                }
                if (getModel().isSelectedMagic()) {
                    game.previousState();
                }
                if (getModel().isSelectedConsume())
                    game.previousState();
                }
                if (getModel().isSelectedRun()) {
                    game.previousState();
                }
        }

    }

