package org.game.viewer.game.elementsViewer;
import org.game.gui.GUI;
import org.game.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero>{
    @Override
    public void draw(Hero hero, GUI gui){
        gui.drawHero(hero.getPosition());
    }
}
