package breakout;

import java.awt.Color;

import engine.Bullet;
import engine.Enemy;
import engine.Game;

class Block extends Enemy {
	static Color[][] pixel_array = Game.sprites("rectangle");

	public Block(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		// TODO Auto-generated constructor stub
	}

	boolean alive = true;

	@Override
	public Bullet shoot() {
		return null;
	}

	@Override
	public void hit() {
		alive = false;
	}

	@Override
	public boolean isDead() {
		return !alive;
	}

	@Override
	public void endFrame() {
	}

}
