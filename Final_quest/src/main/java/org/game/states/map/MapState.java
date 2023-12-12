package org.game.states.map;

import org.game.controller.Controller;
import org.game.states.State;
import org.game.viewer.Viewer;
import org.game.model.game.map.Map;
import org.game.viewer.map.MapViewer;
import org.game.controller.gameController.MapController;

public class MapState extends State<Map> {
    private java.util.Map.Entry<Integer,Integer> obs;
    public MapState(Map map, int plate){
        super(map);

        obs = java.util.Map.entry(1,plate);

    }


    @Override
    protected Viewer<Map> getViewer(){
        return new MapViewer(getModel());
    }

    @Override
    protected Controller<Map> getController(){
        return new MapController(getModel());
    }

    @Override
    public java.util.Map.Entry<Integer, Integer> getObs() {
        return obs;
    }

    public void setObs(java.util.Map.Entry<Integer, Integer> obs) {
        this.obs = obs;
    }


}
