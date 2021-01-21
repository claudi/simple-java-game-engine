package game;

import java.awt.Graphics;

public class Enemies extends Collection<Enemy> {
	int n, m;
	int pos_x = GameFrame.WIDTH/2, pos_y;
	public int width, height;
	int v = 3;

	Enemies(int n, int m) {
	    this.n = n;
	    this.m = m;

	    int enemy_width = Pixel.height * Enemy.pixel_array[0].length;
	    int enemy_height = Pixel.width * Enemy.pixel_array.length;

	    int pad_x = Math.round((float) 2*enemy_width);
	    int pad_y = Math.round((float) 1.5*enemy_height);

	    this.pos_y = pad_y;

	    width = pad_x*(n-1) + enemy_width;
	    height = pad_y*(n-1) + enemy_height;

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            elements.add(new Enemy(pos_x + enemy_width/2 + pad_x*i - width/2,
	                                  pos_y + pad_y*j));
	        }
	    }
	}
	
	void move() {
		for(Enemy enemy: elements) {
			if(enemy.pos_x - 3*enemy.width < 0 || enemy.pos_x + 3*enemy.width > GameFrame.WIDTH) {
				v = -v;
				break;
			}
		}

	    for(Enemy enemy: elements) {
	        enemy.move(v, 0);
	    }
	    pos_x += v;
	}

	void endFrame() {
		for(Enemy enemy: elements) {
			enemy.endFrame();
		}
	}

	void render(Graphics graphics) {
	    for(Enemy enemy: elements) {
	        enemy.render(graphics);
	    }
	}
}
