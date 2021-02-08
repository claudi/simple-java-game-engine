package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip clip = null;
	private AudioInputStream audioInputStream = null;

	public Sound(String name) {
		try {
			File file = new File("res/" + name + ".wav");
			audioInputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			audioInputStream.close();
			clip.start();
			clip.stop();
		} catch (Exception e) {
			System.out.println(name);
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
	
	public void close() {
		//clip.drain();
		clip.stop();
		clip.close();
		System.out.println(clip.isOpen());
	}
}
