package org.game.controller.battleController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.menus.BattleConsumableMenu;
import org.game.model.battle.menus.BattleMenu;
import org.game.model.battle.menus.MeleeMenu;
import org.game.states.battle.BattleConsumableState;
import org.game.model.battle.battleElements.Hero;
import org.game.states.battle.BattleStateMelee;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BattleMenuController extends Controller<BattleMenu> {
    public BattleMenuController(BattleMenu bm) {
        super(bm);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().nextEntryUp();
                break;
            case DOWN:
                getModel().nextEntryDown();
                break;
            case LEFT:
                getModel().nextEntryLeft();
                break;
            case RIGHT:
                getModel().nextEntryRight();
                break;

            case SELECT:
                List<Hero> party = new ArrayList<>();
                party.add(getModel().getHero());
                Battle battle = getModel().getBattle();
                if (getModel().isSelectedMelee())
                {
                    BattleStateMelee state = new BattleStateMelee(new MeleeMenu(getModel().getHero(),battle, game.getFloor(), 0), battle,0);
                    game.addState(state);
                }
                 if (getModel().isSelectedMagic()) {
                     BattleStateMelee state = new BattleStateMelee(new MeleeMenu(getModel().getHero(),battle, game.getFloor(), 1), battle,1);
                     game.addState(state);
                }
                 if (getModel().isSelectedConsume()){
                    BattleConsumableState state = new BattleConsumableState(new BattleConsumableMenu(getModel().getHero(),battle, game.getFloor()), battle);
                    game.addState(state);
                }
                 if (getModel().isSelectedRun() && game.getFloor()!=3) {
                    game.previousState();
                }
        }

    }}

