package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.MenuController;
import org.game.controller.menuController.SelectionController;
import org.game.model.menu.Menu;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;
import org.game.viewer.menu.MenuViewer;
import org.game.viewer.menu.SelectionViewer;

import java.util.HashMap;
import java.util.Map;

public class SelectionState extends State<Selection> {
    private Map.Entry<Integer,Integer> obs = Map.entry(2,0);
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

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
