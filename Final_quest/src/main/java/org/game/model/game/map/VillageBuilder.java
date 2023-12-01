package org.game.model.game.map;

import org.game.model.game.elements.Hero;
import org.game.model.game.elements.Wall;

import java.io.IOException;
import java.util.List;

public abstract class VillageBuilder {
    public Village createVillage() throws IOException {
        Village village = new Village(getWidth(), getHeight());

        village.setHero(createHero());
        village.setWalls(createWalls());

        return village;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Hero createHero() throws IOException;
}

