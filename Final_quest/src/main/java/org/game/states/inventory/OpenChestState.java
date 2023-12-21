package org.game.states.inventory;

import org.game.controller.Controller;
import org.game.controller.inventortController.InventoryController;
import org.game.controller.inventortController.OpenChestController;
import org.game.model.menu.Inventory;
import org.game.model.menu.OpenChest;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.inventory.InventoryViewer;
import org.game.viewer.inventory.OpenChestViewer;

import java.util.Map;

public class OpenChestState extends State<OpenChest> {
    private Map.Entry<Integer,Integer> obs = Map.entry(11,0);
    public OpenChestState(OpenChest model) {
        super(model);
    }

    @Override
    protected Viewer<OpenChest> getViewer() {
        return new OpenChestViewer(getModel());
    }

    @Override
    protected Controller<OpenChest> getController() {
        return new OpenChestController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
