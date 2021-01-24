package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(Color.WHITE);
		g2.setFont(GameFrame.font);
		g2.drawString("SCORE: " + String.valueOf(enemies_hit + bullets_hit + bullets_intercepted), 10, 40);
	}
}
