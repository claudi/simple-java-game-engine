package engine;

import java.awt.Color;
import java.awt.Graphics;

class Pixel {
	int pos_x, pos_y;
	final static int width = 5, height = 5;
	private Color color;

	public Pixel(int pos_x, int pos_y, Color color) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.color = color;
	}

	void render(Graphics graphics) {
		graphics.setColor(color);
		graphics.fillRect(pos_x - width / 2, pos_y - height / 2, width, height);
	}

	void move(int dx, int dy) {
		pos_x += dx;
		pos_y += dy;
	}

	boolean collision(Entity entity) {
		for (Pixel pixel : entity.elements) {
			if (collision(pixel)) {
				return true;
			}
		}
		return false;
	}

	boolean collision(Pixel pixel) {
		boolean leftLTright = this.pos_x - width / 2 <= pixel.pos_x + width / 2;
		boolean rightGTleft = this.pos_x + width / 2 >= pixel.pos_x - width / 2;
		boolean topLTbottom = this.pos_y <= pixel.pos_y + height;
		boolean bottolGTtop = this.pos_y + height >= pixel.pos_y;

		if (leftLTright && rightGTleft && topLTbottom && bottolGTtop) {
			return true;
		}
		return false;
	}

}
