package engine;

import java.awt.Color;

public abstract class Enemy extends Entity {
	public Enemy(Color[][] pixel_array, int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}
	
	public abstract Bullet shoot();
}
