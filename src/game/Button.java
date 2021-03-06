package game;

import java.awt.Color;
import java.awt.Graphics;

class Button {
	private int pos_x, pos_y;
	private int width, height;
	private String label;
	private MenuCommand command;

	public Button(int pos_x, int pos_y, String label, MenuCommand command, Graphics graphics) {
		this.label = label.toUpperCase();
		this.height = graphics.getFontMetrics(GameFrame.menu_font).getAscent();
		this.width = graphics.getFontMetrics(GameFrame.menu_font).stringWidth(label);
		this.pos_x = GameFrame.WIDTH / 2 - width / 2;
		this.pos_y = pos_y;
		this.command = command;
	}

	int getPosX() {
		return pos_x;
	}

	int getPosY() {
		return pos_y;
	}

	int getHeight() {
		return height;
	}

	int getWidth() {
		return width;
	}

	MenuCommand getCommand() {
		return command;
	}

	void render(Graphics graphics) {
		// graphics.setColor(Color.WHITE);
		// graphics.fillRect(pos_x, pos_y, width, height);
		graphics.setColor(Color.WHITE);
		graphics.setFont(GameFrame.menu_font);
		graphics.drawString(label, pos_x, pos_y + height);
	}
}
