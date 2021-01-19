package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Sprite extends Entity {
	// private static ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	int height, width;
	ArrayList<Pixel> pixels = new ArrayList<Pixel>(); // TODO: Make private (and not initialised?)
	
	public Sprite(boolean[][] pixel_array, int pos_x, int pos_y, Color color) {
		this.height = pixel_array.length;
		this.width = pixel_array[0].length;
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(pixel_array[j][i]) {
					pixels.add(new Pixel(pos_x + (i - width/2)*Pixel.width, pos_y + j*Pixel.height, color));
				}
			}
		}
	}

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
	
	boolean collision(Entity entity) {
		for(Pixel pixel: pixels) {
			if(pixel.collision(entity)) {
				return true;
			}
		}
		return false;
	}
}
