package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Entity {
    static int count = 0;
    public static int width = 3;
    public static int height = 12;
    static int v = 12;

    public Bullet(Player player) {
    	super(player.pos_x, player.pos_y);
        count++;
    }

    void move() {
        pos_y -= v;
    }

    void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(pos_x - width/2, pos_y, width, height);
    }
}
