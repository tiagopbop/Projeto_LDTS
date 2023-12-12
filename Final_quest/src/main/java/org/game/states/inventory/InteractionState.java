package org.game.states.inventory;

import org.game.controller.Controller;
import org.game.controller.gameController.InteractionController;
import org.game.model.menu.InteractionMenu;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.inventory.InteractionViewer;

import java.util.Map;

public class InteractionState extends State<InteractionMenu> {
    private Map.Entry<Integer,Integer> obs = Map.entry(1,0);

    public InteractionState(InteractionMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InteractionMenu> getViewer() {
        return new InteractionViewer(getModel());
    }

    @Override
    protected Controller<InteractionMenu> getController() {
        return new InteractionController(getModel());
    }

    @Override
    public Map.Entry<Integer,Integer> getObs() {
        return obs;
    }
}
