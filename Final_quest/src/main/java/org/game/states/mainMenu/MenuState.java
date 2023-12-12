package org.game.states.mainMenu;


import org.game.controller.Controller;
import org.game.controller.mainMenuController.MenuController;
import org.game.model.menu.Menu;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.menu.MenuViewer;

import java.util.Map;

public class MenuState extends State<Menu> {
    private Map.Entry<Integer,Integer> obs = Map.entry(0,0);
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new  MenuController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
