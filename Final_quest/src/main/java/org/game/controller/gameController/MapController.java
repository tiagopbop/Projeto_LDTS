package org.game.controller.gameController;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.game.map.Map;

import java.io.IOException;

public class MapController extends GameController{
    private final HeroController heroController;
    private final DialogueController dialogueController;
    public MapController(Map map) {
        super(map);
        this.heroController = new HeroController(map);
        this.dialogueController = new DialogueController(map);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT){
            System.exit(0);
        }
        else{

                heroController.step(game, action, time);
                dialogueController.step(game, action, time);

        }

    }
}
