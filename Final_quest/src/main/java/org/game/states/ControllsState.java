package org.game.states;

import org.game.controller.Controller;
import org.game.model.game.battle.ControllsController;
import org.game.model.menu.ControllManual;
import org.game.viewer.Viewer;
import org.game.viewer.menu.ControllsViewer;

public class ControllsState extends State<ControllManual>{

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
}
