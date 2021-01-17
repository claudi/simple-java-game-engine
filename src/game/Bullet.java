package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Entity {
	private static final long serialVersionUID = -7723108563984648507L;
	static int count = 0;
    public static int width = 3;
    public static int height = 12;

    public Bullet(Player player) {
    	super(player.x, player.y);
        count++;
    }

    void move(int v) {
        y += v;
    }

    void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x - width/2, y, width, height);
    }
}
