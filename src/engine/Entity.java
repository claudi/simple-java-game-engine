package engine;

import java.awt.Color;

abstract public class Entity extends Sprite {
	public Entity(Color[][] pixel_array, int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	boolean collision(Entity entity) {
		for (Pixel pixel : elements) {
			if (pixel.collision(entity)) {
				return true;
			}
		}
		return false;
	}

	public abstract void hit();
	public abstract boolean isDead();

	public boolean isAlive() {
		return !isDead();
	}

	public abstract void endFrame();
}
