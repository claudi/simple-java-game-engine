package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Menu implements KeyListener {
	Game game;
	private boolean inMenu = false;
	ArrayList<Button> buttons;

	public Menu(Game game) {
		this.game = game;
		this.inMenu = true;
		this.buttons = new ArrayList<Button>();
		this.buttons.add(new Button(30, 100, "New game", game.frame.graphics));
		this.buttons.add(new Button(30, 180, "Load game", game.frame.graphics));
		this.buttons.add(new Button(30, 260, "Leaderboard", game.frame.graphics));
		this.buttons.add(new Button(30, 340, "Exit", game.frame.graphics));
	}

	public boolean inMenu() {
		return inMenu;
	}

	public void render(Graphics graphics) {
		for(Button button: buttons) {
			button.render(graphics);
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				inMenu = false;
				break;
		}
	}
}
