package org.game.model.game.battle;

import org.game.model.Position;
import org.game.model.game.elements.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsumableMenu {

    private final List<String> entries;
    private int currentEntryX = 0;
    private int currentEntryY = 0;
    private Position currentEntry;

    private Hero hero;


    public ConsumableMenu(Hero hero) {
        entries = new ArrayList<>();
        for(int i =0; i < hero.getStatus().getAtaques_fisicos().size(); i++)
        {

        }
        this.currentEntry = new Position(0,0);
        this.hero  = hero;
    }

    public void setCurrentEntry(Position currentEntry) {
        this.currentEntry = currentEntry;
    }

    public void nextEntryUp() {
        currentEntryY--;
        if (currentEntryY < 0)
            currentEntryY = 1;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }

    public void nextEntryDown() {
        currentEntryY++;
        if (currentEntryY > 1)
            currentEntryY = 0;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }
    public void nextEntryLeft() {
        currentEntryX--;
        if (currentEntryX < 0)
            currentEntryX = 1;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }

    public void nextEntryRight()
    {
        currentEntryX++;
        if(currentEntryX > 1)
        {
            currentEntryX = 0;
        }
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(Position position) {
        if(position.getX() == currentEntryX && position.getY() == currentEntryY)
        {return true;}
        return  false;
    }

    public boolean isSelectedMelee() {
        return isSelected(new Position(0,0));}


    public boolean isSelectedMagic() {
        return isSelected(new Position(1,0));
    }

    public boolean isSelectedRun() {
        return isSelected(new Position(1,1));
    }

    public boolean isSelectedConsume() {
        return isSelected(new Position(0,1));
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }
}
