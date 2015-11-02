package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.Settings;

public class WriterMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		HashMap<String, Object> hash;
		hash = new HashMap<String, Object>();

		scenarioeditor.Settings.getSettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
				"C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg");
		hash = Settings.hashmap;

		System.out.println(
				((HashMap<String, Object>) ((HashMap<String, Object>) hash.get("techgroupdata")).get("orthodox"))
						.get("tech_speed"));

		// for (String key : ((HashMap<String, Object>) ((HashMap<String,
		// Object>) hash.get("techgroupdata")).get("muslim")).keySet()) {
		// System.out.println(key);
		// }

		// new SaveSettings(hash, "C://Users//Johannes//Desktop//Text.txt",
		// "C://Users//Johannes//Desktop//Text.txt");

	}

}
