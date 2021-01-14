package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Bullets {
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	int count = 0;
	int v;
	
	Bullets(int v) {
		this.v = v;
	}
	
	public boolean add(Bullet bullet) {
		boolean result = bullets.add(bullet);
		if(result) {
			this.count++;
		}
		return result; 
	}
	
	public void move() {
		for(Bullet bullet: bullets) {
			bullet.move(v);
		}
	}
	
	public void render(Graphics graphics) {
		for(Bullet bullet: bullets) {
			bullet.render(graphics);
		}
	}
}
