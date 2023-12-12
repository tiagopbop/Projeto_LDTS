package org.game.states;

import org.game.controller.Controller;
import org.game.model.game.battle.*;
import org.game.model.game.elements.Hero;
import org.game.viewer.Viewer;
import org.game.viewer.menu.BattleViewer;
import org.game.viewer.menu.MeleeViewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BattleStateMelee extends State<MeleeMenu> {
    private Map.Entry<Integer,Integer> obs = Map.entry(5,0);
    private Hero hero;
    private Battle battle;
    private int selection;
    public BattleStateMelee(MeleeMenu model, Battle battle, int selection) throws IOException {
        super(model);
        this.selection = selection;
        this.hero = model.getHero();
        this.battle = battle;
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }

    public int getSelection() {
        return selection;
    }

    public Battle getBattle() {
        return battle;
    }

    @Override
    protected Viewer<MeleeMenu> getViewer() {
        return new MeleeViewer(getModel());
    }

    @Override
    protected Controller<MeleeMenu> getController() {
        return new MeleeController(getModel());
    }

    public Hero getHero() {
        return hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
