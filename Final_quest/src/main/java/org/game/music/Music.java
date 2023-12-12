package org.game.music;

import org.game.Game;
import org.game.model.game.map.MapLoader;
import org.game.states.MapState;
import org.game.states.State;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Music implements MusicObserver{
    private Game game;
    private URL url;
    private Integer last_obs = 0;
    private int last_map = 0;
    private static Clip clip;
    public Music(Game game){
        this.game = game;
    }
    public void MusicPlay(int estado) throws URISyntaxException {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
        switch (estado)
        {
            case 0:
                url = Music.class.getResource("/music/main_menu.wav");
                break;
            case 1:
                url = Music.class.getResource("/music/village_music.wav");
                break;
            case 2:
                url = Music.class.getResource("/music/invent.wav");

                break;
            case 3:
                url = Music.class.getResource("/music/doom.wav");

                break;
            case 4:
                url = Music.class.getResource("/music/castle.wav");

                break;
        }
        File file = Paths.get(url.toURI()).toFile();

        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(audiostream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();




    }

    @Override
    public void update(Game game) throws URISyntaxException {
        if(last_obs == game.getState().getObs().getKey() && last_obs!=1)
        {
            return;
        }

        last_obs = (Integer) game.getState().getObs().getKey();


        switch (last_obs)
        {
            case 0:
                MusicPlay(0);
                break;
            case 1:
                Integer maptosee = (Integer) game.getState().getObs().getValue();
                switch ((Integer)game.getState().getObs().getValue())
                {
                    case 0:
                        MusicPlay(1);
                        break;
                    case 1:
                        MusicPlay(4);
                        break;
                    case 2:
                        MusicPlay(5);
                        break;
                }

                break;
            case 2:
                MusicPlay(2);
                break;


            case 3:
                MusicPlay(2);
                break;
        }




    }


}