package org.game.states.inventory;

import org.game.controller.Controller;
import org.game.controller.inventortController.InventoryController;
import org.game.controller.inventortController.ShopController;
import org.game.model.menu.Inventory;
import org.game.model.menu.Shop;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.inventory.InventoryViewer;
import org.game.viewer.inventory.ShopViewer;

import java.util.Map;

public class ShopState extends State<Shop> {
    private Map.Entry<Integer,Integer> obs = Map.entry(7,0);
    public ShopState(Shop model) {
        super(model);
    }

    @Override
    protected Viewer<Shop> getViewer() {
        return new ShopViewer(getModel());
    }

    @Override
    protected Controller<Shop> getController() {
        return new ShopController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
