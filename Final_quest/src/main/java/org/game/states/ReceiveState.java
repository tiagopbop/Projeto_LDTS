package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.ReceiveController;
import org.game.controller.menuController.SelectionController;
import org.game.model.menu.Receive;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;
import org.game.viewer.menu.ReceiveViewer;
import org.game.viewer.menu.SelectionViewer;

public class ReceiveState extends State<Receive> {
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
}
