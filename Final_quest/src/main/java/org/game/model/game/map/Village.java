package org.game.model.game.map;

import org.game.model.dialogue.Dialogue;
import org.game.model.game.elements.*;
import org.game.model.Position;

import java.util.Arrays;
import java.util.List;

public class Village {
    private final int width;
    private final int height;

    private Hero hero;

    private Dialogue narrator;
    private List<NPC> NPC;
    private List<Ground> ground;
    private List<HouseWall> housewall;
    private List<HouseDoor> housedoor;
    private List<RoofC> roofc;
    private List<RoofR> roofr;
    private List<RoofL> roofl;
    private List<Path> path;
    private List<Door> doors;
    private List <Stairs> stairs;
    private  List<DialogueT> dialogues1;
    private  List<DialogueT> dialogues2;
    private  List<DialogueT> dialogues3;
    private  List<DialogueT> dialogues4;
    private  List<DialogueT> dialogues5;
    private List<Wall> walls;
    private List<Sign> signs;
    private  List<Chest> chests;
    private boolean options;
    private int currentEntry;
    private final List<String> entries;
    public Village(int width, int height){
        this.width = width;
        this.height = height;
        this.narrator = new Dialogue("The hero has spawned");
        this.entries = Arrays.asList("Yes", "No");

    }

    public Village(int width, int height, List<Wall> walls, List<Ground> ground, List<NPC> NPC, List<Door> doors, List<HouseWall> housewall, List<HouseDoor> housedoor, List<RoofC> roofc, List<RoofL> roofl, List<RoofR> roofr, List<Path> path, List <Stairs> stairs, List<DialogueT> dialogues1, List<DialogueT> dialogues2, List<DialogueT> dialogues3, List<DialogueT> dialogues4, List<DialogueT> dialogues5, List<Sign> signs, List<Chest> chests) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        this.ground = ground;
        this.NPC = NPC;
        this.doors = doors;
        this.housewall = housewall;
        this.housedoor = housedoor;
        this.roofc = roofc;
        this.roofl = roofl;
        this.roofr = roofr;
        this.path = path;
        this.stairs = stairs;
        this.dialogues1 = dialogues1;
        this.dialogues2 = dialogues2;
        this.dialogues3 = dialogues3;
        this.dialogues4 = dialogues4;
        this.dialogues4 = dialogues5;
        this.signs = signs;
        this.chests = chests;
        this.narrator = new Dialogue("The hero has spawned");
        this.options = false;
        this.entries = Arrays.asList("Yes, No");
    }

    public void setOptions(boolean options) {
        this.options = options;
    }
    public boolean getOptions()
    {
        return this.options;
    }
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


    public void setGround(List<Ground> ground){this.ground = ground;}
    public void setHouseWall(List<HouseWall> housewall){this.housewall = housewall;}
    public void setHouseDoor(List<HouseDoor> housedoor){this.housedoor = housedoor;}
    public void setRoofC(List<RoofC> roofc){this.roofc = roofc;}
    public void setRoofL(List<RoofL> roofl){this.roofl = roofl;}
    public void setRoofR(List<RoofR> roofr){this.roofr = roofr;}
    public void setPath(List<Path> path){this.path = path;}
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
    public List<Ground> getGround(){return ground;}
    public List<HouseWall> getHouseWall(){return housewall;}
    public List<HouseDoor> getHouseDoor(){return housedoor;}
    public List<RoofC> getRoofC(){return roofc;}
    public List<RoofL> getRoofL(){return roofl;}
    public List<RoofR> getRoofR(){return roofr;}
    public List<Path> getPath(){return path;}
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


    public boolean isEmpty(Position position){
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        for(NPC NPC: NPC){if (NPC.getPosition().equals(position)){ return false;}}
        for(Stairs stair: stairs){if (stair.getPosition().equals(position)){ return false;}}
        for(Door door: doors){if (door.getPosition().equals(position)){ return false;}}
        for(Sign sign: signs){if (sign.getPosition().equals(position)){ return false;}}
        for(Chest chest: chests){if (chest.getPosition().equals(position)){ return false;}}
        for(HouseWall wall: housewall){if (wall.getPosition().equals(position)){ return false;}}
        for(HouseDoor door: housedoor){if (door.getPosition().equals(position)){ return false;}}
        for(RoofR tel: roofr){if (tel.getPosition().equals(position)){ return false;}}
        for(RoofC tel: roofc){if (tel.getPosition().equals(position)){ return false;}}
        for(RoofL tel: roofl){if (tel.getPosition().equals(position)){ return false;}}


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


    public void setDialogue1(List<DialogueT> dialogue) {this.dialogues1 = dialogue;}
    public void setDialogue2(List<DialogueT> dialogue) {this.dialogues2 = dialogue;}
    public void setDialogue3(List<DialogueT> dialogue) {this.dialogues3 = dialogue;}
    public void setDialogue4(List<DialogueT> dialogue) {this.dialogues4 = dialogue;}
    public void setDialogue5(List<DialogueT> dialogue) {this.dialogues5 = dialogue;}

    public List<DialogueT> getDialogues1() {return dialogues1;}
    public List<DialogueT> getDialogues2() {return dialogues2;}
    public List<DialogueT> getDialogues3() {return dialogues3;}
    public List<DialogueT> getDialogues4() {return dialogues4;}
    public List<DialogueT> getDialogues5() {return dialogues5;}

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
