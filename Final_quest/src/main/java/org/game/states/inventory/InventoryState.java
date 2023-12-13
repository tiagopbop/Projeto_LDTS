package org.game.states.inventory;

import org.game.controller.Controller;
import org.game.controller.inventortController.InventoryController;
import org.game.model.menu.Inventory;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.inventory.InventoryViewer;

import java.util.Map;

public class InventoryState extends State<Inventory> {
    private Map.Entry<Integer,Integer> obs = Map.entry(1,10);
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
