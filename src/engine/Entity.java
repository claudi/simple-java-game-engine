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

	public boolean isOutOfBounds() {
		return isOutOfBoundsLeft() || isOutOfBoundsRight() || isOutOfBoundsTop() || isOutOfBoundsBottom();
	}
	
	public abstract boolean isOutOfBoundsLeft();
	public abstract boolean isOutOfBoundsRight();
	public abstract boolean isOutOfBoundsTop();
	public abstract boolean isOutOfBoundsBottom();
	public abstract void endFrame();
}
