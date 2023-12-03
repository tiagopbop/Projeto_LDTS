package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.battle.Battle;

import java.io.IOException;

public class BattleController extends Controller<Battle> {
    public BattleController(Battle battle){
        super(battle);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }


}
