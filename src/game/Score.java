package game;

import java.awt.Color;
import java.awt.Graphics;

public class Score {
	int enemies_hit;
	int bullets_hit;
	int bullets_missed;
	int bullets_intercepted;
	int deducted;
	int level;

	public Score() {
		enemies_hit = 0;
		bullets_hit = 0;
		bullets_missed = 0;
		bullets_intercepted = 0;
		deducted = 0;
		level = 1;
	}

	public int getScore() {
		return enemies_hit + bullets_hit + bullets_intercepted - deducted;
	}

	public boolean deductScore(int val) {
		if (getScore() < val) {
			return false;
		}
		this.deducted += val;
		return true;
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

	public void advanceLevel() {
		level++;
	}

	public void render(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(GameFrame.font);
		graphics.drawString("SCORE: " + String.valueOf(getScore()), 10, 40);
		graphics.drawString("LEVEL: " + String.valueOf(level), 10, 70);
	}
}
