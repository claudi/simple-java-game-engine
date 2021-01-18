package game;

import java.awt.Color;

public class Enemy extends Sprite {
	static int count = 0;
	public static int width = 30;
	public static int height = 20;
	private final Color color = Color.WHITE;

	public Enemy(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	    pixels.add(new Pixel(this.pos_x, this.pos_y, color));
	    count++;
	}
}
