package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.MenuController;
import org.game.controller.menuController.SelectionController;
import org.game.model.menu.Menu;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;
import org.game.viewer.menu.MenuViewer;
import org.game.viewer.menu.SelectionViewer;

public class SelectionState extends State<Selection> {
    public SelectionState(Selection model) {
        super(model);
    }

    @Override
    protected Viewer<Selection> getViewer() {
        return new SelectionViewer(getModel());
    }

    @Override
    protected Controller<Selection> getController() {
        return new SelectionController(getModel());
    }

}
