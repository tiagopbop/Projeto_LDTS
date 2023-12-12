package org.game.states;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.viewer.Viewer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyPair;
import java.util.Map;
import java.util.Map.Entry;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    private Map.Entry<Integer,Integer> obs ;

    public State(T model){

        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();

    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public Map.Entry<Integer, Integer> getObs()
    {
        return obs;
    }

    public T getModel(){
        return model;
    }

    public void step (Game game, GUI gui, long time) throws IOException, URISyntaxException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }


}

