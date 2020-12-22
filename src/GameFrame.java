import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class GameFrame extends Frame {
    Game game;
    Image image;
    static int WIDTH = 800, HEIGHT = 600;
    Graphics graphics;

    public static void main(String [] args) {
        new GameFrame();
    }

    GameFrame() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);

        image = createImage(WIDTH, HEIGHT);
        graphics = image.getGraphics();

        game = new Game(this);
        game.run();
    }

    void render() {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(image, 0, 0, null);
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }
}

