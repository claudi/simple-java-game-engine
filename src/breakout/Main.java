package breakout;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.Game;

class Main {
	public static void main(String[] args) {
		Game game = new Game("Brick break");
		game.setBackground(generateBackground(game));
		game.setDelay(12);

		Jugador jugador = new Jugador(game.getWidth() / 2, Math.round(0.9f * game.getHeight()));
		jugador.setBounds(game);
		game.setPlayer(jugador);

		Blocks enemics = new Blocks(20, 10, game);
		game.setEnemies(enemics);

		Bala.setBounds(game);

		game.mainLoop();
		game.quitGame();
	}

	static BufferedImage generateBackground(Game game) {
		int width = game.getWidth();
		int height = game.getHeight();
		BufferedImage background = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < background.getWidth(); i++) {
			for (int j = 0; j < background.getHeight(); j++) {
				background.setRGB(i, j, Color.BLACK.getRGB());
			}
		}
		return background;
	}

}
