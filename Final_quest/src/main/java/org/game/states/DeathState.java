package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.DeathController;
import org.game.controller.menuController.ReceiveController;
import org.game.model.menu.Death;
import org.game.model.menu.Receive;
import org.game.viewer.Viewer;
import org.game.viewer.menu.DeathViewer;
import org.game.viewer.menu.ReceiveViewer;

import java.util.HashMap;
import java.util.Map;

public class DeathState extends State<Death>{
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
