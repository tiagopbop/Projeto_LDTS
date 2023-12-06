package org.game.model.game.map;

import org.game.model.game.elements.*;

import java.io.IOException;
import java.util.List;

public abstract class VillageBuilder {

    protected VillageBuilder() throws IOException {
    }

    public Village createVillage() throws IOException {
        Village village = new Village(getWidth(), getHeight());


        village.setHero(createHero());
        village.setWalls(createWalls());
        village.setNPC(createNPC());
        village.setGround(createGround());
        village.setDoors(createDoor());
        village.setHouseWall(createHouseWall());
        village.setHouseDoor(createHouseDoor());
        village.setRoofC(createRoofC());
        village.setRoofL(createRoofL());
        village.setRoofR(createRoofR());
        village.setPath(createPath());
        village.setStairs(createStairs());
        village.setDialogue1(createDialogue1());
        village.setDialogue2(createDialogue2());
        village.setDialogue3(createDialogue3());
        village.setDialogue4(createDialogue4());
        village.setDialogue5(createDialogue5());
        village.setChests(createChests());
        village.setSigns(createSigns());
        return village;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Hero createHero() throws IOException;

    protected abstract List<NPC> createNPC();
    protected abstract List<Ground> createGround();
    protected abstract List<HouseWall> createHouseWall();
    protected abstract List<HouseDoor> createHouseDoor();
    protected abstract List<RoofC> createRoofC();
    protected abstract List<RoofL> createRoofL();
    protected abstract List<RoofR> createRoofR();
    protected abstract List<Path> createPath();
    protected abstract List<Door> createDoor();
    protected abstract List<Stairs> createStairs();


    protected abstract List<DialogueT> createDialogue1();
    protected abstract List<DialogueT> createDialogue2();
    protected abstract List<DialogueT> createDialogue3();
    protected abstract List<DialogueT> createDialogue4();
    protected abstract List<DialogueT> createDialogue5();

    protected abstract List<Chest> createChests();

    protected abstract List<Sign> createSigns();
}

