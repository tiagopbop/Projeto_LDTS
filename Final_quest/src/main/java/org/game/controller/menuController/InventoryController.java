package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.ControllManual;
import org.game.model.menu.Inventory;
import org.game.model.menu.Menu;
import org.game.states.ControllsState;


import java.io.IOException;

public class InventoryController extends Controller<Inventory> {
    public InventoryController(Inventory model) {
        super(model);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    game.previousState();
                }

                if (getModel().isSelectedHelmets()) {
                    game.previousState();
                }
                if(getModel().isSelectedChestplates()) //neessario alterar para usar estado guardado
                {
                        game.previousState();
                }
                if(getModel().isSelectedPants())
                {
                    game.previousState();
                }
                if(getModel().isSelectedConsumables())
                {
                    game.previousState();
                }
        }
    }

}
