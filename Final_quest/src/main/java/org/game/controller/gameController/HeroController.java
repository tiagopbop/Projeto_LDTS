package org.game.controller.gameController;

import org.game.gui.GUI;
import org.game.model.game.battle.Battle;
import org.game.model.game.battle.BattleMenu;
import org.game.model.game.battle.Party;
import org.game.model.game.elements.Hero;
import org.game.model.game.map.Map;
import org.game.model.Position;
import org.game.Game;
import org.game.model.game.map.MapLoader;
import org.game.states.BattleState;
import org.game.states.MapState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(!getModel().getOptions()) {

        if (action == GUI.ACTION.UP) {

                moveHeroUp(game);
            }
            if (action == GUI.ACTION.RIGHT) {
                moveHeroRight(game);
            }
            if (action == GUI.ACTION.DOWN) {
                moveHeroDown(game);
            }
            if (action == GUI.ACTION.LEFT) {
                moveHeroLeft(game);
            }
            if(action==GUI.ACTION.KOMBAT)
            {
                List<Hero> party = new ArrayList<>();
                party.add(getModel().getHero());
                Battle battle = new Battle(new Party(party),1);
                BattleState state = new BattleState(new BattleMenu(getModel().getHero(),battle), battle);
                game.addState(state);
            }


        }
    }


}
