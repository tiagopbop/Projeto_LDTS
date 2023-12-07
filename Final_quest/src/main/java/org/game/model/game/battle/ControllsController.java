package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.ControllManual;

import java.io.IOException;
import java.util.Objects;

public class ControllsController extends Controller<ControllManual> {
    public ControllsController(ControllManual model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (Objects.requireNonNull(action) == GUI.ACTION.BACK || Objects.requireNonNull(action)==GUI.ACTION.ESC) {
            game.previousState();
        }

    }
}
