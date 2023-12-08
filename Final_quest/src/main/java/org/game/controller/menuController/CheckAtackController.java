package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.CheckAtack;

import java.io.IOException;

public class CheckAtackController extends Controller<CheckAtack> {
    public CheckAtackController(CheckAtack model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case BACK:
                game.previousState();
                break;
            case ESC:
                game.previousState();
                break;
            case SELECT:
                game.previousState();
                break;
    }
}}
