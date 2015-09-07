package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import scenarioeditor.ColonyPanel;
import scenarioeditor.GameFiles;

public class TestScenarioPanel {


	public static void main(String[] args) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String[]> map2 = new HashMap<String, String[]>();
		String[] climate = { "arctic", "tropical", "temperate", "ncontinental",
				"scontinental", "tundra", "desertic" };
		GameFiles game = new GameFiles(
				"C:\\Program Files (x86)\\Steam\\SteamApps\\common\\For The Glory\\");
		map2.put("terrain", game.loadTerrains());
		map2.put("climate", climate);
		map2.put("religion", game.loadReligions());
		map2.put("culture", game.loadCultures());
		map2.put("goods", game.loadGoods());

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
		JFrame frame = new JFrame();
		frame.add(new ColonyPanel(map, map2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
