package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.menus.Death;

import java.io.IOException;
import java.net.URISyntaxException;

public class DeathController extends Controller<Death> {
    public DeathController(Death model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case BACK, ESC,SELECT:
                getModel().getHero().getStatus().reset_status();

                game.cleanStack();
                break;

        }
}}
