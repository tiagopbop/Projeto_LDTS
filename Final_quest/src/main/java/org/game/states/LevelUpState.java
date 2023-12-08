package org.game.states;

import org.game.controller.Controller;
import org.game.controller.menuController.LevelUpController;
import org.game.controller.menuController.MenuController;
import org.game.model.menu.LevelUp;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.LevelUpViewer;
import org.game.viewer.menu.MenuViewer;

public class LevelUpState extends State<LevelUp> {
    public LevelUpState(LevelUp model) {
        super(model);
    }

    @Override
    protected Viewer<LevelUp> getViewer() {
        return new LevelUpViewer(getModel());
    }

    @Override
    protected Controller<LevelUp> getController() {
        return new LevelUpController(getModel());
    }
}
