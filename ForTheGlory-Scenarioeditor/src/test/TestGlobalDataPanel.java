package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import scenarioeditor.GameFiles;
import scenarioeditor.GlobalDataPanel;

public class TestGlobalDataPanel {

	public TestGlobalDataPanel() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String[]> map2 = new HashMap<String, String[]>();
		String[] climate = { "arctic", "tropical", "temperate", "ncontinental",
				"scontinental", "tundra", "desertic" };
		GameFiles game = new GameFiles(
				"C:\\Program Files (x86)\\Steam\\SteamApps\\common\\For The Glory\\");
		map2.put("continent", GameFiles.loadTags("continent"));
		map2.put("area", GameFiles.loadTags("area"));
		map2.put("region", GameFiles.loadTags("region"));

		map.put("id", "1");
		map.put("name", "Test");
		map.put("manpower", "1444555");
		map.put("income", "245");
		map.put("value", "0");
		map.put("cotmodifier", "0");
		map.put("colonizationdifficulty", "0");
		map.put("lootedYear", "0");
		map.put("religion", "hussite");
		map.put("terrain", "plains");
		map.put("culture", "abenaki");
		map.put("climate", "arctic");
		map.put("goods", "cloth");
		map.put("looted", "true");
		map.put("whiteman", "true");
		JFrame frame = new JFrame("Global Scenario Panel");
		frame.add(new GlobalDataPanel(map, map2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
