package org.game.model.menu;

import org.game.model.Position;
import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private final List<String> entries;
    private int currentEntryX = 0;
    private int currentEntryY = 0;
    private Position currentEntry;

    private Hero hero;

    public Shop(Hero hero) {
        this.entries = Arrays.asList("Pocao Pequena Cura", "Pocao Media Cura", "Pocao Grande Cura", "Pocao Pequena Mana", "Pocao Media Mana", "Pocao Grande Mana","Pocao Pequena Geral",
                "Pocao Media Geral", "Pocao Grande Geral", "Pocao Velocidade", "Pocao Forca", "Pocao Inteligencia", "Essencio de Parelizia", "Essencio de Fraqueza",
        "Essencio de Demencia", "Bomba Pequena");
        this.currentEntry = new Position(0,0);
        this.hero  = hero;
    }

    public void setCurrentEntry(Position currentEntry) {
        this.currentEntry = currentEntry;
    }


    public void nextEntryUp() {
        currentEntryY--;
        if (currentEntryY < 0) {
            currentEntryY = 7;
        }
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }

    public void nextEntryDown() {
        currentEntryY++;
        if (currentEntryY > 7)
            currentEntryY = 0;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }
    public void nextEntryLeft() {
        currentEntryX--;
        if (currentEntryX < 0)
            currentEntryX = 1;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }

    public void nextEntryRight() {
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


    public Position getCurrentEntry() {
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
        return currentEntry;
    }

    public int getCurrent()
    {
        return currentEntryX*10 + currentEntryY;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }
}
