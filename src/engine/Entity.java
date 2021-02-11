package engine;

abstract public class Entity extends Sprite {
	public Entity(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
	}

	boolean collision(Entity entity) {
		for (Pixel pixel : elements) {
			if (pixel.collision(entity)) {
				return true;
			}
		}
		return false;
	}
	
	public abstract void endFrame();
}
