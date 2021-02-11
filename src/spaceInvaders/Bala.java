package spaceInvaders;

import java.awt.Color;

import engine.Bullet;
import engine.Game;

public class Bala extends Bullet {
	static Color[][] pixel_array = Game.sprites("bullet");
	
	public Bala(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	public void endFrame() {}

	public boolean outOfBounds(int maxHeight) {
		int pos_y = getPosY();
		if (pos_y + getHeight() <= 0 || pos_y >= maxHeight) {
			return true;
		}
		return false;
	}

}
