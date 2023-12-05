package org.game.controller.gameController;

import org.game.gui.GUI;
import org.game.model.game.map.Village;
import org.game.model.Position;
import org.game.Game;

public class HeroController extends GameController{
    public HeroController(Village village) {
        super(village);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getHeroElement().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getHeroElement().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getHeroElement().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getHeroElement().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().getHeroElement().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {

            moveHeroUp();
        }
        if (action == GUI.ACTION.RIGHT){
            moveHeroRight();
        }
        if (action == GUI.ACTION.DOWN){
            moveHeroDown();
        }
        if (action == GUI.ACTION.LEFT){
            moveHeroLeft();
        }


    }


}
