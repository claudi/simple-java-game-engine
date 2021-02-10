package engine;

import java.awt.image.BufferedImage;

public class Game {
	GameFrame frame;
	Player player;
	
	public Game(String name) {
		frame = new GameFrame(name);
	}
	
	public Game(String name, int height, int width) {
		frame = new GameFrame(name, height, width);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setBackground(BufferedImage background) {
		frame.setBackground(background);
	}

	public int getWidth() {
		return frame.getWidth();
	}
	
	public int getHeight() {
		return frame.getHeight();
	}
}
