package breakout;

import java.awt.Color;

import engine.Bullet;
import engine.Entity;
import engine.Game;

class Bala extends Bullet {
	private int v_x, v_y;
	static private int bounds_x, bounds_y;
	private int v_module;
	private boolean alive = true;
	static Color[][] pixel_array = Game.sprites("square");

	public Bala(int pos_x, int pos_y, double angle) {
		super(pixel_array, pos_x, pos_y);
		this.v_module = Math.min(getWidth(), getHeight()) - 1;
		this.v_x = ((int) Math.round(v_module * Math.cos(angle)));
		this.v_y = ((int) Math.round(v_module * Math.sin(angle)));
	}

	@Override
	public boolean collision(Entity block) {
		int this_pos_x = getPosX();
		int this_pos_y = getPosY();
		int this_width = getWidth();
		int this_height = getHeight();
		int block_pos_x = block.getPosX();
		int block_pos_y = block.getPosY();
		int block_width = block.getWidth();
		int block_height = block.getHeight();
		boolean leftLTright = this_pos_x - this_width / 2 <= block_pos_x + block_width / 2;
		boolean rightGTleft = this_pos_x + this_width / 2 >= block_pos_x - block_width / 2;
		boolean topLTbottom = this_pos_y <= block_pos_y + block_height;
		boolean bottomGTtop = this_pos_y + this_height >= block_pos_y;

		if (leftLTright && rightGTleft && topLTbottom && bottomGTtop) {

			// https://stackoverflow.com/a/13349505/8548820
			int b_collision = block_pos_y + block_height - this_pos_y;
			int t_collision = this_pos_y + this_height - block_pos_y;
			int l_collision = this_pos_x + this_width / 2 - (block_pos_x - block_width / 2);
			int r_collision = block_pos_x + block_width / 2 - (this_pos_x - this_width / 2);

			if (t_collision < b_collision && t_collision < l_collision && t_collision < r_collision) {
				// Top collision
				v_y *= -1;
			}
			if (b_collision < t_collision && b_collision < l_collision && b_collision < r_collision) {
				// Bottom collision
				v_y *= -1;
			}
			if (l_collision < r_collision && l_collision < t_collision && l_collision < b_collision) {
				// Left collision
				v_x *= -1;
			}
			if (r_collision < l_collision && r_collision < t_collision && r_collision < b_collision) {
				// Right collision
				v_x *= -1;
			}
			return true;
		}

		return false;
	}

	public void move(int dx, int dy) {
		super.move(v_x, v_y);
	}

	@Override
	public boolean outOfBounds() {
		int pos_x = getPosX();
		int pos_y = getPosY();
		if (pos_x < 0 || pos_x > bounds_x) {
			v_x *= -1;
		}
		if (pos_y < 0) {
			v_y *= -1;
		} else if (pos_y > bounds_y) {
			alive = false;
		}
		return pos_y > bounds_y;
	}

	@Override
	public void hit() {
	}

	@Override
	public boolean isDead() {
		return !alive;
	}

	@Override
	public void endFrame() {
		// TODO Auto-generated method stub

	}

	public static void setBounds(Game game) {
		Bala.bounds_x = game.getWidth();
		Bala.bounds_y = game.getHeight();
	}

}
