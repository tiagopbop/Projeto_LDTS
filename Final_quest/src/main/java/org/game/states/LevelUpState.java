package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.LevelUpController;
import org.game.controller.menuController.MenuController;
import org.game.model.menu.LevelUp;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.LevelUpViewer;
import org.game.viewer.menu.MenuViewer;

import java.util.HashMap;
import java.util.Map;

public class LevelUpState extends State<LevelUp> {
    private Map.Entry<Integer,Integer> obs = Map.entry(3,0);
    public LevelUpState(LevelUp model) {
        super(model);
    }

    @Override
    protected Viewer<LevelUp> getViewer() {
        return new LevelUpViewer(getModel());
    }

    @Override
    protected Controller<LevelUp> getController() {
        return new LevelUpController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
