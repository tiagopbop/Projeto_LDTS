package org.game.controller.menuController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.MapLoader;
import org.game.model.menu.LevelUp;
import org.game.model.menu.Receive;
import org.game.states.MapState;
import org.game.states.ReceiveState;

import java.io.IOException;
import java.net.URISyntaxException;

public class LevelUpController extends Controller<LevelUp> {
    public LevelUpController(LevelUp model) {
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
            case BACK, ESC,SELECT:
                if (getModel().isSelectedHP()) {
                    getModel().getHero().getStatus().getAtributos_real().add_vida(5);
                }
                if (getModel().isSelectedMana()) {
                    getModel().getHero().getStatus().getAtributos_real().add_mana(5);
                }
                if (getModel().isSelectedStr()) {
                    getModel().getHero().getStatus().getAtributos_real().add_forca(3);
                }
                if (getModel().isSelectedIntel()) {
                    getModel().getHero().getStatus().getAtributos_real().add_inteligencia(3);
                }
                if (getModel().isSelectedSpeed()) {
                    getModel().getHero().getStatus().getAtributos_real().add_velocidade(3);
                }

                game.previousState();
                game.addState(new ReceiveState(new Receive(1,getModel().getHero().getHero_inventario(),getModel().getHero(), getModel().getDinheiro(), getModel().getXp(),getModel().getItems(), getModel().getLevel_up())));
        }


    }
    }

