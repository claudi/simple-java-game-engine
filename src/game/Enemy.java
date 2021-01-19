package game;

import java.awt.Color;

public class Enemy extends Sprite {
	static int count = 0;
	public static int width = 30;
	public static int height = 25;
	static final Color color = Color.WHITE;

	static boolean pixel_array[][] = {
			{false, false,  true, false, false, false, false,  true, false, false},
			{false, false, false,  true, false, false,  true, false, false, false},
			{false, false,  true,  true,  true,  true,  true,  true, false, false},
			{false,  true,  true, false,  true,  true, false,  true,  true, false},
			{ true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
			{ true, false,  true,  true,  true,  true,  true,  true, false,  true},
			{false, false, false,  true, false, false,  true, false, false, false},
			{false, false,  true, false, false, false, false,  true, false, false}
	};

	public Enemy(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y, color);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	    count++;
	}

	void endFrame() {}
}
