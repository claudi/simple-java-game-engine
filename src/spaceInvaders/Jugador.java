package spaceInvaders;

import java.awt.Color;

import engine.Game;
import engine.Player;

public class Jugador extends Player {
	private boolean vb_l = false, vb_r = false;
	private int lives;
	private int bounds;
	private int bullet_cooldown_count = 0;
	private static int bullet_cooldown = 5;
	private static int bullet_speed = -30;
	private int v_l = 0, v_r = 0;
	private int v_increment = 10;
	static Color[][] pixel_array = Game.sprites("player");

	public Jugador(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.bullets = new Bales();
		this.lives = 3;
	}

	public boolean isDead() {
		return lives == 0;
	}

	protected void moveLeftCommand(boolean status) {
		if (status && !vb_l) {
			vb_l = true;
			v_l += -v_increment;
		} else if (!status && vb_l) {
			vb_l = false;
			v_l -= -v_increment;
		}
	}

	protected void moveRightCommand(boolean status) {
		if (status && !vb_r) {
			vb_r = true;
			v_r += v_increment;
		} else if (!status && vb_r) {
			vb_r = false;
			v_r -= v_increment;
		}
	}

	protected void shootCommand() {
		if (bullet_cooldown_count == 0) {
			bullet_cooldown_count = bullet_cooldown;
		}
	}

	public void setBounds(Game game) {
		this.bounds = game.getWidth();
	}

	public void move() {
		int pos_x = getPosX();
		if (pos_x < 0.8 * bounds) {
			super.move(v_r, 0);
		}
		if (pos_x > 0.2 * bounds) {
			super.move(v_l, 0);
		}
		bullets.move(0, bullet_speed);
	}

	public void endFrame() {
		if (bullet_cooldown_count >= bullet_cooldown) {
			bullets.add(new Bala(getPosX(), getPosY()));
		}
		if (bullet_cooldown_count > 0) {
			bullet_cooldown_count--;
		}
	}

	public void hit() {
		lives--;
	}
}
