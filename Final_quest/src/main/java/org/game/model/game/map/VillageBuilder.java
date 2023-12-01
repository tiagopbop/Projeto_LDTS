package org.game.model.game.map;

import org.game.model.game.elements.*;

import java.util.List;

public abstract class VillageBuilder {
    public Village createVillage() {
        Village village = new Village(getWidth(), getHeight());

        village.setHero(createHero());
        village.setWalls(createWalls());
        village.setNPC(createNPC());
        village.setDoors(createDoor());
        village.setStairs(createStairs());

        return village;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Hero createHero();

    protected abstract List<NPC> createNPC();
    protected abstract List<Door> createDoor();
    protected abstract List<Stairs> createStairs();


}

