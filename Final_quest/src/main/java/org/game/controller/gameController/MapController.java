package org.game.controller.gameController;

import org.game.Game;
import org.game.controller.gameController.elementController.DialogueController;
import org.game.controller.gameController.elementController.HeroController;
import org.game.gui.GUI;
import org.game.model.menu.Shop;
import org.game.rpg_rules.dialogue.Dialogue;
import org.game.model.game.map.Map;
import org.game.model.menu.Menu;
import org.game.states.inventory.ShopState;
import org.game.states.mainMenu.MenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class MapController extends GameController{
    private final HeroController heroController;
    private final DialogueController dialogueController;
    public MapController(Map map) {
        super(map);
        this.heroController = new HeroController(map);
        this.dialogueController = new DialogueController(map);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(getModel().getOptions() == 2) {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedNo()){
                        getModel().setOptions(0);
                    }

                    if (getModel().isSelectedYes()) {
                        getModel().setOptions(0);
                        game.addState(new ShopState(new Shop(game.getHero())));
                    }

            }
        }

        else if(getModel().getOptions() == 1){
            switch (action) {
                case UP:
                    System.out.println("Para cima");
                case SELECT:
                    if(getModel().getNarrator().getFim()){
                        getModel().getNarrator().setFim(false);
                        getModel().setOptions(0);
                        getModel().getNarrator().next_dialogo();
                        getModel().setNarrator(new Dialogue(""));
                    }
                    else{
                        getModel().getNarrator().next_dialogo();
                    }

                    System.out.println("Selecionou opeção OK");
            }
        }

        if (action == GUI.ACTION.QUIT){
            System.exit(0);
        }
        else if(action==GUI.ACTION.ESC)
        {
            game.addState(new MenuState(new Menu()));
        }

        else if(getModel().getOptions() == 0){
                heroController.step(game, action, time);
                dialogueController.step(game, action, time);

        }

    }
}

