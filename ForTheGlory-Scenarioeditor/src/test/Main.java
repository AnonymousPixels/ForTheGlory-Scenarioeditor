package test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import scenarioeditor.GameFiles;
import scenarioeditor.MapPanel;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		BufferedImage img = null;
		try {
			img = ImageIO
					.read(new File(
							"C:\\Users\\Maximilian\\GitHub\\FTG-ModDevelopmentTool\\FTG-ModDevelopmentTool\\src\\scenariogenerator\\frontend.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage img2 = null;

		try {
			img2 = ImageIO
					.read(new File(
							"C:\\Users\\Maximilian\\GitHub\\FTG-ModDevelopmentTool\\FTG-ModDevelopmentTool\\src\\scenariogenerator\\backend.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Images loaded");
		GameFiles game = new GameFiles(
				"C:\\Program Files (x86)\\Steam\\SteamApps\\common\\For The Glory");
		MapPanel map = new MapPanel(
				img,
				img2,
				game.loadMap("C:\\Users\\Maximilian\\GitHub\\FTG-ModDevelopmentTool\\FTG-ModDevelopmentTool\\src\\scenariogenerator\\MapConfigurationFile.txt"));
		JFrame frame = new JFrame("Test MapPanel");
		frame.setBounds(10, 10, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(map);

	}

}
