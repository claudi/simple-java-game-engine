package breakout;

import engine.Bullets;
import engine.Entity;

class Bales extends Bullets {

	@Override
	public void move(int dx, int dy) {
		for (Entity bala : elements) {
			bala.move(dx, dy);
		}
	}

}
