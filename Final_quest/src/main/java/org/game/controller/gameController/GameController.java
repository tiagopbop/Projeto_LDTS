package org.game.controller.gameController;

import org.game.controller.Controller;
import org.game.model.game.map.Village;

public abstract class GameController extends Controller<Village> {
    public GameController(Village village){
        super(village);
    }
}
