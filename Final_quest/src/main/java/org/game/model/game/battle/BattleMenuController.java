package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.map.MapLoader;
import org.game.model.menu.Menu;
import org.game.states.MapState;
import org.game.model.game.elements.Hero;
import org.game.states.BattleStateMelee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleMenuController extends Controller<BattleMenu> {
    public BattleMenuController(BattleMenu bm) {
        super(bm);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
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
                    BattleStateMelee state = new BattleStateMelee(new MeleeMenu(getModel().getHero(),battle,0), battle,0);
                    game.addState(state);
                }
                 if (getModel().isSelectedMagic()) {
                     BattleStateMelee state = new BattleStateMelee(new MeleeMenu(getModel().getHero(),battle,1), battle,1);
                     game.addState(state);
                }
                 if (getModel().isSelectedConsume()){
                    game.previousState();
                }
                 if (getModel().isSelectedRun()) {
                    game.previousState();
                }
        }

    }}

