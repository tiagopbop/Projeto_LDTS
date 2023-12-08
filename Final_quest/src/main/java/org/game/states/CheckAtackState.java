package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.CheckAtackController;
import org.game.controller.menuController.SelectionController;
import org.game.model.menu.CheckAtack;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;
import org.game.viewer.menu.CheckAtackViewer;
import org.game.viewer.menu.SelectionViewer;

public class CheckAtackState extends State<CheckAtack> {
    public CheckAtackState(CheckAtack model) {
        super(model);
    }

    @Override
    protected Viewer<CheckAtack> getViewer() {
        return new CheckAtackViewer(getModel());
    }

    @Override
    protected Controller<CheckAtack> getController() {
        return new CheckAtackController(getModel());
    }

}
