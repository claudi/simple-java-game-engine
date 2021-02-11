package spaceInvaders;

import engine.Enemies;
import engine.Enemy;
import engine.Game;
import engine.Sprite;

public class Enemics extends Enemies {
	private int bounds;
	private int bullet_speed = 12;
	private int v = 3;

	public Enemics(int n, int m, int pos_x) {
		this.bullets = new Bales();
		int enemy_width = Sprite.getPixelWidth() * Enemic.pixel_array[0].length;
		int enemy_height = Sprite.getPixelHeight() * Enemic.pixel_array.length;

		int pad_x = Math.round((float) 2 * enemy_width);
		int pad_y = Math.round((float) 1.5 * enemy_height);

		int width = pad_x * (n - 1) + enemy_width;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				elements.add(new Enemic(pos_x + enemy_width / 2 + pad_x * i - width / 2, pad_y * (j + 1)));
			}
		}
	}

	public void setBounds(Game game) {
		this.bounds = game.getWidth();
	}

	public void move() {
		bullets.move(0, bullet_speed);

		for (Enemy enemy : elements) {
			int pos_x = enemy.getPosX();
			int width = enemy.getWidth();
			if (pos_x - 4 * width < 0) {
				v = -v;
				break;
			} else if (pos_x + 4 * width > bounds) {
				v = -v;
				break;
			}
		}

		for (Enemy enemy : elements) {
			enemy.move(v, 0);
		}
	}

	private boolean isLastInColumn(Enemy enemy) {
		int pos_x = enemy.getPosX();
		int pos_y = enemy.getPosY();
		for (Enemy other_enemy : elements) {
			int other_enemy_pos_x = other_enemy.getPosX();
			int other_enemy_pos_y = other_enemy.getPosY();
			if ((other_enemy_pos_x == pos_x) && (other_enemy_pos_y > pos_y)) {
				return false;
			}
		}
		return true;
	}

	public void endFrame() {
		for (Enemy enemy : elements) {
			if (isLastInColumn(enemy) && Main.random.nextInt(50) == 0) {
				bullets.add(enemy.shoot());
			}
		}
		for (Enemy enemy : elements) {
			enemy.endFrame();
		}
	}
}
