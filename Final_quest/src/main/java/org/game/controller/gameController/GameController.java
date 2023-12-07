package org.game.controller.gameController;

import org.game.controller.Controller;
import org.game.model.game.map.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map){
        super(map);
    }
}
