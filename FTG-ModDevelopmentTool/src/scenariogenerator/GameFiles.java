package scenariogenerator;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GameFiles {

	static String gamePath;

	public GameFiles(String path) {
		gamePath = path;
	}

	public static HashMap<Color, Integer> loadMap(String path)
			throws IOException, InterruptedException {
		HashMap<Color, Integer> map = new HashMap<Color, Integer>();
		FileReader r = new FileReader(new File(path));
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

	public String[] loadCultures() throws IOException {
		int length = 0;

		FileReader r = new FileReader(new File(gamePath + "Db\\cultures.txt"));
		BufferedReader br = new BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				length++;
			}
		br.close();
		r.close();
		r = null;
		br = null;
		r = new FileReader(new File(gamePath + "Db\\cultures.txt"));
		br = new BufferedReader(r);
		String[] cultures = new String[length];
		int i = 0;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				System.out.println(line);
				String line2 = line.substring(0, line.indexOf("="));
				System.out.println(line2);
				String line3 = line2.trim();
				System.out.println(line3);
				cultures[i] = line3;
				i++;
			}
		br.close();

		return cultures;

	}

	public static String[] loadGoods() throws IOException {
		int length = 0;

		FileReader r = new FileReader(new File(gamePath + "Db\\goods.txt"));
		BufferedReader br = new BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				length++;
			}
		br.close();
		r.close();
		r = null;
		br = null;
		r = new FileReader(new File(gamePath + "Db\\goods.txt"));
		br = new BufferedReader(r);
		String[] cultures = new String[length];
		int i = 0;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				System.out.println(line);
				String line2 = line.substring(0, line.indexOf("="));
				System.out.println(line2);
				String line3 = line2.trim();
				System.out.println(line3);
				cultures[i] = line3;
				i++;
			}
		br.close();

		return cultures;

	}

	public static String[] loadReligions() throws IOException {
		int length = 0;

		FileReader r = new FileReader(new File(gamePath
				+ "Db\\Religions\\religions.txt"));
		BufferedReader br = new BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{") && !line.contains("heretic")
					&& !line.contains("allowed_conversion")
					&& !line.contains("conflict")
					&& !line.contains("aggressiveness")
					&& !line.contains("income_bonus") && !line.contains("war")) {
				length++;
			}
		br.close();
		r.close();
		r = null;
		br = null;
		r = new FileReader(new File(gamePath + "Db\\Religions\\religions.txt"));
		br = new BufferedReader(r);
		String[] cultures = new String[length];
		int i = 0;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{") && !line.contains("heretic")
					&& !line.contains("allowed_conversion")
					&& !line.contains("conflict")
					&& !line.contains("aggressiveness")
					&& !line.contains("income_bonus") && !line.contains("war")) {
				System.out.println(line);
				String line2 = line.substring(0, line.indexOf("="));
				System.out.println(line2);
				String line3 = line2.trim();
				System.out.println(line3);
				cultures[i] = line3;
				i++;
			}
		br.close();

		return cultures;

	}

	public static String[] loadTerrains() throws IOException {
		int length = 0;

		FileReader r = new FileReader(new File(gamePath
				+ "Db\\Map\\terrains.txt"));
		BufferedReader br = new BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				length++;
			}
		br.close();
		r.close();
		r = null;
		br = null;
		r = new FileReader(new File(gamePath + "Db\\Map\\terrains.txt"));
		br = new BufferedReader(r);
		String[] cultures = new String[length];
		int i = 0;
		while ((line = br.readLine()) != null)
			if (line.endsWith("{")) {
				System.out.println(line);
				String line2 = line.substring(0, line.indexOf("="));
				System.out.println(line2);
				String line3 = line2.trim();
				System.out.println(line3);
				cultures[i] = line3;
				i++;
			}
		br.close();

		return cultures;

	}
}
