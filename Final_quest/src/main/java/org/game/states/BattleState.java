package org.game.states;

import org.game.controller.Controller;
import org.game.model.game.battle.Battle;
import org.game.model.game.battle.BattleMenuController;
import org.game.model.game.battle.Party;
import org.game.model.game.elements.Hero;
import org.game.model.game.battle.BattleMenu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.BattleViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleState extends State<BattleMenu>{
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

