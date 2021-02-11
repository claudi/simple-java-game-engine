package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract public class Player extends Entity implements KeyListener {
	abstract void moveLeftCommand();
	abstract void moveRightCommand();
	abstract void shootCommand();

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			moveLeftCommand();
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_RIGHT:
			moveRightCommand();
			break;
		case KeyEvent.VK_SPACE:
			shootCommand();
		default:
				break;
		}
	}
}
