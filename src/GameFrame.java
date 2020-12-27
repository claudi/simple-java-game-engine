import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.*;

public class GameFrame extends Frame implements WindowListener {
    Game game;
    Image image;
    static int WIDTH = 800, HEIGHT = 600;
    Graphics graphics;
    Boolean active = false;
    public static Boolean printGrid = false; // DEBUG

    public static void main(String [] args) {
        new GameFrame();
    }

    GameFrame() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
        addWindowListener(this);

        image = createImage(WIDTH, HEIGHT);
        graphics = image.getGraphics();

        game = new Game(this);
        this.addKeyListener(game.player);
        game.run();
    }

    void render() {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        if(printGrid) { // DEBUG
            graphics.setColor(Color.DARK_GRAY);
            for(int i = 0; i < WIDTH; i += 5) {
                graphics.drawLine(i, 0, i, HEIGHT);
            }
            for(int i = 0; i < HEIGHT; i += 5) {
                graphics.drawLine(0, i, WIDTH, i);
            }
            graphics.setColor(Color.YELLOW);
            graphics.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
        }
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(image, 0, 0, null);
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void windowClosed(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing");
        System.exit(0);
    }
    public void windowDeactivated(WindowEvent e) {
        active = false;
    }
    public void windowActivated(WindowEvent e) {
        active = true;
    }
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
}

