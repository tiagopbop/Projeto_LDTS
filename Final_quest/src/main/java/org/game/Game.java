package org.game;
import org.game.gui.LanternaGUI;

import org.game.model.game.elements.Hero;
import org.game.model.menu.Menu;
import org.game.music.Music;
import org.game.states.InteractionState;
import org.game.states.MenuState;
import org.game.states.State;
import org.game.states.MapState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Stack;


public class Game {
    private final LanternaGUI gui;
    private static State state;

    private static Stack<State> statestack = new Stack<State>();

    private Music music;

    private Hero hero;

    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.gui = new LanternaGUI(200, 200);
        new Music().MusicPlay();
        this.state = new MenuState(new Menu());
        statestack.push(null);
        statestack.push(state);
        hero = new Hero();

    }
    public Hero getHero() { return hero; }
    public  static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();

    }

    public void setState(State State){
        this.state = state;
    }

    private  void start() throws IOException{
        int FPS = 60;
        int frameTime = 1000 / FPS;
        System.out.println("comecei");

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

    public void SetInteraction(InteractionState state) {this.state = state;}

    public static void addState(State state){
        statestack.push(state);
    }
    public static void previousState() {
        statestack.pop();
    }
    public static Stack<State> getStateStack(){
        return statestack;
    }

    public LanternaGUI getGui() {
        return gui;
    }
}
