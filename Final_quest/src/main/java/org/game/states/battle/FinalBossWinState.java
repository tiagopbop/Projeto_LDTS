package org.game.states.battle;

import org.game.controller.Controller;
import org.game.controller.battleController.FinalBossWinController;
import org.game.controller.battleController.LevelUpController;
import org.game.model.battle.menus.FinalBossWin;
import org.game.model.battle.menus.LevelUp;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.viewer.battle.FinalBossWinViewer;
import org.game.viewer.battle.LevelUpViewer;

import java.util.Map;

public class FinalBossWinState extends State<FinalBossWin> {
    private Map.Entry<Integer,Integer> obs = Map.entry(8,0);
    public FinalBossWinState(FinalBossWin model) {
        super(model);
    }

    @Override
    protected Viewer<FinalBossWin> getViewer() {
        return new FinalBossWinViewer(getModel());
    }

    @Override
    protected Controller<FinalBossWin> getController() {
        return new FinalBossWinController(getModel());
    }

    @Override
    public Map.Entry<Integer, Integer> getObs() {
        return obs;
    }
}
