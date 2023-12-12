package org.game.states.battle;

import org.game.controller.Controller;
import org.game.controller.battleController.BattleConsumableController;
import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.menus.BattleConsumableMenu;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.battle.BattleConsumableViewer;

import java.io.IOException;
import java.util.Map;

public class BattleConsumableState extends State<BattleConsumableMenu> {
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
