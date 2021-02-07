package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameFrame extends Frame implements WindowListener {
	private static final long serialVersionUID = 1L;
	static Random random = new Random();
	Game game;
	Image image;
	BufferedImage background;
	static int WIDTH = 1280, HEIGHT = 720;
	Graphics graphics;
	Boolean active = false;
	public static Boolean printGrid = false; // DEBUG
	static Font font;
	static Font menu_font;

	public static void main(String[] args) {
		new GameFrame();
	}

	GameFrame() {
		super("Space Invaders");

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);
		addWindowListener(this);

		image = createImage(WIDTH, HEIGHT);
		background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (random.nextInt(500) == 0) {
					background.setRGB(i, j, Color.WHITE.getRGB());
				} else {
					background.setRGB(i, j, Color.BLACK.getRGB());
				}
			}
		}
		graphics = image.getGraphics();
		font = new Font(Font.MONOSPACED, Font.PLAIN, 24);
		menu_font = new Font(Font.MONOSPACED, Font.BOLD, 58);

		game = new Game(this);

		while (true) {
			game.run();
		}
	}

	void render() {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		graphics.drawImage(background, 0, 0, null);
		if (printGrid) { // DEBUG
			graphics.setColor(Color.DARK_GRAY);
			for (int i = 0; i < WIDTH; i += 5) {
				graphics.drawLine(i, 0, i, HEIGHT);
			}
			for (int i = 0; i < HEIGHT; i += 5) {
				graphics.drawLine(0, i, WIDTH, i);
			}
			graphics.setColor(Color.YELLOW);
			graphics.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
		}
	}

	public void paint(Graphics graphics) {
		graphics.drawImage(image, 0, 0, null);
	}

	public void update(Graphics graphics) {
		paint(graphics);
	}

	public void windowClosed(WindowEvent e) {
	}

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

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}
}
