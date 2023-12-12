package org.game.music;

import org.game.Game;

import java.net.URISyntaxException;

public interface MusicObserver {
    void update(Game game) throws URISyntaxException;

}
