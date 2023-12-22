package org.game.model.battle.menus;

import org.game.model.Position;
import org.game.model.battle.battleElements.Battle;
import org.game.model.battle.battleElements.Hero;

import java.util.ArrayList;
import java.util.List;

public class MeleeMenu extends BattleMenu {
    private final List<String> entries;
    private int currentEntryX = 0;
    private int currentEntryY = 0;
    private Position currentEntry;
    private  int page = 1;

    private  int selection;

    private Hero hero;
    private Battle battle;

    private int abilities;

    public MeleeMenu(Hero hero, Battle battle,int floor, int selection) {
        super(hero,battle,floor);
        this.selection = selection;
        entries = new ArrayList<>();
        if(selection==0) {
            for (int i = 0; i < hero.getStatus().getAtaques_fisicos().size(); i++) {
                this.entries.add(hero.getStatus().getAtaques_fisicos().get(i).getNome());

            }
        }
        else
        {
            for (int i = 0; i < hero.getStatus().getAtaques_magicos().size(); i++) {
                this.entries.add(hero.getStatus().getAtaques_magicos().get(i).getNome());

            }
        }
        this.currentEntryY = 0;
        this.currentEntryX=0;
        this.hero  = hero;
        this.page = 1;

        if(selection == 0)
        {
            this.abilities=getHero().getStatus().getAtaques_fisicos().size();
        }
        else
        {
            this.abilities=getHero().getStatus().getAtaques_magicos().size();
        }
    }

    @Override
    public void setCurrentEntry(Position currentEntry) {
        this.currentEntry = currentEntry;
        if(currentEntryY>1 && abilities >4) page = 2;
        else page = 1;
    }

    @Override
    public void nextEntryUp() {
        if(abilities==1 || abilities==2)
        {return;}

        if(currentEntryY == 0 && abilities ==5)
        {
            currentEntryY = 2;
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }
        if(currentEntryY == 0 && abilities ==7)
        {
            currentEntryY = 3;
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }
        currentEntryY--;
        if (currentEntryY < 0 && abilities >=7) {
            page = 2;
            currentEntryY = 3;
        }
        if(currentEntryY<0 && abilities <=4) {currentEntryY=1;
            page = 1;}

        if(currentEntryY < 0 && abilities >4 && abilities <7)
        {
            page = 2;
            currentEntryY =2;
        }

        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }
    @Override
    public void nextEntryDown() {
        int t = hero.getStatus().getAtaques_fisicos().size();
        if(t==1 || t==2)
        {return;}

        if(currentEntryY == 1 && currentEntryX ==1 && abilities==5)
        {
            currentEntryY = 2;
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }

        if(currentEntryY == 2 && currentEntryX ==1 && abilities ==7)
        {
            currentEntryY = 3;
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }
        if(currentEntryY == 2  && (abilities ==6 ||abilities== 5))
        {
            currentEntryY = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }
        currentEntryY++;
        if (currentEntryY > 3) {
            currentEntryY = 0;
            page = 1;
        }
        if(currentEntryY >1 &&abilities > 4) page = 2;
        if(currentEntryY>1 && abilities <=4) {currentEntryY=0;
        page = 1;}
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }



    @Override
    public void nextEntryLeft() {
        currentEntryX--;
        if(currentEntryX<0 && ((currentEntryY == 0 && abilities==1)   ||
                (currentEntryY==1 && abilities==3) ||
                (currentEntryY==2 && abilities==5) ||
                (currentEntryY==3 && abilities == 7)
        )) {
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }


        if (currentEntryX < 0)
            currentEntryX = 1;
        setCurrentEntry(new Position(currentEntryX,currentEntryY));
    }
    @Override
    public void nextEntryRight()
    {
        currentEntryX++;
        if(currentEntryX==1 && ((currentEntryY == 0 && abilities==1)   ||
                (currentEntryY==1 && abilities==3) ||
                (currentEntryY==2 && abilities==5) ||
                (currentEntryY==3 && abilities == 7)
        )) {
            currentEntryX = 0;
            setCurrentEntry(new Position(currentEntryX,currentEntryY));
            return;
        }
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

    public boolean isSelected1() {
        return isSelected(new Position(0,0));}


    public boolean isSelected2() {
        return isSelected(new Position(1,0));
    }

    public boolean isSelected3() {
        return isSelected(new Position(0,1));
    }

    public boolean isSelected4() {
        return isSelected(new Position(1,1));
    }
    public boolean isSelected5() {
        return isSelected(new Position(0,2));
    }
    public boolean isSelected6() {
        return isSelected(new Position(1,2));
    }
    public boolean isSelected7() {
        return isSelected(new Position(0,3));
    }
    public boolean isSelected8() {
        return isSelected(new Position(1,3));
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public int getPage() {
        return page;
    }

    public int getSelection() {
        return selection;
    }

    public int getAbilities() {
        return abilities;
    }

    public int int_player_choice(int x, int y, int page){
        int res = (page - 1) * 4;
        if(x == 0 && y == 0){
            res += 0;
        }
        else if(x == 1 && y == 0){
            res += 1;
        }
        else if(x == 0 && y == 1){
            res += 2;
        }
        else if(x == 1 && y == 1){
            res += 3;
        }

        return res;
    }

    public int getCurrentEntryX() {
        return currentEntryX;
    }

    public int getCurrentEntryY() {
        return currentEntryY;
    }
}
