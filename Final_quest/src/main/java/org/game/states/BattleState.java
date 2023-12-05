package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.BattleMenuController;
import org.game.model.menu.BattleMenu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.BattleViewer;

public class BattleState extends State<BattleMenu>{
    public BattleState(BattleMenu model) {
        super(model);
    }

    @Override
    protected Viewer<BattleMenu> getViewer() {
        return new BattleViewer(getModel());
    }

    @Override
    protected Controller<BattleMenu> getController() {
        return new BattleMenuController(getModel());
    }
}

