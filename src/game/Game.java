package game;

import java.awt.Color;
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

	static Color[][] sprites() {
		Color[][] pixel_array = new Color[][] {
			{null, null,  Color.WHITE, null, null, null, null,  Color.WHITE, null, null},
			{null, null, null,  Color.WHITE, null, null,  Color.WHITE, null, null, null},
			{null, null,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE, null, null},
			{null,  Color.WHITE,  Color.WHITE, null,  Color.WHITE,  Color.WHITE, null,  Color.WHITE,  Color.WHITE, null},
			{ Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE},
			{ Color.WHITE, null,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE, null,  Color.WHITE},
			{null, null, null,  Color.WHITE, null, null,  Color.WHITE, null, null, null},
			{null, null,  Color.WHITE, null, null, null, null,  Color.WHITE, null, null}
		};
		return pixel_array;
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
