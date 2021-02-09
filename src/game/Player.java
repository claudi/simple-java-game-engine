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
	private int bullet_cooldown_count = 0;
	private int bullet_speed = -30;
	static final Color color = Color.WHITE;
	static int bullet_cooldown = 5;
	private int nlives = 3;
	Sprite[] lives = new Sprite[nlives];
	Bullets bullets = new Bullets(bullet_speed);

	static Color pixel_array[][] = Game.sprites("player");
	static Color lives_array[][] = Game.sprites("player_lives");

	public Player(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		for (int i = 0; i < lives.length; i++) {
			lives[i] = new Sprite(lives_array, Pixel.width * (10 + (lives_array[0].length + 5) * i),
					GameFrame.HEIGHT - Pixel.height * 10);
		}
	}

	void move() {
		if (pos_x < 0.80 * GameFrame.WIDTH) {
			super.move(v_r, 0);
		}
		if (pos_x > 0.20 * GameFrame.WIDTH) {
			super.move(v_l, 0);
		}
		bullets.move();
	}

	void endFrame() {
		if (bullet_cooldown_count >= bullet_cooldown) {
			bullets.add(new Bullet(pos_x, pos_y));
		}
		if (bullet_cooldown_count > 0) {
			bullet_cooldown_count--;
		}
	}

	void hit() {
		nlives--;
	}

	public boolean isDead() {
		return nlives == 0;
	}

	public boolean isAlive() {
		return !isDead();
	}

	void render(Graphics graphics) {
		super.render(graphics);
		bullets.render(graphics);
		for (int i = 0; i < nlives; i++) {
			lives[i].render(graphics);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A && vb_l) {
			vb_l = false;
			v_l -= -v_increment;
		} else if (e.getKeyCode() == KeyEvent.VK_D && vb_r) {
			vb_r = false;
			v_r -= v_increment;
		}
	}

	public void keyPressed(KeyEvent e) {
		if (!vb_l && (e.getKeyCode() == KeyEvent.VK_A)) {
			vb_l = true;
			v_l += -v_increment;
		} else if (!vb_r && (e.getKeyCode() == KeyEvent.VK_D)) {
			vb_r = true;
			v_r += v_increment;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (bullet_cooldown_count == 0) {
				bullet_cooldown_count = bullet_cooldown;
			}
		}
	}
}
