package org.game.controller.inventortController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.*;
import org.game.states.inventory.SelectionState;


import java.io.IOException;
import java.net.URISyntaxException;

public class InventoryController extends Controller<Inventory> {
    public InventoryController(Inventory model) {
        super(model);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case BACK:
                game.previousState();
                break;
            case ESC:
                game.previousState();
                break;


            case SELECT:
                if (getModel().isSelectedExit()) {
                    game.previousState();
                }

                if (getModel().isSelectedHelmets()) {
                    game.addState(new SelectionState(new Selection(0,getModel().getHero())));

                            }
                if(getModel().isSelectedChestplates()) //neessario alterar para usar estado guardado
                {
                    game.addState(new SelectionState(new Selection(1,getModel().getHero())));

                }
                if(getModel().isSelectedPants())
                {
                    game.addState(new SelectionState(new Selection(2,getModel().getHero())));

                }
                if(getModel().isSelectedConsumables())
                {
                    game.addState(new SelectionState(new Selection(3,getModel().getHero())));

                }
                if(getModel().isSelectedMagic())
                {
                    game.addState(new SelectionState(new Selection(5,getModel().getHero())));

                }
                if(getModel().isSelectedMelee())
                {
                    game.addState(new SelectionState(new Selection( 4,getModel().getHero())));

                }
        }
    }}


