package org.game.music;

import java.net.URISyntaxException;

public interface MusicSubject {
    void addObserver(Music observer);
    void removeObserver(MusicObserver observer);

     void notifyObservers() throws URISyntaxException;

     void notifyBuy(int toggle) throws URISyntaxException;

    void notifySilence() throws  URISyntaxException;
}
