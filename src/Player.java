import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class Player implements KeyListener {
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

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        System.out.println("Key pressed - Player");
    }
}

