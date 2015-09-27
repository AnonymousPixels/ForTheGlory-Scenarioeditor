/**
 * 
 */
package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import scenarioeditor.GameFiles;

/**
 * @author Maximilian
 *
 */
public class TestAffliliation {
	public static void main(String[] args) throws IOException {

		BufferedImage img = null;

		try {
			img = ImageIO
					.read(new File(
							"C:\\Users\\Maximilian\\GitHub\\ForTheGlory-Scenarioeditor\\ForTheGlory-Scenarioeditor\\res\\backend.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, Object> map = Settings
				.getSettings(
						"C:\\Program Files (x86)\\Steam\\SteamApps\\common\\For The Glory",
						"C:\\Program Files (x86)\\Steam\\steamapps\\common\\For The Glory\\Scenarios\\1419 - The Grand Campaign.eeg");

		GameFiles.loadAffilation(map, img);
	}
}
