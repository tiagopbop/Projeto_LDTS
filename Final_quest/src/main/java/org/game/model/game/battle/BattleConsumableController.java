package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;

import java.io.IOException;
import java.net.URISyntaxException;

public class BattleConsumableController extends Controller<BattleConsumableMenu> {
    public BattleConsumableController(BattleConsumableMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
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
            case SELECT:
                game.previousState();
    }
}}
