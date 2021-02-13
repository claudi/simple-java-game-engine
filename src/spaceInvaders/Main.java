package spaceInvaders;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import engine.Game;

public class Main {
	static Random random = new Random();

	public static void main(String[] args) {
		Game game = new Game("Space Invaders");
		game.setBackground(generateBackground(game));

		Jugador jugador = new Jugador(game.getWidth() / 2, Math.round(0.9f * game.getHeight()));
		jugador.setBounds(game);
		game.setPlayer(jugador);

		Enemics enemics = new Enemics(5, 5, game.getWidth() / 2);
		enemics.setBounds(game);
		game.setEnemies(enemics);

		Bala.setBounds(game);

		game.mainLoop();
		game.quitGame();
	}

	private static BufferedImage generateBackground(Game game) {
		int width = game.getWidth();
		int height = game.getHeight();
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
