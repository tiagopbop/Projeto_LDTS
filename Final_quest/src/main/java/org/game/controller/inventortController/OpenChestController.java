package org.game.controller.inventortController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.elements.interactabel.Chest;
import org.game.model.menu.OpenChest;

import java.io.IOException;
import java.net.URISyntaxException;

public class OpenChestController extends Controller<OpenChest> {
    public OpenChestController(OpenChest model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action){
            case BACK ,ESC,SELECT:
                game.previousState();
                break;
        }
    }
}
