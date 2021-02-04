package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip clip;
	
	public Sound(String name) {
		try {
	         File url = new File("res/" + name + ".wav");
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	         clip = AudioSystem.getClip();
	         clip.open(audioInputStream);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
   public void play() {
         if (clip.isRunning()) {
            clip.stop();
         }
         clip.setFramePosition(0);
         clip.start();
   }
}
