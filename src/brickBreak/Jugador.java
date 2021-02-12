package brickBreak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import engine.Bullet;
import engine.Game;
import engine.Player;

class Jugador extends Player {
	static Color[][] pixel_array = Game.sprites("player_brick_breaker");
	private boolean tilt_l = false, tilt_r = false;
	private double vtilt_l = 0f, vtilt_r = 0f;
	private double tilt_increment = 0.1;
	private boolean vb_l = false, vb_r = false;
	private int v_l = 0, v_r = 0;
	private int v_increment = 5;
	private double angle = -Math.PI / 3;
	private int bounds;
	private int lives = 3;

	public Jugador(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		bullets = new Bales();
	}

	public void setBounds(Game game) {
		this.bounds = game.getWidth();
	}

	public void move() {
		int pos_x = getPosX();
		int width = getWidth() / 2;
		if (pos_x + width < bounds) {
			super.move(v_r, 0);
		}
		if (pos_x - width > 0) {
			super.move(v_l, 0);
		}
		if (-angle < 0.9 * Math.PI) {
			angle += vtilt_l;
		}
		if (-angle > 0.1 * Math.PI) {
			angle += vtilt_r;
		}
		bullets.move(0, 0);
	}

	protected void tiltLeftCommand(boolean status) {
		if (status && !tilt_l) {
			tilt_l = true;
			vtilt_l += -tilt_increment;
		} else if (!status && tilt_l) {
			tilt_l = false;
			vtilt_l -= -tilt_increment;
		}
	}

	protected void tiltRightCommand(boolean status) {
		if (status && !tilt_r) {
			tilt_r = true;
			vtilt_r += tilt_increment;
		} else if (!status && tilt_r) {
			tilt_r = false;
			vtilt_r -= tilt_increment;
		}
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

	@Override
	protected void shootCommand() {
		if (bullets.size() == 0) {
			bullets.add(new Bala(getPosX(), getPosY() - Bala.getPixelHeight() * Bala.pixel_array.length - 1, angle));
		}
	}

	@Override
	public void hit() {
		lives--;
	}

	@Override
	public boolean isDead() {
		return lives == 0;
	}

	@Override
	public void endFrame() {
		for (Bullet bala : bullets) {
			bala.collision(this);
		}
	}

	public void render(Graphics graphics) {
		super.render(graphics);
		if (bullets.size() == 0) {
			int pos_x = getPosX();
			int pos_y = getPosY();
			graphics.drawLine(pos_x, pos_y, (int) Math.round(pos_x + 50 * Math.cos(angle)),
					(int) Math.round(pos_y + 50 * Math.sin(angle)));
		}
	}

	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:
			tiltLeftCommand(false);
			break;
		case KeyEvent.VK_E:
			tiltRightCommand(false);
			break;
		default:
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:
			tiltLeftCommand(true);
			break;
		case KeyEvent.VK_E:
			tiltRightCommand(true);
			break;
		default:
			break;
		}
	}
}
