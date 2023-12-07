package org.game.controller.gameController;

import org.game.model.game.map.Village;
import org.game.Game;
import org.game.gui.GUI;
import org.game.model.game.map.VillageLoader;
import org.game.model.menu.Menu;
import org.game.states.MenuState;
import org.game.states.VillageState;

import java.io.IOException;

public class VillageController extends GameController{
    private final HeroController heroController;
    private final DialogueController dialogueController;
    public VillageController(Village village) {
        super(village);
        this.heroController = new HeroController(village);
        this.dialogueController = new DialogueController(village);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(getModel().getOptions())
        {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedNo()){
                        getModel().setOptions(false);
                    }

                    if (getModel().isSelectedYes()) {
                        game.previousState();
                    }

            }}

        if (action == GUI.ACTION.QUIT){
            System.exit(0);
        }
        else if(action==GUI.ACTION.ESC)
        {
            game.addState(new MenuState(new Menu()));
        }

        else{
                heroController.step(game, action, time);
                dialogueController.step(game, action, time);

        }

    }
}
