package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.menus.FinalBossWin;
import org.game.model.menu.Menu;
import org.game.states.battle.FinalBossWinState;
import org.game.states.mainMenu.MenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class FinalBossWinController extends Controller<FinalBossWin> {
    public FinalBossWinController(FinalBossWin model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case BACK, ESC,SELECT:

                game.cleanStack();
                game.addState(new MenuState(new Menu()));
                getModel().getHero().getStatus().reset_status();
                getModel().getHero().reset_hero();
                break;

        }
    }
}
