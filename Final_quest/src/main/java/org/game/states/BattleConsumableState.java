package org.game.states;

import org.game.controller.Controller;
import org.game.model.game.battle.*;
import org.game.model.game.elements.Hero;
import org.game.viewer.Viewer;
import org.game.viewer.menu.BattleConsumableViewer;
import org.game.viewer.menu.MeleeViewer;

import java.io.IOException;
import java.util.Map;

public class BattleConsumableState extends State<BattleConsumableMenu>{
    private Map.Entry<Integer,Integer> obs = Map.entry(5,0);
    private Hero hero;
    private Battle battle;
    public BattleConsumableState(BattleConsumableMenu model, Battle battle) throws IOException {
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
    protected Viewer<BattleConsumableMenu> getViewer() {
        return new BattleConsumableViewer(getModel());
    }

    @Override
    protected Controller<BattleConsumableMenu> getController() {
        return new BattleConsumableController(getModel());
    }

    public Hero getHero() {
        return hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
