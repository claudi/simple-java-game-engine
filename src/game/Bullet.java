package game;

import java.awt.Color;

public class Bullet extends Sprite {
	static int count = 0;
    public static int width = 3;
    public static int height = 12;
    private final Color color = Color.WHITE;

    public Bullet(int pos_x, int pos_y) {
    	this.pos_x = pos_x;
    	this.pos_y = pos_y;
    	pixels.add(new Pixel(pos_x, pos_y, color));
    	count++;
    }

    void move(int v) {
        super.move(0, v);
    }

    public boolean outOfBounds() {
    	if(pos_y <= 0) {
    		return true;
    	}
    	return false;
    }
}
