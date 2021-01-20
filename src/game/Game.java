package game;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    Player player;
    GameFrame frame;
    Enemies enemies;

    Game(GameFrame frame) {
        this.frame = frame;

        initEntities();
    }

    void run() {
        while(true) {
            if(frame.active) {
                makeMoves();
                detectCollisions();
                render();
                endFrame();
            }
            delay();
        }
    }

	void initEntities() {
        player = new Player(GameFrame.WIDTH/2,
                            GameFrame.HEIGHT - 5*Player.height);
        enemies = new Enemies(5, 5);
	}

	static Color[][] sprites(String name) {
		int width, height;
		String file = "./res/" + name + ".xpm";
		Color sprite[][] = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			String dims[] = line.split(" ");
			height = Integer.parseInt(dims[0]);
			width = Integer.parseInt(dims[1]);

			sprite = new Color[height][width];

			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					int c = reader.read();
					if(c == '\n') {
						c = reader.read();
					}
					if(c == 'X') {
						sprite[i][j] = Color.WHITE;
					} else {
						sprite[i][j] = null;
					}
				}
				System.out.println("");
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
    
	ArrayList<Bullet> dead_bullets = new ArrayList<Bullet>();
	ArrayList<Enemy> dead_enemies = new ArrayList<Enemy>();

    void detectCollisions() {
		for(Bullet bullet: player.bullets.bullets) {
			for(Enemy enemy: enemies.enemies) {
				if(bullet.collision(enemy)) {
					dead_bullets.add(bullet);
					dead_enemies.add(enemy);
				}
			}
		}

		for(Bullet bullet: dead_bullets) {
			player.bullets.bullets.remove(bullet);
		}
		for(Enemy enemy: dead_enemies) {
			enemies.enemies.remove(enemy);
		}

		dead_bullets.clear();
		dead_enemies.clear();
    }

    void render() {
        frame.render();
        player.render(frame.graphics);
        enemies.render(frame.graphics);
        frame.repaint();
    }

    void endFrame() {
		player.endFrame();
		enemies.endFrame();
    }

    void delay() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {}
    }
}
