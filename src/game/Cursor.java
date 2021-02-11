package game;

import java.awt.Color;
import java.awt.Graphics;

class Cursor {
	private int pos_x, pos_y;
	private int width, height;
	private String label;
	MenuCommand command;

	public Cursor(int pos_x, int pos_y, Graphics graphics) {
		this.label = ">";
		this.height = graphics.getFontMetrics(GameFrame.menu_font).getAscent();
		this.width = graphics.getFontMetrics(GameFrame.menu_font).stringWidth(label);
		this.pos_x = GameFrame.WIDTH / 2 - width / 2;
		this.pos_y = pos_y;
	}

	void setPos(Button button) {
		setPos(button.getPosX(), button.getPosY());
		this.command = button.getCommand();
	}

	void setPos(int pos_x, int pos_y) {
		this.pos_x = pos_x - 2 * width;
		this.pos_y = pos_y - height / 4;
	}

	void render(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(GameFrame.menu_font);
		graphics.drawString(label, pos_x, pos_y + height);
	}

}
