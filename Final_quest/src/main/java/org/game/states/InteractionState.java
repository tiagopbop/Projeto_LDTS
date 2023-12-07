package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.InteractionController;
import org.game.model.menu.InteractionMenu;
import org.game.viewer.Viewer;
import org.game.viewer.MapViewer;
import org.game.viewer.menu.InteractionViewer;

public class InteractionState extends State<InteractionMenu> {
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

}
