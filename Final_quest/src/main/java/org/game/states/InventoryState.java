package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.InventoryController;
import org.game.controller.menuController.MenuController;
import org.game.model.menu.Inventory;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.InventoryViewer;
import org.game.viewer.menu.MenuViewer;

public class InventoryState extends State<Inventory> {
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
}
