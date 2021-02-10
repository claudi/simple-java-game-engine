package spaceInvaders;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import engine.Game;

public class Main {
	static Random random = new Random();

	public static void main(String[] args) {
		Game game = new Game("Space Invaders");
		game.setBackground(generateBackground(game.getWidth(), game.getHeight()));
		
		game.setPlayer(new Jugador());
		Blocks blocks = new Blocks();
		game.setEnemies(blocks);
		
		game.mainLoop();
		game.quitGame();
	}
	
	private static BufferedImage generateBackground(int width, int height) {
		BufferedImage background = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (random.nextInt(500) == 0) {
					background.setRGB(i, j, Color.WHITE.getRGB());
				} else {
					background.setRGB(i, j, Color.BLACK.getRGB());
				}
			}
		}
		return background;
	}
}