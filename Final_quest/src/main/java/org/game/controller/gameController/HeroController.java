package org.game.controller.gameController;

import org.game.gui.GUI;
import org.game.model.game.map.Map;
import org.game.model.Position;
import org.game.Game;
import org.game.model.game.map.MapLoader;
import org.game.states.MapState;

import java.io.IOException;

import static org.game.Game.getStateStack;

public class HeroController extends GameController{
    public HeroController(Map map) {
        super(map);
    }

    public void moveHeroLeft(Game game) throws IOException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getLeft(), game);
    }

    public void moveHeroRight(Game game) throws IOException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getRight(), game);
    }

    public void moveHeroUp(Game game) throws IOException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getUp(), game);
    }

    public void moveHeroDown(Game game) throws IOException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getDown(), game);
    }

    private void moveHero(Position position, Game game) throws IOException {
        if (getModel().isEmpty(position) || position.getX() == 61 || position.getX() == -1) {

            switch (position.getX()) {
                case 61:
                    MapState state = (new MapState(new MapLoader("castleEntrance").createMap(getModel().getHero())));
                    game.addState(state);

                    position = new Position(0, position.getY());

                    break;

                case -1:
                    game.previousState();

                    position = new Position(60, position.getY());

                    break;

            }

            getModel().getHero().getHeroElement().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if(!getModel().getOptions()) {
            if (action == GUI.ACTION.UP) {
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) {

                moveHeroUp();
            }
            if (action == GUI.ACTION.RIGHT) {
                moveHeroRight();
            }
            if (action == GUI.ACTION.DOWN) {
                moveHeroDown();
            }
            if (action == GUI.ACTION.LEFT) {
                moveHeroLeft();
            }
            moveHeroUp(game);
        }
        if (action == GUI.ACTION.RIGHT){
            moveHeroRight(game);
        }
        if (action == GUI.ACTION.DOWN){
            moveHeroDown(game);
        }
        if (action == GUI.ACTION.LEFT){
            moveHeroLeft(game);
        }

        }
    }


}
