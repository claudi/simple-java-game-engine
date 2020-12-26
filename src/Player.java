import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class Player implements KeyListener {
    int pos_x, pos_y;
    boolean vb_l = false, vb_r = false;
    int v_l = 0, v_r = 0;
    static int v_increment = 10;
    int width = 30;
    int height = 10;

    public Player(int pos_x, int pos_y) {
        this.pos_x = pos_x - width/2;
        this.pos_y = pos_y;
    }

    void move() {
        if(pos_x < 0.85*GameFrame.WIDTH) {
            pos_x += v_r;
        }
        if(pos_x > 0.15*GameFrame.WIDTH) {
            pos_x += v_l;
        }
    }

    void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(pos_x, pos_y, width, height);
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == ' ') {
            System.out.println("piu piu");
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) {
            vb_l = false;
            v_l -= -v_increment;
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            vb_r = false;
            v_r -= v_increment;
        }
    }

    public void keyPressed(KeyEvent e) {
        if(!vb_l && (e.getKeyCode() == KeyEvent.VK_A)) {
            vb_l = true;
            v_l += -v_increment;
        } else if(!vb_r && (e.getKeyCode() == KeyEvent.VK_D)) {
            vb_r = true;
            v_r += v_increment;
        }
    }
}

