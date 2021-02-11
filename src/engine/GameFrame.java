package engine;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

class GameFrame extends Frame implements WindowListener {
	private static final long serialVersionUID = -1535544953097598745L;
	private Image image;
	Graphics graphics;
	private BufferedImage background;
	private int defaultHEIGHT = 1280, defaultWIDTH = 720;

	GameFrame(String name) {
		super(name);
		initGameFrame(defaultHEIGHT, defaultWIDTH);
	}

	GameFrame(String name, int width, int height) {
		super(name);
		initGameFrame(width, height);
	}

	private void initGameFrame(int width, int height) {
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		addWindowListener(this);

		image = createImage(width, height);
		graphics = image.getGraphics();
		background = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	public void render() {
		graphics.drawImage(background, 0, 0, null);
	}

	public void paint(Graphics graphics) {
		graphics.drawImage(image, 0, 0, null);
	}

	public void update(Graphics graphics) {
		paint(graphics);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}
}
