package org.game.states;

import org.game.controller.Controller;
import org.game.viewer.Viewer;
import org.game.model.game.map.Village;
import org.game.viewer.VillageViewer;
import org.game.controller.gameController.VillageController;

public class VillageState extends State<Village> {
    public VillageState(Village village){
        super(village);
    }

    @Override
    protected Viewer<Village> getViewer(){
        return new VillageViewer(getModel());
    }

    @Override
    protected Controller<Village> getController(){
        return new VillageController(getModel());
    }

}
