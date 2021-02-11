package spaceInvaders;

import java.awt.Color;

import engine.Bullet;
import engine.Enemy;
import engine.Game;

public class Enemic extends Enemy {
	static Color[][] pixel_array = Game.sprites("enemy");
	
	public Enemic(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	public Bullet shoot() {
		return new Bala(getPosX(), getPosY() + getHeight() / 2);
	}
	
	public void hit() {}
	public void endFrame() {}
}
