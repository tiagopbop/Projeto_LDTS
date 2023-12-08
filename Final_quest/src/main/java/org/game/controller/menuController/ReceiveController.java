package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.Receive;

import java.io.IOException;

public class ReceiveController extends Controller<Receive> {
    public ReceiveController(Receive model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case BACK, ESC,SELECT:
                game.previousState();
                game.previousState();
                game.previousState();
                break;

        }
    }
}