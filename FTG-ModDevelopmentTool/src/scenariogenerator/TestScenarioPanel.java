package scenariogenerator;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class TestScenarioPanel {

	public TestScenarioPanel() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String[]> map2 = new HashMap<String, String[]>();
		String[] test = { "test", "test2" };
		map2.put("type", test);
		map2.put("terrain", test);
		map2.put("climate", test);
		map2.put("religion", test);
		map2.put("culture", test);
		map2.put("goods", test);
		map2.put("lootedDay", test);
		map2.put("lootedMonth", test);

		map.put("id", "1");
		map.put("name", "Test");
		map.put("manpower", "1444555");
		map.put("income", "245");
		JFrame frame = new JFrame();
		frame.add(new ColonyPanel(map, map2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
