package org.game.states.battle;

import org.game.controller.Controller;
import org.game.model.battle.battleElements.Battle;
import org.game.controller.battleController.BattleMenuController;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.menus.BattleMenu;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.battle.BattleViewer;

import java.io.IOException;
import java.util.Map;

public class BattleState extends State<BattleMenu> {
    private Map.Entry<Integer,Integer> obs = Map.entry(5,0);
    private Hero hero;
    private Battle battle;
    public BattleState(BattleMenu model, Battle battle) throws IOException {
        super(model);
        this.hero = model.getHero();
        this.battle = battle;
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }

    public Battle getBattle() {
        return battle;
    }

    @Override
    protected Viewer<BattleMenu> getViewer() {
        return new BattleViewer(getModel());
    }

    @Override
    protected Controller<BattleMenu> getController() {
        return new BattleMenuController(getModel());
    }

    public Hero getHero() {
        return hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
}

