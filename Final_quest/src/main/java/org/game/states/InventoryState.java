package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.InventoryController;
import org.game.controller.menuController.MenuController;
import org.game.model.menu.Inventory;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.InventoryViewer;
import org.game.viewer.menu.MenuViewer;

import java.util.HashMap;
import java.util.Map;

public class InventoryState extends State<Inventory> {
    private Map.Entry<Integer,Integer> obs = Map.entry(2,0);
    public InventoryState(Inventory model) {
        super(model);
    }

    @Override
    protected Viewer<Inventory> getViewer() {
        return new InventoryViewer(getModel());
    }

    @Override
    protected Controller<Inventory> getController() {
        return new InventoryController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
