package org.game;
import org.game.gui.LanternaGUI;

import org.game.model.menu.Menu;
import org.game.music.Music;
import org.game.states.InteractionState;
import org.game.states.MenuState;
import org.game.states.State;
import org.game.states.VillageState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Stack;


public class Game {
    private final LanternaGUI gui;
    private State state;

    private Stack<State> statestack = new Stack<State>();

    private Music music;

    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.gui = new LanternaGUI(200, 200);
        new Music().MusicPlay();
        this.state = new MenuState(new Menu());
        statestack.push(null);
        statestack.push(state);


    }
    public  static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        System.out.println("TOMA MEU");
        new Game().start();

    }

    public void setState(State State){
        this.state = state;
    }

    private  void start() throws IOException{
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (statestack.peek() != null) {
            long startTime = System.currentTimeMillis();

            statestack.peek().step(this, gui, startTime);

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

    public void SetInteraction(InteractionState state) {this.state = state;}

    public void addState(State state){
        statestack.push(state);
    }
    public void previousState() {
        statestack.pop();
    }
    public Stack<State> getStateStack(){
        return statestack;
    }

    public LanternaGUI getGui() {
        return gui;
    }
}
