package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.Death;

import java.io.IOException;

public class DeathController extends Controller<Death> {
    public DeathController(Death model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case BACK, ESC,SELECT:
                game.cleanStack();

                break;

        }
}}
