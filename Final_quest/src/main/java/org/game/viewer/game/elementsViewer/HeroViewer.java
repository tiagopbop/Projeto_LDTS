package org.game.viewer.game.elementsViewer;
import org.game.gui.GUI;
import org.game.model.game.elements.Hero;
import org.game.model.game.elements.Hero_Element;

public class HeroViewer implements ElementViewer<Hero_Element>{
    @Override
    public void draw(Hero_Element hero_element, GUI gui){
        gui.drawHero(hero_element.getPosition());
    }
}
