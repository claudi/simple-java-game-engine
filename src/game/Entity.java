package game;

import java.awt.Rectangle;

public class Entity extends Rectangle {
	private static final long serialVersionUID = 5451297122160808705L;
	public static int width, height;
	
	public Entity(int x, int y) {
	    super(x, y, width, height);
	}
}
