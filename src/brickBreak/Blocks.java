package brickBreak;

import engine.Enemies;
import engine.Game;
import engine.Sprite;

class Blocks extends Enemies {
	public Blocks(int n, int m, Game game) {
		int width = game.getWidth();
		bullets = new Bales();

		int block_width = Sprite.getPixelWidth() * Block.pixel_array[0].length;
		int block_height = Sprite.getPixelHeight() * Block.pixel_array.length;

		int pad_x = Sprite.getPixelHeight();
		int pad_y = Sprite.getPixelHeight();

		int total_width = (n - 1) * (block_width + pad_x);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				elements.add(new Block(width / 2 + i * (block_width + pad_x) - total_width / 2,
						(j + 1) * (block_height + pad_y)));
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
