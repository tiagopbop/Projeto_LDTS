package org.game.states.battle;

import org.game.controller.Controller;
import org.game.controller.battleController.LevelUpController;
import org.game.model.menu.LevelUp;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.battle.LevelUpViewer;

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
