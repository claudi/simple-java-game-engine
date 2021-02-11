package engine;

public abstract class Enemy extends Entity {

	public Enemy(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	public abstract Bullet shoot();
	public abstract void hit();

}
