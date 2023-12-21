package org.game;
import org.game.gui.LanternaGUI;

import org.game.model.battle.battleElements.Hero;
import org.game.model.game.map.MapLoader;
import org.game.model.menu.Menu;
import org.game.music.Music;
import org.game.music.MusicObserver;
import org.game.music.MusicSubject;
import org.game.states.inventory.InteractionState;
import org.game.states.mainMenu.MenuState;
import org.game.states.State;
import org.game.states.map.MapState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.game.model.battle.battleElements.Hero.getInstance;


public class Game implements MusicSubject {
    private final LanternaGUI gui;
    private static State state;
    private static List<Music> musicObservers = new ArrayList<>();
    private static MusicObserver muc;
    private static Stack<State> statestack = new Stack<State>();
    private static Game game;
    private static boolean inside_castle=false;
    private Music music = new Music(game);
    private static int floor = 0;
    private List<Boolean> chests_open = new ArrayList<>();
    private static Hero hero;
    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(200, 200);
        new Music(game).MusicPlay(0);
        this.state = new MenuState(new Menu());
        statestack.push(null);
        statestack.push(state);
        hero = getInstance();
        inside_castle = false;
        addObserver(music);
        add_chests();
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        Game.hero = hero;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        game = new Game();
        game.start();
    }



    public void setState(State State) throws URISyntaxException {
        this.state = state;
        notifyObservers();
    }

    private void start() throws IOException, URISyntaxException {
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

    public void SetInteraction(InteractionState state) {
        this.state = state;
    }

    public  void addState(State state) throws URISyntaxException {
        statestack.push(state);
        notifyObservers();
    }

    public  State getState() {
        return statestack.peek();
    }

    public void previousState() throws URISyntaxException {
        statestack.pop();
        notifyObservers();
    }

    public  void cleanStack() throws IOException, URISyntaxException {
        while (!statestack.empty()) {
            statestack.pop();
        }

        close_chests();
        addState(new MapState(new MapLoader("centralVillage", hero).createMap(hero),0));
        double a = getHero().getHero_inventario().getDinheiro();
        double b = (a * 0.1);
        getHero().getHero_inventario().remove_dinheiro((int) b);
    }

    public void add_chests()
    {
        for(int i = 0; i <5; i++)
        {
            chests_open.add(false);
        }
    }
    public void close_chests()
    {
        for(int i = 0; i<5; i++)
        {
            chests_open.set(i,false);
        }
    }
    public void close_one(int fl)
    {
        chests_open.set(fl, true);
    }

    public List<Boolean> list_of_chests()
    {
        return chests_open;
    }


    public void add_chest(boolean a)
    {
        chests_open.add(a);
    }
    public static Stack<State> getStateStack() {
        return statestack;
    }

    public LanternaGUI getGui() {
        return gui;
    }

    @Override
    public void addObserver(Music observer) {
        musicObservers.add(observer);
    }

    @Override
    public void removeObserver(MusicObserver observer) {
        musicObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws URISyntaxException {
        for (MusicObserver observer : musicObservers) {
            observer.update(game);
        }
    }

    @Override
    public void notifyBuy(int toggle) throws URISyntaxException {
        for(MusicObserver observer: musicObservers)
        {
            observer.updateBuy(game, toggle);
        }
    }

    public static boolean get_inside_castle()
{
    return  inside_castle;
}

    public void setinside_castle(boolean inside_castle) {
        this.inside_castle = inside_castle;
    }


    public  void addfloor(){
      this.floor++;

    }
    public void previousfloor()  {
        this.floor--;
    }

    public  int getFloor() {
        return floor;
    }

    public static void setFloor() {
        Game.floor = 0;
    }
}
