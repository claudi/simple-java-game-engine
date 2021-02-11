package engine;

import java.awt.Color;

abstract public class Bullet extends Entity {
	static Color pixel_array[][] = Game.sprites("bullet");

	public Bullet(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	abstract public boolean outOfBounds();
}
