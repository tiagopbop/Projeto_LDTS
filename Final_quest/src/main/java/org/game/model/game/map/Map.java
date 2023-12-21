package org.game.model.game.map;

import org.game.model.battle.battleElements.Hero;
import org.game.model.game.elements.interactabel.*;
import org.game.model.game.elements.nonInteractabel.Wall;
import org.game.rpg_elements.dialogue.Dialogue;
import org.game.model.game.elements.*;
import org.game.model.Position;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Map {
    private final int width;
    private final int height;

    private Hero hero;

    private Dialogue narrator;
    private List<org.game.model.game.elements.interactabel.NPC> NPC;
    private List<Door> doors;
    private List <Stairs> stairs;
    private List<Wall> walls;
    private List<Sign> signs;
    private  List<Chest> chests;
    private Integer options;
    private int currentEntry;
    private final List<String> entries;

    private static Stack<Integer> mapstack= new Stack<Integer>();
    public Map(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.narrator = new Dialogue("The hero has spawned");
        this.hero = hero;
        this.entries = Arrays.asList("Yes", "No");
        this.options = 0;
    }

    public Map(int width, int height, List<Wall> walls, List<NPC> NPC, List<Door> doors, List <Stairs> stairs, List<Sign> signs, List<Chest> chests) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        this.NPC = NPC;
        this.doors = doors;
        this.stairs = stairs;
        this.signs = signs;
        this.chests = chests;
        this.narrator = new Dialogue("The hero has spawned");
        this.options = 0;
        this.entries = Arrays.asList("Yes, No");
    }




    public void setOptions(Integer options) {
        this.options = options;
    }
    public Integer getOptions()
    {
        return this.options;
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
    public void setChests(List<Chest> chests){this.chests=chests;}
    public void setSigns(List<Sign> signs){this.signs=signs;}

    public void  setNarrator(Dialogue n){this.narrator = n;}
    public Dialogue getNarrator()
    {
        return narrator;
    }

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

    public List<Sign> getSigns(){return  signs;}

    public List<Chest> getChests(){return chests;}

    public String getEntry(int i) {
        return entries.get(i);
    }


    public boolean isEmpty(Position position) throws IOException {

        for(Wall wall : walls){
            if(wall.getPosition().equals(position) && !wall.getType().equals("ground") && !wall.getType().equals("path") && !wall.getType().equals("grass") && !wall.getType().equals("bridge")){
                return false;
            }
        }
        for(NPC NPC: NPC){if (NPC.getPosition().equals(position)){ return false;}}
        for(Stairs stair: stairs){if (stair.getPosition().equals(position)){ return false;}}
        for(Door door: doors){if (door.getPosition().equals(position)){ return false;}}
        for(Sign sign: signs){if (sign.getPosition().equals(position)){ return false;}}
        for(Chest chest: chests){if (chest.getPosition().equals(position)){ return false;}}

        return true;
    }

    public Dialogue isInteractable(Position position)
    {
        for(NPC npc: NPC){if (npc.getPosition().equals(position)){ return npc.getDialogue();}
        }
        for(Sign sign: signs){if (sign.getPosition().equals(position)){ return sign.getDialogue();}}
        for(Chest chest: chests){if (chest.getPosition().equals(position)){ return chest.getDialogue();}}
        for(Door door: doors){if (door.getPosition().equals(position)){ return door.getDialogue();}}
        for(Stairs stairs: stairs){if (stairs.getPosition().equals(position)){ return stairs.getDialogue();}}
        for(Wall wall: walls){if (wall.getPosition().equals(position)){ return wall.getDialogue();}}


        return new Dialogue();
    }

    public boolean isInteractableChest(Position position)
    {
        for(Chest chest: chests) {
            if (chest.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Element toMenu(Position position) {
        for (NPC npc : NPC) {
            if (npc.getPosition().equals(position)) {
                return npc;
            }
        }
        for (Chest chest : chests) {
            if (chest.getPosition().equals(position)) {
                return chest;
            }
        }
        for (Door door : doors) {
            if (door.getPosition().equals(position)) {
                return door;
            }
        }
        for (Stairs stairs : stairs) {
            if (stairs.getPosition().equals(position)) {
                return stairs;
            }
        }
        return hero.getHeroElement();
    }



    public void nextEntry() {
        currentEntry++;
        if (currentEntry > 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = 1;
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedNo() {
        return isSelected(1);
    }

    public boolean isSelectedYes() {
        return isSelected(0);
    }
}
