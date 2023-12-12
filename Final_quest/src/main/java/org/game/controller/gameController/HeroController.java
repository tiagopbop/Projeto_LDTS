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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.game.Game.getStateStack;

public class HeroController extends GameController{
    public HeroController(Map map) {
        super(map);
    }

    public void moveHeroLeft(Game game) throws IOException, URISyntaxException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getLeft(), game);
    }

    public void moveHeroRight(Game game) throws IOException, URISyntaxException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getRight(), game);
    }

    public void moveHeroUp(Game game) throws IOException, URISyntaxException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getUp(), game);
    }

    public void moveHeroDown(Game game) throws IOException, URISyntaxException {
        moveHero(getModel().getHero().getHeroElement().getPosition().getDown(), game);
    }

    private void moveHero(Position position, Game game) throws IOException, URISyntaxException {
        if (getModel().isEmpty(position) || position.getX() == 61 || position.getX() == -1) {

            switch (position.getX()) {
                case 61:
                    MapState state = (new MapState(new MapLoader("castleEntrance", game.getHero()).createMap(getModel().getHero()),1));
                    game.addState(state);
                    getModel().getHero().set_in_map(true);
                    position = new Position(0, position.getY());

                    break;

                case -1:
                    game.previousState();
                    getModel().getHero().set_in_map(false);
                    position = new Position(60, position.getY());

                    break;

            }

            getModel().getHero().getHeroElement().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(getModel().getOptions() == 0) {
            boolean cast = game.get_inside_castle();
            if (action == GUI.ACTION.UP) {
                if(cast)
                    enter_kombat(game);
                moveHeroUp(game);
            }
            if (action == GUI.ACTION.RIGHT) {
                if(cast)
                    enter_kombat(game);
                moveHeroRight(game);
            }
            if (action == GUI.ACTION.DOWN) {
                if(cast)
                    enter_kombat(game);
                moveHeroDown(game);
            }
            if (action == GUI.ACTION.LEFT) {
                if(cast)
                    enter_kombat(game);
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

    public void enter_kombat(Game game) throws IOException, URISyntaxException {

            Random rand = new Random();
            int n = rand.nextInt(30);
            if(n==2)
            {
                List<Hero> party = new ArrayList<>();
                party.add(getModel().getHero());
                Battle battle = null;
                switch (game.getFloor())
                {
                    case 1:

                        battle = new Battle(new Party(party),1);

                        break;
                    case 2:

                        battle = new Battle(new Party(party),2);

                        break;
                }
                BattleState state = new BattleState(new BattleMenu(getModel().getHero(),battle), battle);
                game.addState(state);

        }
    }
}
