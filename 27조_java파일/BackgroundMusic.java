import java.awt.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.sound.sampled.FloatControl;
import java.io.IOException;

public class BackgroundMusic implements Runnable{
	public static Clip clip;
	public BackgroundMusic() {
	}
	public void run() {
		play("πË∞Ê¿Ωæ«01.wav");
	}
	public void play(String fileName) {
			try {
	    		AudioInputStream ais = AudioSystem.getAudioInputStream(new File("πË∞Ê¿Ωæ«01.wav"));
	    		clip = AudioSystem.getClip();
	    		clip.open(ais);
	    		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    		gainControl.setValue(-13.0f);
	    		clip.loop(Clip.LOOP_CONTINUOUSLY);
	    		clip.start();
	    	} catch(Exception ex) {
	    		ex.printStackTrace();
	    	}			 
    }
}
