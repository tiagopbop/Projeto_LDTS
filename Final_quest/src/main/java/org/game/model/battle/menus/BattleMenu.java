package org.game.model.battle.menus;

import org.game.model.Position;
import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;
import org.game.model.battle.battleElements.battleCommands.Start_Turn;
import org.game.rpg_elements.itens.Item;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BattleMenu {
        private final List<String> entries;
        private int currentEntryX = 0;
        private int currentEntryY = 0;
        private Position currentEntry;

        private Hero hero;
        private Battle battle;

    public BattleMenu(Hero hero, Battle battle) {
        this.entries = Arrays.asList("Melee", "Magic", "Consumables", "Run");
        this.currentEntry = new Position(0,0);
        this.hero  = hero;
        this.battle = battle;
    }

    public void setCurrentEntry(Position currentEntry) {
        this.currentEntry = currentEntry;
    }

    public Battle getBattle() {
        return battle;
    }

    public void nextEntryUp() {
            currentEntryY--;
            if (currentEntryY < 0) {
                currentEntryY = 1;
            }
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

    public int start_turn(String player_choice,int int_choice) throws IOException {
        Start_Turn startTurn = new Start_Turn(battle);

        startTurn.setPlayer_choice(player_choice);
        startTurn.setInt_list(int_choice);

        startTurn.execute();

        return startTurn.getResult();

    }

    public int start_turn(String player_choice,Item item_choice) throws IOException {
        Start_Turn startTurn = new Start_Turn(battle);

        startTurn.setPlayer_choice(player_choice);
        startTurn.setPlayer_item(item_choice);

        startTurn.execute();

        return startTurn.getResult();

    }

}