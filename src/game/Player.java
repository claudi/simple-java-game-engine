package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
	boolean vb_l = false, vb_r = false;
	int v_l = 0, v_r = 0;
	static int v_increment = 10;
	static int width = 30, height = 10;
	private int bullet_speed = -12;
	Bullets bullets = new Bullets(bullet_speed);

	public Player(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	void move() {
	    if(x < 0.90*GameFrame.WIDTH) {
	        x += v_r;
	    }
	    if(x > 0.10*GameFrame.WIDTH) {
	        x += v_l;
	    }
	    bullets.move();
	}

	void render(Graphics graphics) {
	    graphics.setColor(Color.WHITE);
	    graphics.fillRect(x - width/2, y, width, height);
	    bullets.render(graphics);
	}

	public void keyTyped(KeyEvent e) {
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
	    } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	        bullets.add(new Bullet(this));
	    }
	}
}