package org.game.model.game.map;

import org.game.model.game.elements.*;
import org.game.model.Position;

import java.util.List;

public class Village {
    private final int width;
    private final int height;

    private Hero hero;
    private List<NPC> NPC;
    private List<Door> doors;
    private List <Stairs> stairs;

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
    public void setNPC(List<NPC> NPC){this.NPC = NPC;}

    public void setDoors(List<Door> door){this.doors = door;}

    public void setStairs(List<Stairs> stairs){this.stairs = stairs;}


    public void setWalls(List<Wall> walls){
        this.walls = walls;
    }

    public Hero getHero(){
        return this.hero;
    }
    public List<NPC> getNPC(){return NPC;}

    public List<Wall> getWalls(){
        return walls;
    }
    public List<Stairs> getStairs(){
        return stairs;
    }
    public List<Door> getDoors(){
        return doors;
    }


    public boolean isEmpty(Position position){
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        for(NPC NPC: NPC){if (NPC.getPosition().equals(position)){ return false;}}
        for(Stairs stair: stairs){if (stair.getPosition().equals(position)){ return false;}}
        for(Door door: doors){if (door.getPosition().equals(position)){ return false;}}

        return true;
    }
}
