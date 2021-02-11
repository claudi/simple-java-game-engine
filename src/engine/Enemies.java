package engine;

import java.awt.Graphics;

abstract public class Enemies extends Collection<Enemy> {
	public void render(Graphics graphics) {
		for(Enemy enemy: elements) {
			enemy.render(graphics);
		}
	}
	
	public abstract void move(int dx, int dy);
	public abstract void endFrame();
}
