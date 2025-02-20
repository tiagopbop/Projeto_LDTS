package org.game.model.game.map;

import org.game.model.battle.battleElements.Hero;

import java.io.IOException;

public abstract class MapBuilder {

    protected MapBuilder() throws IOException {
    }

    public Map createMap(Hero hero, Map map) throws IOException {
        map = new Map(getWidth(), getHeight(), hero);

        createElements(map);
        return map;
    }

    public Map createMap(Hero hero) throws IOException {
        Map mapa = new Map(getWidth(), getHeight(), hero);

        createElements(mapa);
        return mapa;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract void createElements(Map map) throws IOException;

}

