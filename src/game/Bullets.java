package game;

import java.awt.Graphics;

public class Bullets extends Collection<Bullet> {
	int v;
	
	Bullets(int v) {
		this.v = v;
	}
	
	public void move() {
		for(Bullet bullet: elements) {
			bullet.move(v);
		}
	}
	
	public void render(Graphics graphics) {
		for(Bullet bullet: elements) {
			bullet.render(graphics);
		}
	}
	
	public void endFrame() {
		for(Bullet bullet: elements) {
			bullet.endFrame();
		}
	}
}
