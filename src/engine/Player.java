package engine;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract public class Player extends Entity implements KeyListener {
	private int bounds_x;
	static Color[][] pixel_array;
	
	public Player(int bounds_x, int bounds_y) {
		super(pixel_array, bounds_x / 2, (int) 0.8*bounds_y);
		this.bounds_x = bounds_x;
	}
	public abstract void move();
	protected abstract void moveLeftCommand(boolean status);
	protected abstract void moveRightCommand(boolean status);
	protected abstract void shootCommand();

	public boolean outOfBoundsLeft() {
		return getPosX() < 0.20 * bounds_x;
	}

	public boolean outOfBoundsRight() {
		return getPosX() > 0.80 * bounds_x;
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			moveLeftCommand(false);
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_RIGHT:
			moveRightCommand(false);
			break;
		default:
				break;
		}
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			moveLeftCommand(true);
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_RIGHT:
			moveRightCommand(true);
			break;
		case KeyEvent.VK_SPACE:
			shootCommand();
		default:
				break;
		}
	}
}
