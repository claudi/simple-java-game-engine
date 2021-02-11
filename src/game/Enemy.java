package game;

import java.awt.Color;

class Enemy extends Entity {
	static int count = 0;
	static final Color color = Color.WHITE;

	static Color pixel_array[][] = Game.sprites("enemy");

	public Enemy(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		count++;
	}

	Bullet shoot() {
		return new Bullet(pos_x, pos_y + height / 2);
	}

	void hit() {
	}

	void endFrame() {
	}
}
