package org.game.states.mainMenu;

import org.game.controller.Controller;
import org.game.controller.battleController.ControllsController;
import org.game.model.menu.ControllManual;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.menu.ControllsViewer;

import java.util.Map;

public class ControllsState extends State<ControllManual> {
    private Map.Entry<Integer,Integer> obs = Map.entry(0,0);


    public ControllsState(ControllManual model) {
        super(model);
    }

    @Override
    protected Viewer<ControllManual> getViewer() {
        return new ControllsViewer(getModel());
    }

    @Override
    protected Controller<ControllManual> getController() {
        return new ControllsController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
