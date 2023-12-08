package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.DeathController;
import org.game.controller.menuController.ReceiveController;
import org.game.model.menu.Death;
import org.game.model.menu.Receive;
import org.game.viewer.Viewer;
import org.game.viewer.menu.DeathViewer;
import org.game.viewer.menu.ReceiveViewer;

public class DeathState extends State<Death>{
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
}
