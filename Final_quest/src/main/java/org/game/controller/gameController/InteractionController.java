package org.game.controller.gameController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.InteractionMenu;
import org.game.model.menu.Shop;
import org.game.states.inventory.ShopState;

import java.io.IOException;
import java.net.URISyntaxException;


public class InteractionController extends Controller<InteractionMenu> {
    public InteractionController(InteractionMenu interactionMenu) {
        super(interactionMenu);
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
            case SELECT:
                if (getModel().isSelectedYes())
                {
                    game.addState(new ShopState(new Shop(game.getHero())));

                }
                else if (getModel().isSelectedNo()) {
                }

                    game.previousState();

                }

        }
    }
