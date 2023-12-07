package org.game.states;

import org.game.controller.Controller;
import org.game.viewer.Viewer;
import org.game.model.game.map.Map;
import org.game.viewer.MapViewer;
import org.game.controller.gameController.MapController;

public class MapState extends State<Map> {
    public MapState(Map map){
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer(){
        return new MapViewer(getModel());
    }

    @Override
    protected Controller<Map> getController(){
        return new MapController(getModel());
    }

}
