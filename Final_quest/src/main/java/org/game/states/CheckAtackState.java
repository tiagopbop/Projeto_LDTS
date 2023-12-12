package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.CheckAtackController;
import org.game.controller.menuController.SelectionController;
import org.game.model.menu.CheckAtack;
import org.game.model.menu.Selection;
import org.game.viewer.Viewer;
import org.game.viewer.menu.CheckAtackViewer;
import org.game.viewer.menu.SelectionViewer;

import java.util.HashMap;
import java.util.Map;

public class CheckAtackState extends State<CheckAtack> {
    private Map.Entry<Integer,Integer> obs = Map.entry(2,0);
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

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
