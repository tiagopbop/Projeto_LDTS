package org.game.controller.mainMenuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.MapLoader;

import org.game.model.menu.ControllManual;
import org.game.model.menu.Menu;
import org.game.states.map.MapState;
import org.game.states.mainMenu.ControllsState;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.game.Game.getHero;


public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
            case SELECT:
                if (getModel().isSelectedExit()) System.exit(0);
                MapState state = null;

                if (getModel().isSelectedStart()) {
                    state = (new MapState(new MapLoader("centralVillage", getHero()).createMap(getHero()),0));
                    getHero().getStatus().reset_status();
                    game.addState(state);
                }
                if(getModel().isSelectedContinue())
                {
                    if (game.getStateStack().size() >2) {
                        game.previousState();
                    }

                }
                if(getModel().isSelectedControlls())
                {
                     ControllsState ss = (new ControllsState(new ControllManual()));
                     game.addState(ss);
                }
        }
    }

}