package org.game.model.game.map;

import org.game.model.game.elements.Hero;

import java.io.IOException;

public abstract class MapBuilder {

    protected MapBuilder() throws IOException {
    }

    public Map createMap(Hero hero) throws IOException {
        Map map = new Map(getWidth(), getHeight(), hero);

        createElements(map);
        return map;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract void createElements(Map map) throws IOException;

}

