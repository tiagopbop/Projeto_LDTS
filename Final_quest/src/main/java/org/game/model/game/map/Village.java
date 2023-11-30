package org.game.model.game.map;

import org.game.model.game.elements.Hero;
import org.game.model.Position;
import org.game.model.game.elements.Wall;

import java.util.List;

public class Village {
    private final int width;
    private final int height;

    private Hero hero;

    private List<Wall> walls;

    public Village(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public void setWalls(List<Wall> walls){
        this.walls = walls;
    }

    public Hero getHero(){
        return this.hero;
    }

    public List<Wall> getWalls(){
        return walls;
    }

    public boolean isEmpty(Position position){
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
}
