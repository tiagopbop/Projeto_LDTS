package org.game.states;


import org.game.controller.Controller;
import org.game.controller.menuController.MenuController;
import org.game.model.menu.Menu;
import org.game.viewer.Viewer;
import org.game.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new  MenuController(getModel());
    }
}
