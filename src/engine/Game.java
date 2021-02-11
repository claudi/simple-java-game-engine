package engine;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Game {
	GameFrame frame;
	Player player;
	Enemies enemies;
	
	public Game(String name) {
		frame = new GameFrame(name);
	}
	
	public Game(String name, int height, int width) {
		frame = new GameFrame(name, height, width);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setEnemies(Enemies enemies) {
		this.enemies = enemies;
	}
	
	public void setBackground(BufferedImage background) {
		frame.setBackground(background);
	}

	public int getWidth() {
		return frame.getWidth();
	}
	
	public int getHeight() {
		return frame.getHeight();
	}
	
	public void mainLoop() {
		frame.addKeyListener(player);
		
		while (!gameOver()) {
			if (frame.isActive()) {
				makeMoves();
				detectCollisions();
				render();
				endFrame();
			}
			delay();
		}

		if (player.isAlive()) { // Player win
			System.out.println("Player win");
		} else if (enemies.size() > 0) { // Enemies win
			quitGame();
		} else { // Tie
			quitGame();
		}
	}
	
	private void makeMoves() {
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
			} else {
				enemies_iterator = enemies.iterator();
				while (enemies_iterator.hasNext()) {
					Enemy enemy = enemies_iterator.next();

					if (bullet.collision(enemy)) {
						enemy.hit();
						bullets_iterator.remove();
						enemies_iterator.remove();
					}
				}
			}
		}
	}

	void render() {
		frame.render();
		player.render(frame.graphics);
		enemies.render(frame.graphics);
		frame.repaint();
	}

	void delay() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
	}

	void endFrame() {
		player.endFrame();
		enemies.endFrame();
	}

	boolean gameOver() {
		if ((enemies.bullets.size() == 0 && enemies.size() == 0) || player.isDead()) {
			return true;
		}
		return false;
	}

	public void quitGame() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	public static Color[][] sprites(String name) {
		int width, height, colours;
		String file = "./res/" + name + ".xpm";
		Color sprite[][] = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
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
}
