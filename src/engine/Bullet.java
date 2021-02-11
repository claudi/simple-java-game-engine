package engine;

import java.awt.Color;

abstract public class Bullet extends Entity {	
	public Bullet(Color[][] pixel_array, int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}
	
	public abstract boolean outOfBounds();
}
