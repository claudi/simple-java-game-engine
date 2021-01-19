package game;

import java.awt.Color;
import java.awt.Graphics;

public class Pixel extends Entity {
	final static int width = 5, height = 5;
	private Color color;
	
	public Pixel(int pos_x, int pos_y, Color color) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.color = color;
	}
	
	void render(Graphics graphics) {
		graphics.setColor(color);
		graphics.fillRect(pos_x, pos_y, width, height);
	}

	void move(int dx, int dy) {
		pos_x += dx;
		pos_y += dy;
	}

	@Override
	boolean collision(Entity entiry) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
