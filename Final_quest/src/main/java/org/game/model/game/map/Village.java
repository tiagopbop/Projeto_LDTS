package org.game.model.game.map;

import org.game.model.Dialogue.Dialogue;
import org.game.model.game.elements.*;
import org.game.model.Position;

import java.util.List;

public class Village {
    private final int width;
    private final int height;

    private Hero hero;

    private Dialogue narrator;
    private List<NPC> NPC;
    private List<Door> doors;
    private List <Stairs> stairs;
    private  List<DialogueT> dialogues;
    private List<Wall> walls;
    private List<Sign> signs;
    private  List<Chest> chests;

    public Village(int width, int height){
        this.width = width;
        this.height = height;
        this.narrator = new Dialogue("The hero has spawned");
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


        return true;
    }

    public Dialogue isInteractable(Position position)
    {
        for(NPC npc: NPC){if (npc.getPosition().equals(position)){ return npc.getDialogue();}
        }
        for(Sign sign: signs){if (sign.getPosition().equals(position)){ return sign.getDialogue();}}
        return new Dialogue();
    }
    public void setDialogue(List<DialogueT> dialogue) {this.dialogues = dialogue;}

    public List<DialogueT> getDialogues() {return dialogues;
    }
}
