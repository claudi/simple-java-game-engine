import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Enemies {
    int n, m;
    int pad_x = 3*Enemy.width, pad_y = 2*Enemy.height;
    int pos_x = GameFrame.WIDTH/2, pos_y = pad_y;
    int width, height;
    int v = 3;
    ArrayList<Enemy> enemies;

    Enemies(int n, int m) {
        this.n = n;
        this.m = m;
        width = pad_x*(n-1) + Enemy.width;
        height = pad_y*(n-1) + Enemy.height;
        enemies = new ArrayList<Enemy>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                enemies.add(new Enemy(pos_x + Enemy.width/2 + pad_x*i - width/2,
                                      pos_y + pad_y*j));
            }
        }
    }

    void move() {
        if(pos_x - width/2 - pad_x < 0) {
            v = -v;
        } else if(pos_x + width/2 + pad_x > GameFrame.WIDTH) {
            v = -v;
        } else {
            v = v;
        }
        for(Enemy enemy: enemies) {
            enemy.move(v);
        }
        pos_x += v;
    }

    void render(Graphics graphics) {
        if(GameFrame.printGrid) {
            graphics.setColor(Color.YELLOW);
            graphics.drawLine(pad_x, 0, pad_x, GameFrame.HEIGHT);
            graphics.drawLine(GameFrame.WIDTH - pad_x, 0, GameFrame.WIDTH - pad_x, GameFrame.HEIGHT);
            graphics.drawLine(pos_x, 0, pos_x, GameFrame.HEIGHT);
        }
        for(Enemy enemy: enemies) {
            enemy.render(graphics);
        }
    }
}

