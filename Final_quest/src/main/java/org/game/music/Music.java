package org.game.music;

import org.game.Game;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import javax.sound.sampled.*;
import java.util.Random;


public class Music implements MusicObserver{
    private Game game;
    private URL url;

    private URL url2;
    private static Clip clip2;
    private Integer last_obs = 0;
    private static Clip clip;
    private boolean invent_sound = false;

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
            case 0://mainmenu
                url = Music.class.getResource("/music/main_menu.wav");
                break;
            case 1://vila
                clip.stop();
                clip.close();
                url = Music.class.getResource("/music/village_music.wav");
                break;
            case 2://inventario
                url = Music.class.getResource("/music/invent.wav");

                break;
            case 3: //castleentrance
                url = Music.class.getResource("/music/castleentrance.wav");

                break;
            case 4: //castelo
                url = Music.class.getResource("/music/castle.wav");

                break;
            case 5: // combat
                if(Game.getFloor()==3)
                {
                    url = Music.class.getResource("/music/final_boss.wav");
                    break;
                }
                Random rand = new Random();
                int n = rand.nextInt(2);
                if(n == 0) url = Music.class.getResource("/music/combat1.wav");
                else url = Music.class.getResource("/music/combat2.wav");
                break;

            case 6:
                url = Music.class.getResource("/music/victory.wav");
                break;
            case 7:
                url = Music.class.getResource("/music/shop.wav");
                break;
            case 8:
                url = Music.class.getResource("/music/mclaren.wav");
                break;
            case 10:
                url = Music.class.getResource("/music/doom.wav");
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
        gainControl.setValue(1.0f);
        clip.start();





    }

    @Override
    public void update(Game game) throws URISyntaxException {
        if(last_obs == game.getState().getObs().getKey() && last_obs!=1 )
        {
            return;
        }

        if(last_obs==6&&(Integer)game.getState().getObs().getValue()==1)
        {
            clip.stop();
            clip.close();
            clip.stop();
            clip.close();
        }

        last_obs = (Integer) game.getState().getObs().getKey();


        switch (last_obs)
        {
            case 0: //menu
                MusicPlay(0);
                break;
            case 1: //mapstate
                Integer maptosee = (Integer) game.getState().getObs().getValue();
                if(invent_sound==true)
                {
                    invent_sound=false;
                    upvolume();
                    break;
                }

                switch ((Integer)game.getState().getObs().getValue())
                {

                    case 0://vila
                        MusicPlay(1);
                        break;
                    case 1: //castle entrance
                        MusicPlay(3);
                        break;
                    case 2://insidecastle
                        MusicPlay(4);
                        break;

                    case 10:
                        lowervolume();
                        invent_sound=true;
                        break;
                }
                break;



            case 3: //inventario
                break;
            case 4: //death
                MusicPlay(3); //alterar
                break;
            case 5: //combate
                MusicPlay(5);
                break;
            case 6://receive e lvlupstate
                MusicPlay(6);
                break;
            case 7: //shop
                MusicPlay(7);
                lower_little();
                break;
            case 8:
                MusicPlay(8);
                break;
            case 10:
                MusicPlay(10);

                break;
        }




    }

    public void lowervolume()
    {
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f);
        clip.start();
    }

    public void lower_little()
    {
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();
    }


    public void upvolume()
    {
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();
    }

    public void updateBuy(Game game,int toggle) throws URISyntaxException {
        float ff;
        if(toggle == 0){
            url2 = Music.class.getResource("/music/buy2.wav");
            ff=5.0f;
        }
        else
        {
            url2 = Music.class.getResource("/music/error.wav");
            ff = 1.0f;
        }

        File file = Paths.get(url2.toURI()).toFile();

        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            clip2 = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip2.open(audiostream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FloatControl gainControl =
                (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(ff);
        clip2.start();




    }

    @Override
    public void updateSilence(Game game) throws URISyntaxException {
        clip.stop();
        clip.close();
    }
}