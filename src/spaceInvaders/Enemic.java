package spaceInvaders;

import engine.Bullet;
import engine.Enemy;

public class Enemic extends Enemy {
	public Enemic(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	public Bullet shoot() {
		return new Bala(getPosX(), getPosY() + getHeight() / 2);
	}
	
	public void hit() {}
	public void endFrame() {}
}
