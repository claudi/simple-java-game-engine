package game;

import java.awt.Graphics;

class Enemies extends Collection<Enemy> {
	int n, m;
	int pos_x = GameFrame.WIDTH / 2, pos_y;
	public int width, height;
	int v = 3;
	private static int base_v = 2;
	private static int vertical_v = 5 * Pixel.height;
	private int bullet_speed = 12;
	Bullets bullets = new Bullets(bullet_speed);
	private int difficulty;

	Enemies(int n, int m, int level) {
		this.n = n;
		this.m = m;
		this.difficulty = 100 - 10 * level;
		if (this.difficulty <= 0) {
			this.difficulty = 10;
		}
		this.v = Enemies.base_v + level;
		if (this.v >= 10) {
			this.v = 10;
		}

		int enemy_width = Pixel.height * Enemy.pixel_array[0].length;
		int enemy_height = Pixel.width * Enemy.pixel_array.length;

		int pad_x = Math.round((float) 2 * enemy_width);
		int pad_y = Math.round((float) 1.5 * enemy_height);

		this.pos_y = pad_y;

		width = pad_x * (n - 1) + enemy_width;
		height = pad_y * (n - 1) + enemy_height;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				elements.add(new Enemy(pos_x + enemy_width / 2 + pad_x * i - width / 2, pos_y + pad_y * j));
			}
		}
	}

	void move() {
		bullets.move();
		int vertical_v = 0;

		for (Enemy enemy : elements) {
			if (enemy.pos_x - 4 * enemy.width < 0) {
				v = -v;
				vertical_v = Enemies.vertical_v;
				break;
			} else if (enemy.pos_x + 4 * enemy.width > GameFrame.WIDTH) {
				v = -v;
				break;
			}
		}

		for (Enemy enemy : elements) {
			enemy.move(v, vertical_v);
		}
		pos_x += v;
	}

	private boolean isLastInColumn(Enemy enemy) {
		for (Enemy other_enemy : elements) {
			if (other_enemy.pos_x == enemy.pos_x) {
				if (other_enemy.pos_y > enemy.pos_y) {
					return false;
				}
			}
		}
		return true;
	}

	void endFrame() {
		for (Enemy enemy : elements) {
			if (isLastInColumn(enemy) && GameFrame.random.nextInt(difficulty) == 0) {
				bullets.add(enemy.shoot());
			}
		}
		for (Enemy enemy : elements) {
			enemy.endFrame();
		}
	}

	void render(Graphics graphics) {
		bullets.render(graphics);
		for (Enemy enemy : elements) {
			enemy.render(graphics);
		}
	}
}
