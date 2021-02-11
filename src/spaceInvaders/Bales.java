package spaceInvaders;

import engine.Bullet;
import engine.Bullets;

public class Bales extends Bullets {
	public void move(int dx, int dy) {
		for(Bullet bala: elements) {
			bala.move(0, dy);
		}
	}
}
