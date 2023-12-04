package org.game.music;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Music {
    public Music(){}
    public void MusicPlay() throws URISyntaxException {
        URL res = Music.class.getResource("/music/doom.wav");
        File file = Paths.get(res.toURI()).toFile();

        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Clip clip = null;
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
        clip.start();




    }
}