package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.Map;
import org.game.model.game.map.MapBuilder;
import org.game.model.game.map.MapLoader;
import org.game.model.menu.Menu;
import org.game.states.MapState;

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
                MapState state = null;
                if (getModel().isSelectedStart()) {
                    state = (new MapState(new MapLoader("centralVillage").createMap(game.getHero())));
                    game.addState(state);

                }
                if(getModel().isSelectedContinue()) //neessario alterar para usar estado guardado
                {
                    /*state = (new MapState(new MapLoader("last_location").createMap()));
                    game.addState(state);*/
                }
        }
    }

}
