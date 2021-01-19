package game;

import java.awt.Color;

public class Bullet extends Sprite {
	static int count = 0;
    public static int width = 3;
    public static int height = 12;
    static final Color color = Color.WHITE;

	static boolean pixel_array[][] = {
			{true},
			{true},
			{true},
			{true},
			{true}
	};

    public Bullet(int pos_x, int pos_y) {
    	super(pixel_array, pos_x, pos_y, color);
    	this.pos_x = pos_x;
    	this.pos_y = pos_y;
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
