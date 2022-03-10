import java.awt.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class ButtonSound implements Runnable{
	public ButtonSound() {
	}
	public void run() {
		play("button01.wav");
	}
	public void play(String fileName) {
		try {
    		AudioInputStream ais = AudioSystem.getAudioInputStream(new File("button01.wav"));
    		Clip clip = AudioSystem.getClip();
    		clip.stop();
    		clip.open(ais);
    		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    		gainControl.setValue(-10.0f);
    		clip.start();
    	} catch(Exception ex) {
    		
    	}
    }
}
