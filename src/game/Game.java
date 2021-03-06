package game;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

class Game {
	Player player;
	GameFrame frame;
	Enemies enemies;
	Score score;
	Menu menu;

	Game(GameFrame frame) {
		this.frame = frame;
		this.score = new Score();
		this.menu = new Menu(this);
	}

	void run() {
		initEntities();

		frame.addKeyListener(menu);

		while (menu.inMenu()) {
			frame.render();
			menu.render(frame.graphics);
			frame.repaint();
			delay();
		}

		frame.removeKeyListener(menu);
		frame.addKeyListener(player);
		while (!gameOver()) {
			if (frame.active) {
				makeMoves();
				detectCollisions();
				render();
				endFrame();
			}
			delay();
		}

		if (player.isAlive()) { // Player win
			score.advanceLevel();
		} else if (enemies.size() > 0) { // Enemies win
			quitGame();
		} else { // Tie
			quitGame();
		}
	}

	void initEntities() {
		player = new Player(GameFrame.WIDTH / 2, GameFrame.HEIGHT - 8 * Player.height);
		enemies = new Enemies(5, 5, score.level);
	}

	boolean gameOver() {
		if ((enemies.bullets.size() == 0 && enemies.size() == 0) || player.isDead()) {
			return true;
		}
		return false;
	}

	static Color[][] sprites(String name) {
		int width, height, colours;
		InputStream file = Game.class.getResourceAsStream("/" + name + ".xpm");
		Color sprite[][] = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(file));
			String line = reader.readLine();

			String dims[] = line.split(" ");
			height = Integer.parseInt(dims[0]);
			width = Integer.parseInt(dims[1]);
			colours = Integer.parseInt(dims[2]);

			sprite = new Color[height][width];

			HashMap<Character, Color> colour = new HashMap<Character, Color>();
			colour.put(' ', null);
			for (int i = 0; i < colours; i++) {
				String[] colour_line = reader.readLine().split(" ");
				colour.put(colour_line[0].charAt(0), new Color(Integer.parseInt(colour_line[1]),
						Integer.parseInt(colour_line[2]), Integer.parseInt(colour_line[3])));
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int c = reader.read();
					if (c == '\n') {
						c = reader.read();
					}
					sprite[i][j] = colour.get((char) c);
				}
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: file \"" + file + "\" not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: IOException");
			e.printStackTrace();
		}

		return sprite;
	}

	void makeMoves() {
		player.move();
		enemies.move();
	}

	void detectCollisions() {
		Iterator<Bullet> bullets_iterator;
		Iterator<Bullet> enemies_bullets_iterator;
		Iterator<Enemy> enemies_iterator;

		bullets_iterator = player.bullets.iterator();
		while (bullets_iterator.hasNext()) {
			Bullet player_bullet = bullets_iterator.next();
			enemies_bullets_iterator = enemies.bullets.iterator();
			while (enemies_bullets_iterator.hasNext()) {
				Bullet enemy_bullet = enemies_bullets_iterator.next();
				if (player_bullet.collision(enemy_bullet)) {
					bullets_iterator.remove();
					enemies_bullets_iterator.remove();
					score.hitBullet();
					break;
				}
			}
		}

		enemies_bullets_iterator = enemies.bullets.iterator();
		while (enemies_bullets_iterator.hasNext()) {
			Bullet bullet = enemies_bullets_iterator.next();
			if (bullet.outOfBounds()) {
				enemies_bullets_iterator.remove();
			} else {
				if (bullet.collision(player)) {
					enemies_bullets_iterator.remove();
					player.hit();
				}
			}
		}

		bullets_iterator = player.bullets.iterator();
		while (bullets_iterator.hasNext()) {
			Bullet bullet = bullets_iterator.next();

			if (bullet.outOfBounds()) {
				bullets_iterator.remove();
				score.missedBullet();
			} else {
				enemies_iterator = enemies.iterator();
				while (enemies_iterator.hasNext()) {
					Enemy enemy = enemies_iterator.next();

					if (bullet.collision(enemy)) {
						enemy.hit();
						bullets_iterator.remove();
						enemies_iterator.remove();
						score.hitEnemy();
					}
				}
			}
		}
	}

	void render() {
		frame.render();
		player.render(frame.graphics);
		enemies.render(frame.graphics);
		score.render(frame.graphics);
		frame.repaint();
	}

	void endFrame() {
		player.endFrame();
		enemies.endFrame();
	}

	void delay() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
	}

	void quitGame() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
