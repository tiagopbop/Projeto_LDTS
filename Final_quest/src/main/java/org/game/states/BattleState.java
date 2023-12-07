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
import java.util.List;

public class BattleState extends State<BattleMenu>{
    private Hero hero;
    private Battle battle;
    public BattleState(BattleMenu model, Battle battle) throws IOException {
        super(model);
        this.hero = model.getHero();
        this.battle = battle;
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

