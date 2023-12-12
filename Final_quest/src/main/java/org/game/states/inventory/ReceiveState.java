package org.game.states.inventory;

import org.game.controller.Controller;
import org.game.controller.inventortController.ReceiveController;
import org.game.model.menu.Receive;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.inventory.ReceiveViewer;

import java.util.Map;

public class ReceiveState extends State<Receive> {
    private Map.Entry<Integer,Integer> obs = Map.entry(3,0);

    public ReceiveState(Receive model) {
        super(model);
    }

    @Override
    protected Viewer<Receive> getViewer() {
        return new ReceiveViewer(getModel());
    }

    @Override
    protected Controller<Receive> getController() {
        return new ReceiveController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}

