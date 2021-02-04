package game;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite extends Collection<Pixel> {
	int height, width; // Total sizes of the sprite
	int pixels_height, pixels_width; // Dimensions of pixel array

	public Sprite(Color[][] pixel_array, int pos_x, int pos_y) {
		this.pixels_height = pixel_array.length;
		this.pixels_width = pixel_array[0].length;
		for (int i = 0; i < pixels_width; i++) {
			for (int j = 0; j < pixels_height; j++) {
				if (pixel_array[j][i] != null) {
					elements.add(new Pixel(pos_x + (i - pixels_width / 2) * Pixel.width, pos_y + j * Pixel.height,
							pixel_array[j][i]));
				}
			}
		}

		this.height = Pixel.height * pixels_height;
		this.width = Pixel.width * pixels_width;
	}

	void render(Graphics graphics) {
		for (Pixel pixel : elements) {
			pixel.render(graphics);
		}
	}
}
