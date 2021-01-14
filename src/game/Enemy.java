package game;
import java.awt.Graphics;
import java.awt.Color;

public class Enemy extends Entity {
	static int count = 0;
	public static int width = 30;
	public static int height = 20;

	public Enemy(int pos_x, int pos_y) {
	    super(pos_x, pos_y);
	    count++;
	}

	void move(int v) {
	    pos_x += v;
	}

	void render(Graphics graphics) {
	    graphics.setColor(Color.WHITE);
	    graphics.fillRect(pos_x - width/2, pos_y, width, height);
	}
}
