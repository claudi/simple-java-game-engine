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
        //System.out.println("Pause");
    }
    public void windowActivated(WindowEvent e) {
        active = true;
        //System.out.println("Unpause");
    }
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
}

