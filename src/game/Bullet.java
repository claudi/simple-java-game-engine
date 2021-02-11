package game;

import java.awt.Color;

class Bullet extends Entity {
	static int count = 0;
	static final Color color = Color.WHITE;

	static Color pixel_array[][] = Game.sprites("bullet");

	public Bullet(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		count++;
	}

	void move(int v) {
		super.move(0, v);
	}

	void endFrame() {
	}

	public boolean outOfBounds() {
		if (pos_y + height <= 0 || pos_y >= GameFrame.HEIGHT) {
			return true;
		}
		return false;
	}
}
