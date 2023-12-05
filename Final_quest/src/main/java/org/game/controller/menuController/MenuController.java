package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.Village;
import org.game.model.game.map.VillageBuilder;
import org.game.model.game.map.VillageLoader;
import org.game.model.menu.Menu;
import org.game.states.VillageState;

import java.io.IOException;


public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) System.exit(0);
                VillageState state = null;
                if (getModel().isSelectedStart()) {
                    state = (new VillageState(new VillageLoader().createVillage()));
                    game.addState(state);

                }
                if(getModel().isSelectedContinue()) //neessario alterar para usar estado guardado
                {
                    state = (new VillageState(new VillageLoader().createVillage()));
                    game.SetState(state);
                }
        }
    }

}
