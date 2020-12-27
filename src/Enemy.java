import java.awt.Graphics;
import java.awt.Color;

public class Enemy {
    static int count = 0;
    int pos_x, pos_y;
    public static int width = 30;
    public static int height = 20;

    public Enemy(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        count++;
    }

    protected void finalize() {
        count--;
    }

    void move(int v) {
        pos_x += v;
    }

    void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(pos_x - width/2, pos_y, width, height);
    }
}

