package engine;

import java.awt.Graphics;

abstract public class Enemies extends Collection<Enemy> {
	public Bullets bullets;
	public void render(Graphics graphics) {
		for(Enemy enemy: elements) {
			enemy.render(graphics);
		}
		bullets.render(graphics);
	}
	
	public abstract void move();
	public abstract void endFrame();
}
