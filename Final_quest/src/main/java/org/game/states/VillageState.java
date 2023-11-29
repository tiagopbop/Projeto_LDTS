package org.game.states;

import org.game.controller.Controller;
import org.game.viewer.Viewer;

import javax.swing.text.View;

public class VillageState extends State<Village> {
    public VillageState(Village Vila){
        super(Village);
    }

    @Override
    protected Viewer<Village> getViewer(){
        return new VilaViewer(getModel());
    }

    @Override
    protected Controller<Village> getController(){
        return new VillageController(getModel());
    }

}
