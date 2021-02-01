package game;

import java.awt.Color;
import java.awt.Graphics;

public class Button {
	int pos_x, pos_y;
	int width, height;
	String label;

	public Button(int pos_x, int pos_y, String label, Graphics graphics) {
		this.label = label.toUpperCase();
		this.height = graphics.getFontMetrics(GameFrame.menu_font).getAscent();
		this.width = graphics.getFontMetrics(GameFrame.menu_font).stringWidth(label);
		this.pos_x = GameFrame.WIDTH/2 - width/2;
		this.pos_y = pos_y;
	}

	void render(Graphics graphics) {
		//graphics.setColor(Color.WHITE);
		//graphics.fillRect(pos_x, pos_y, width, height);
		graphics.setColor(Color.WHITE);
		graphics.setFont(GameFrame.menu_font);
		graphics.drawString(label, pos_x, pos_y + height);
	}
}
