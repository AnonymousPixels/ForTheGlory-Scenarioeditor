package scenarioeditor;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoadMapFile {

	public static HashMap<Color, Integer> LoadFile(File f) throws IOException,
			InterruptedException {
		HashMap<Color, Integer> map = new HashMap<Color, Integer>();
		FileReader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null)
			if (line.startsWith("ID")) {
				String line2 = line.substring(9);
				String line3 = line2.substring(0, line2.indexOf(" "));
				System.out.println(line3);

				String line4 = line2.substring(line2.indexOf(" ",
						line2.indexOf(" ") + 1) + 1);
				String line5 = line4.substring(0, 6);
				System.out.println(line5);
				int zahl = Integer.parseInt(line5, 16);
				System.out.println(zahl);
				Color color = new Color(zahl);
				System.out.println(color.getRed());
				map.put(color, Integer.parseInt(line3));
			}
		br.close();
		return map;
	}
}
