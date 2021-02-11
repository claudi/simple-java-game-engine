package engine;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Game {
	GameFrame frame;
	Player player;
	Enemies enemies;
	
	public Game(String name) {
		frame = new GameFrame(name);
	}
	
	public Game(String name, int height, int width) {
		frame = new GameFrame(name, height, width);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setEnemies(Enemies enemies) {
		this.enemies = enemies;
	}
	
	public void setBackground(BufferedImage background) {
		frame.setBackground(background);
	}

	public int getWidth() {
		return frame.getWidth();
	}
	
	public int getHeight() {
		return frame.getHeight();
	}
	
	public static Color[][] sprites(String name) {
		int width, height, colours;
		String file = "./res/" + name + ".xpm";
		Color sprite[][] = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			String dims[] = line.split(" ");
			height = Integer.parseInt(dims[0]);
			width = Integer.parseInt(dims[1]);
			colours = Integer.parseInt(dims[2]);

			sprite = new Color[height][width];

			HashMap<Character, Color> colour = new HashMap<Character, Color>();
			colour.put(' ', null);
			for (int i = 0; i < colours; i++) {
				String[] colour_line = reader.readLine().split(" ");
				colour.put(colour_line[0].charAt(0), new Color(Integer.parseInt(colour_line[1]),
						Integer.parseInt(colour_line[2]), Integer.parseInt(colour_line[3])));
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int c = reader.read();
					if (c == '\n') {
						c = reader.read();
					}
					sprite[i][j] = colour.get((char) c);
				}
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: file \"" + file + "\" not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: IOException");
			e.printStackTrace();
		}

		return sprite;
	}
}
