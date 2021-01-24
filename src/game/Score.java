package game;

import java.awt.Graphics;

public class Score {
	int enemies_hit;
	int bullets_hit;
	int bullets_missed;
	int bullets_intercepted;

	public Score() {
		enemies_hit = 0;
		bullets_hit = 0;
		bullets_missed = 0;
		bullets_intercepted = 0;
	}

	public void hitEnemy() {
		enemies_hit++;
		bullets_hit++;
	}

	public void hitBullet() {
		bullets_hit++;
		bullets_intercepted++;
	}

	public void missedBullet() {
		bullets_missed++;
	}

	public void render(Graphics graphics) {
		System.out.println("Enemies killed: " + String.valueOf(enemies_hit));
		System.out.println("Bullets hit: " + String.valueOf(bullets_hit));
		System.out.println("Bullets missed: " + String.valueOf(bullets_missed));
		System.out.println("Bullets intercepted: " + String.valueOf(bullets_intercepted));
	}
}
