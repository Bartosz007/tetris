package helper.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class SoundPlayer {
    private Clip clip;

    public SoundPlayer(InputStream stream) {
        try{
            InputStream bufferedIn = new BufferedInputStream(stream);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void playOnce(){

        try{
            clip.start();

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void playContinoulsly(){

        try {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void stop(){
        try{
            clip.stop();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
