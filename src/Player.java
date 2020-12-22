import java.awt.Graphics;
import java.awt.Color;

public class Player {
    int pos_x, pos_y, v;
    int width = 30;
    int height = 10;

    public Player(int pos_x, int pos_y, int v) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.v = v;
    }

    void move() {
       if(Math.abs(GameFrame.WIDTH - pos_x) < 2*width || Math.abs(pos_x) < width) {
           v *= (-1);
       }
       pos_x += v;
    }

    void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(pos_x, pos_y, width, height);
        graphics.drawLine(pos_x + (int)(width * 0.75), pos_y, pos_x + (int)(width * 0.75), pos_y + height);
    }
}

