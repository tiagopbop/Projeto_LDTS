package org.game.controller.gameController;

import com.googlecode.lanterna.screen.Screen;
import org.game.Game;
import org.game.gui.GUI;
import org.game.model.Position;
import org.game.model.dialogue.Dialogue;
import org.game.model.dialogue.HeroMovementDialogue;
import org.game.model.game.battle.Battle;
import org.game.model.game.battle.Party;
import org.game.model.game.elements.Hero;
import org.game.model.game.battle.BattleMenu;
import org.game.model.game.map.Map;

import org.game.model.menu.InteractionMenu;
import org.game.model.menu.Inventory;
import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.states.BattleState;
import org.game.states.InteractionState;
import org.game.states.InventoryState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DialogueController extends GameController  {

    public DialogueController(Map map) {
        super(map);
    }
    private GUI.ACTION pre_act;

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.UP) {
            pre_act = GUI.ACTION.UP;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());

        }
        if (action == GUI.ACTION.RIGHT){
            pre_act = GUI.ACTION.RIGHT;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());

        }
        if (action == GUI.ACTION.DOWN){
            pre_act = GUI.ACTION.DOWN;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());
        }
        if (action == GUI.ACTION.LEFT){
            pre_act = GUI.ACTION.LEFT;
            getModel().setNarrator(new HeroMovementDialogue().CreateDialogue());
        }



        if(action == GUI.ACTION.INVENTORY)
        {
            Inventory inventory = new Inventory(getModel().getHero().getHero_inventario(), getModel().getHero());
            InventoryState state = new InventoryState(inventory);
            game.addState(state);
        }
        if(action == GUI.ACTION.INTERACT)
        {
            Dialogue t = new Dialogue();
            if (pre_act == GUI.ACTION.UP) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getUp());
            }
            if (pre_act == GUI.ACTION.LEFT) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getLeft());
            }
            if (pre_act == GUI.ACTION.DOWN) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getDown());
            }
            if (pre_act == GUI.ACTION.RIGHT) {
                t = getModel().isInteractable(getModel().getHero().getHeroElement().getPosition().getRight());
            }
             if(t.getMen()) {
                 getModel().setNarrator(new Dialogue(t));
                getModel().setOptions(true);

             }
            else {
                getModel().setNarrator(new Dialogue(t));
            }
    }

}



}
