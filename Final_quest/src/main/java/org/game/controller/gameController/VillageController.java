package org.game.controller.gameController;

import org.game.model.game.map.Village;
import org.game.Game;
import org.game.gui.GUI;

import java.io.IOException;

public class VillageController extends GameController{
    private final HeroController heroController;
    public VillageController(Village village) {
        super(village);
        this.heroController = new HeroController(village);
    }

    public void step(Game game, GUI.ACTION action, long time) {
        heroController.step(game, action, time);
    }
}
