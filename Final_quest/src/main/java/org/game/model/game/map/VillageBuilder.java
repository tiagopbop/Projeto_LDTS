package org.game.model.game.map;

import org.game.model.game.elements.*;

import java.io.IOException;
import java.util.List;

public abstract class VillageBuilder {

    protected VillageBuilder() throws IOException {
    }

    public Village createVillage() throws IOException {
        Village village = new Village(getWidth(), getHeight());

        createElements(village);
        return village;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract void createElements(Village village) throws IOException;

}

