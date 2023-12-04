package org.game;
import org.game.gui.LanternaGUI;

import org.game.model.menu.Menu;
import org.game.music.Music;
import org.game.states.MenuState;
import org.game.states.State;
import org.game.states.VillageState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Game {
    private final LanternaGUI gui;
    private State state;
    private Music music;

    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.gui = new LanternaGUI(200, 200);
        new Music().MusicPlay();
        this.state = new MenuState(new Menu());

    }
    public  static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();

    }

    public void setState(State State){
        this.state = state;
    }

    private  void start() throws IOException{
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {

            }
        }
        gui.close();
    }

    public void SetState(VillageState  state)
    {
        this.state = state;
    }

}
