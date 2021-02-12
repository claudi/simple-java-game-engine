package spaceInvaders;

import java.awt.Color;

import engine.Bullet;
import engine.Enemy;
import engine.Game;

public class Enemic extends Enemy {
	private boolean alive = true;
	static Color[][] pixel_array = Game.sprites("enemy");

	public Enemic(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	public Bullet shoot() {
		return new Bala(getPosX(), getPosY() + getHeight() / 2);
	}

	public void hit() {
		alive = false;
	}

	public boolean isDead() {
		return !alive;
	}

	public void endFrame() {
	}
}
