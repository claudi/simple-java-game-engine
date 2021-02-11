package spaceInvaders;

import java.awt.Color;

import engine.Game;
import engine.Player;
import game.Bullet;

public class Jugador extends Player {
	private boolean vb_l = false, vb_r = false;
	private int bullet_cooldown_count = 0;
	private static int bullet_cooldown = 5;
	private int v_l = 0, v_r = 0;
	private int v_increment = 10;
	static Color[][] pixel_array = Game.sprites("player_sprite");
	
	public Jugador(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	protected void moveLeftCommand(boolean status) {
		if(status && !vb_l) {
			vb_l = true;
			v_l += -v_increment;
		} else if(!status && vb_l) {
			vb_l = false;
			v_l -= -v_increment;
		}
	}

	protected void moveRightCommand(boolean status) {
		if(status && !vb_r) {
			vb_r = true;
			v_r += v_increment;
		} else if(!status && vb_r) {
			vb_r = false;
			v_r -= v_increment;
		}
	}

	protected void shootCommand() {
		if (bullet_cooldown_count == 0) {
			bullet_cooldown_count = bullet_cooldown;
		}
	}

	public void move() {
		if (!outOfBoundsRight()) {
			super.move(v_r, 0);
		}
		if (!outOfBoundsLeft()) {
			super.move(v_l, 0);
		}
	}
	
	public void endFrame() {
		
	}
}
