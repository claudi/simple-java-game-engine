package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.ListIterator;

public class Shop implements KeyListener {
	Game game;
	private boolean inMenu = false;
	Cursor cursor;
	static Color cursor_array[][] = Game.sprites("cursor");
	LinkedList<Button> buttons;
	ListIterator<Button> button;
	boolean prevWasCalled = false, nextWasCalled = false;

	public Shop(Game game) {
		this.game = game;
		this.inMenu = true;
		this.buttons = new LinkedList<Button>();
		this.buttons.add(new Button(30, 100, "New game", Command.PLAYER_SPEED, game.frame.graphics));
		this.buttons.add(new Button(30, 180, "Load game", Command.BULLET_SPEED, game.frame.graphics));
		this.buttons.add(new Button(30, 260, "Leaderboard", Command.EXTRA_LIVE, game.frame.graphics));
		this.buttons.add(new Button(30, 340, "Continue", Command.EXIT, game.frame.graphics));
		this.cursor = new Cursor(GameFrame.WIDTH, GameFrame.HEIGHT, game.frame.graphics);
		this.cursor.setPos(buttons.getFirst());
		this.button = buttons.listIterator();
		this.button.next();
	}

	public boolean inMenu() {
		return inMenu;
	}

	public void render(Graphics graphics) {
		cursor.render(graphics);
		for (Button button : buttons) {
			button.render(graphics);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_KP_DOWN:
			if (button.hasNext()) {
				System.out.println("Has next");
				if (prevWasCalled) {
					button.next();
				}
				cursor.setPos((Button) button.next());
				nextWasCalled = true;
				prevWasCalled = false;
			}
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
		case KeyEvent.VK_KP_UP:
			if (button.hasPrevious()) {
				System.out.println("Has previous");
				if (nextWasCalled) {
					button.previous();
				}
				cursor.setPos((Button) button.previous());
				nextWasCalled = false;
				prevWasCalled = true;
			}
			break;
		case KeyEvent.VK_ENTER:
			switch (cursor.command) {
			case PLAYER_SPEED:
				inMenu = false;
				break;
			case BULLET_SPEED:
				break;
			case EXTRA_LIVE:
				// game.player.nlives =+ 1;
				break;
			case EXIT:
				inMenu = false;
				break;
			default:
				break;
			}
			break;
		}
	}
}
