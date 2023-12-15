package org.game.states.battle;

import org.game.controller.Controller;
import org.game.controller.battleController.DeathController;
import org.game.model.battle.menus.Death;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.battle.DeathViewer;

import java.util.Map;

public class DeathState extends State<Death> {
    private Map.Entry<Integer,Integer> obs = Map.entry(4,0);
    public DeathState(Death model) {
        super(model);
    }

    @Override
    protected Viewer<Death> getViewer() {
        return new DeathViewer(getModel());
    }

    @Override
    protected Controller<Death> getController() {
        return new DeathController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
