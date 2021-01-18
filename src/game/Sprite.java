package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Sprite extends Entity {
	ArrayList<Pixel> pixels = new ArrayList<Pixel>(); // TODO: Make private (and not initialised?)
	
	void render(Graphics graphics) {
		for(Pixel pixel: pixels) {
			pixel.render(graphics);
		}
	}

	void move(int dx, int dy) {
		for(Pixel pixel: pixels) {
			pixel.move(dx, dy);
		}
		pos_x += dx;
		pos_y += dy;
	}
}
