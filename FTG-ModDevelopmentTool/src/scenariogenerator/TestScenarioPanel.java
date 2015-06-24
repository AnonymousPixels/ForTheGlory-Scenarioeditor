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
		map.put("id",  "1");
		map.put("name", "Test");
		map.put("manpower", "1444555");
		map.put("income", "245");
		JFrame frame = new JFrame();
		frame.add(new ColonyPanel(map));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
