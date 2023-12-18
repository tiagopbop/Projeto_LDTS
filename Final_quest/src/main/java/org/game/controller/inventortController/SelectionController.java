package org.game.controller.inventortController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.menu.Selection;
import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.status.statusCommands.Atualizar_Equipado;
import org.game.rpg_elements.status.statusCommands.Usar_Item;
import org.game.states.inventory.SelectionState;

import java.io.IOException;
import java.net.URISyntaxException;

public class SelectionController extends Controller<Selection> {
    public SelectionController(Selection model) {
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
                if(getModel().getPlate() < 4) {
                    int pos = getModel().getCurrentEntry();
                    Item item = getModel().getL_itens().get(pos);

                    if (getModel().getPlate() == 0 || getModel().getPlate() == 1 || getModel().getPlate() == 2) {

                        getModel().getHero().getHero_inventario().swap_armor(item);
                        new Atualizar_Equipado(getModel().getHero().getStatus(), getModel().getHero().getHero_inventario().getEquipado(), false).execute();

                        game.previousState();
                        game.addState(new SelectionState(new Selection(getModel().getPlate(), getModel().getHero())));
                    } else if (getModel().getPlate() == 3) {

                        if (item.getType().equals("pocao cura")) {
                            new Usar_Item(getModel().getHero().getStatus(), item).execute();
                            getModel().getHero().getHero_inventario().remove_consumivel(item);

                            game.previousState();
                            game.addState(new SelectionState(new Selection(3, getModel().getHero())));
                        }
                    }
                }

                break;

        }
    }
}