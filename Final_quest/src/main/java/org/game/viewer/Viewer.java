package org.game.viewer;

import org.game.gui.GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui) throws  IOException;
}
