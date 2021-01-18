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
		int pixel_width = 21;
		for(int iter = 0; iter < pixel_width; iter++) {
			pixels.add(new Pixel(pos_x + (iter - pixel_width/2)*Pixel.width/2, pos_y, color));
			pixels.add(new Pixel(pos_x + (iter - pixel_width/2)*Pixel.width/2, pos_y + Pixel.height, color));
			pixels.add(new Pixel(pos_x + (iter - pixel_width/2)*Pixel.width/2, pos_y + 2*Pixel.height, color));
			pixels.add(new Pixel(pos_x + (iter - pixel_width/2)*Pixel.width/2, pos_y + 3*Pixel.height, color));
			pixels.add(new Pixel(pos_x + (iter - pixel_width/2)*Pixel.width/2, pos_y + 4*Pixel.height, color));
		}
	    count++;
	}
}
