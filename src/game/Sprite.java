package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Sprite extends Entity {
	int height, width;					// Total sizes of the sprite
	int pixels_height, pixels_width;	// Dimensions of pixel array
	ArrayList<Pixel> pixels = new ArrayList<Pixel>();

	public Sprite(Color[][] pixel_array, int pos_x, int pos_y) {
		this.pixels_height = pixel_array.length;
		this.pixels_width = pixel_array[0].length;
		for(int i = 0; i < pixels_width; i++) {
			for(int j = 0; j < pixels_height; j++) {
				if(pixel_array[j][i] != null) {
					pixels.add(new Pixel(pos_x + (i - pixels_width/2)*Pixel.width, pos_y + j*Pixel.height, pixel_array[j][i]));
				}
			}
		}

		this.height = Pixel.height * pixels_height;
		this.width = Pixel.width * pixels_width;
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
			if(entity.collision(pixel)) {
				return true;
			}
		}
		return false;
	}

	abstract void endFrame();
}
