package game;

import java.awt.Color;

abstract class Entity extends Sprite {
	public Entity(Color[][] pixel_array, int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	int pos_x, pos_y; // Central position of Entity

	void move(int dx, int dy) {
		for (Pixel pixel : elements) {
			pixel.move(dx, dy);
		}
		pos_x += dx;
		pos_y += dy;
	}

	boolean collision(Entity entity) {
		for (Pixel pixel : elements) {
			if (pixel.collision(entity)) {
				return true;
			}
		}
		return false;
	}

	abstract void endFrame();
}
