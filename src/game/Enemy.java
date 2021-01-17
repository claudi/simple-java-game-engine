package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {
	static int count = 0;
	public static int width = 30;
	public static int height = 20;

	public Enemy(int x, int y) {
	    super(x, y);
	    count++;
	}

	void move(int v) {
	    x += v;
	}

	void render(Graphics graphics) {
	    graphics.setColor(Color.WHITE);
	    graphics.fillRect(x - width/2, y, width, height);
	}
}
