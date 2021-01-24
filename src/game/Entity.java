package game;

import java.awt.Graphics;

abstract public class Entity {
	int pos_x, pos_y; // Central position of Entity 
	abstract void render(Graphics graphics);
	abstract void move(int dx, int dy);
	abstract boolean collision(Entity entity);
}
