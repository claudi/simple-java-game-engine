package game;

import java.awt.Color;

public class Enemy extends Sprite {
	static int count = 0;
	public static int width = 30;
	public static int height = 25;
	static final Color color = Color.WHITE;

	static Color pixel_array[][] = {
			{null, null,  Color.WHITE, null, null, null, null,  Color.WHITE, null, null},
			{null, null, null,  Color.WHITE, null, null,  Color.WHITE, null, null, null},
			{null, null,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE, null, null},
			{null,  Color.WHITE,  Color.WHITE, null,  Color.WHITE,  Color.WHITE, null,  Color.WHITE,  Color.WHITE, null},
			{ Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE},
			{ Color.WHITE, null,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE,  Color.WHITE, null,  Color.WHITE},
			{null, null, null,  Color.WHITE, null, null,  Color.WHITE, null, null, null},
			{null, null,  Color.WHITE, null, null, null, null,  Color.WHITE, null, null}
	};

	public Enemy(int pos_x, int pos_y) {
		super(pixel_array, pos_x, pos_y);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	    count++;
	}

	void endFrame() {}
}
