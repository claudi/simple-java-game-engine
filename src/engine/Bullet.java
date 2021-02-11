package engine;

import java.awt.Color;

abstract public class Bullet extends Entity {
	static Color pixel_array[][] = Game.sprites("bullet");

	public Bullet(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	void move(int v) {
		super.move(0, v);
	}

	abstract public void endFrame();
}
