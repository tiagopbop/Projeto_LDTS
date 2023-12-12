package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.InteractionController;
import org.game.model.menu.InteractionMenu;
import org.game.viewer.Viewer;
import org.game.viewer.MapViewer;
import org.game.viewer.menu.InteractionViewer;

import java.util.HashMap;
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
