package org.game.states;

import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.viewer.Viewer;
import org.game.Game;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model){

        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();

    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel(){
        return model;
    }

    public void step (Game game, GUI gui) throws IOException{
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action);
        viewer.draw(gui);
    }

}

