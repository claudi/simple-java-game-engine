package brickBreak;

import engine.Enemies;
import engine.Game;
import engine.Sprite;

class Blocks extends Enemies {
	public Blocks(int n, int m, Game game) {
		// int width = game.getWidth();
		// int height = game.getHeight();
		bullets = new Bales();

		int block_width = Sprite.getPixelWidth() * Block.pixel_array[0].length;
		int block_height = Sprite.getPixelHeight() * Block.pixel_array.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				elements.add(new Block(i * block_width + Sprite.getPixelWidth(),
						(j + 1) * block_height + Sprite.getPixelHeight()));
			}
		}
	}

	@Override
	public void move() {
	}

	@Override
	public void endFrame() {
	}
}
