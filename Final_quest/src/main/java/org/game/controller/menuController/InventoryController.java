package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.*;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.states.CheckAtackState;
import org.game.states.ControllsState;
import org.game.states.SelectionState;
import org.game.states.State;


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
                    game.addState(new SelectionState(new Selection(0, getModel().getInventario(),getModel().getHero())));

                            }
                if(getModel().isSelectedChestplates()) //neessario alterar para usar estado guardado
                {
                    game.addState(new SelectionState(new Selection(1, getModel().getInventario(),getModel().getHero())));

                }
                if(getModel().isSelectedPants())
                {
                    game.addState(new SelectionState(new Selection(2, getModel().getInventario(),getModel().getHero())));

                }
                if(getModel().isSelectedConsumables())
                {
                    game.addState(new SelectionState(new Selection(3, getModel().getInventario(),getModel().getHero())));

                }
                if(getModel().isSelectedMagic())
                {
                    game.addState(new CheckAtackState(new CheckAtack(1,getModel().getInventario(),getModel().getHero())));

                }
                if(getModel().isSelectedMelee())
                {
                    game.addState(new CheckAtackState(new CheckAtack( 0,getModel().getInventario(),getModel().getHero())));

                }
        }
    }}


