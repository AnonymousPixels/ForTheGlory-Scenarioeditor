package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import scenarioeditor.GameFiles;
import scenarioeditor.IMapEventListener;
import scenarioeditor.MapPanel;

public class Main implements IMapEventListener {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		BufferedImage img = null;
		try {
			img = ImageIO
					.read(new File(
							"C:\\Users\\Maximilian\\GitHub\\ForTheGlory-Scenarioeditor\\ForTheGlory-Scenarioeditor\\res\\frontend.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage img2 = null;

		try {
			img2 = ImageIO
					.read(new File(
							"C:\\Users\\Maximilian\\GitHub\\ForTheGlory-Scenarioeditor\\ForTheGlory-Scenarioeditor\\res\\backend.png"));
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
				game.loadMap("C:\\Users\\Maximilian\\GitHub\\ForTheGlory-Scenarioeditor\\ForTheGlory-Scenarioeditor\\res\\affiliation.txt"));
		JFrame frame = new JFrame("Test MapPanel");
		frame.setBounds(10, 10, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(map);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see scenarioeditor.IMapEventListener#provinceClicked(java.lang.String)
	 */
	@Override
	public void provinceClicked(String id) {
		// TODO Auto-generated method stub

	}

}
