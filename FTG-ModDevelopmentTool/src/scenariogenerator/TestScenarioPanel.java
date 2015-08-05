package scenariogenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class TestScenarioPanel {

	public TestScenarioPanel() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String[]> map2 = new HashMap<String, String[]>();
		String[] climate = { "arctic", "tropical", "temperate", "ncontinental",
				"scontinental", "tundra", "desertic" };
		map2.put("terrain", LoadGameFiles.loadTerrainsFile());
		map2.put("climate", climate);
		map2.put("religion", LoadGameFiles.loadReligionsFile());
		map2.put("culture", LoadGameFiles.loadCulturesFile());
		map2.put("goods", LoadGameFiles.loadGoodsFile());

		map.put("id", "1");
		map.put("name", "Test");
		map.put("manpower", "1444555");
		map.put("income", "245");
		map.put("value", "0");
		map.put("cotmodifier", "0");
		map.put("colonizationdifficulty", "0");
		map.put("lootedYear", "0");
		JFrame frame = new JFrame();
		frame.add(new ColonyPanel(map, map2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
