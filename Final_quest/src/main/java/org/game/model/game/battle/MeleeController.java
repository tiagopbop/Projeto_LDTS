package org.game.model.game.battle;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.game.elements.Hero;
import org.game.states.BattleState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeleeController extends Controller<MeleeMenu> {

    public MeleeController(MeleeMenu model) {
        super(model);
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

                if (getModel().isSelectedMelee())
                {
                    List<Hero> party = new ArrayList<>();
                    party.add(getModel().getHero());
                    Battle battle = new Battle(new Party(party),1);
                    BattleState state = new BattleState(new MeleeMenu(getModel().getHero(),battle), battle);
                    game.addState(state);
                }
                if (getModel().isSelectedMagic()) {
                    game.previousState();
                }
                if (getModel().isSelectedConsume()){
                    game.previousState();
                }
                if (getModel().isSelectedRun()) {
                    game.previousState();
                }
        }

    }}

