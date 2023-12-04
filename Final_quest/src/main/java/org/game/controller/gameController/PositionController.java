package org.game.controller.gameController;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.game.map.Village;

import java.io.IOException;

public class PositionController extends GameController {
    public PositionController(Village village) {
        super(village);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
    public Boolean CheckNear(Position position)
    {



        return false;
    }


}
