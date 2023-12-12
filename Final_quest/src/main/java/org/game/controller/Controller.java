package org.game.controller;

import org.game.Game;
import org.game.gui.GUI;
import org.game.model.game.map.Map;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException;
}
