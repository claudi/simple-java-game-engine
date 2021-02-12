package spaceInvaders;

import java.awt.Color;

import engine.Bullet;
import engine.Game;

class Bala extends Bullet {
	private static int bounds;
	private boolean alive = true;
	static Color[][] pixel_array = Game.sprites("bullet");

	public Bala(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	public void endFrame() {
	}

	public static void setBounds(Game game) {
		Bala.bounds = game.getHeight();
	}

	public boolean outOfBounds() {
		int pos_y = getPosY();
		int height = getHeight();
		if (pos_y + height <= 0 || pos_y >= bounds) {
			return true;
		}
		return false;
	}

	public void hit() {
		alive = false;
	}

	public boolean isDead() {
		return !alive;
	}

}
