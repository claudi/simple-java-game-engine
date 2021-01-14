package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
    static int count = 0;
    int pos_x, pos_y;
    public static int width = 3;
    public static int height = 12;
    static int v = 12;

    public Bullet(Player player) {
        this.pos_x = player.pos_x;
        this.pos_y = player.pos_y;
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
