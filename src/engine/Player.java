package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract public class Player extends Entity implements KeyListener {
	abstract void moveLeft();
	abstract void moveRight();

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			moveLeft();
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_RIGHT:
			moveRight();
			break;
		default:
				break;
		}
	}
}
