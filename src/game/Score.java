package game;

public class Score {
	int enemies_hit;
	int bullets_hit;
	int bullets_missed;
	int bullets_itercepted;

	public Score() {
		enemies_hit = 0;
		bullets_hit = 0;
		bullets_missed = 0;
		bullets_itercepted = 0;
	}

	public void hitEnemy() {
		enemies_hit++;
		bullets_hit++;
	}

	public void hitBullet() {
		bullets_hit++;
		bullets_itercepted++;
	}

	public void missedBullet() {
		bullets_missed++;
	}
}
