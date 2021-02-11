package engine;

import java.awt.Graphics;

abstract public class Bullets extends Collection<Bullet> {
	public abstract void move(int dx, int dy);

	public void render(Graphics graphics) {
		for (Bullet bullet : elements) {
			bullet.render(graphics);
		}
	}
}
