package engine;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract public class Player extends Entity implements KeyListener {
	static Color[][] pixel_array;
	
	public Player(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}
	protected abstract void moveLeftCommand(boolean status);
	protected abstract void moveRightCommand(boolean status);
	protected abstract void shootCommand();

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
