package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.SaveSettings;
import scenarioeditor.Settings;

public class WriterMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		HashMap<String, Object> hash;
		hash = new HashMap<String, Object>();

		scenarioeditor.Settings.getSettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
				"German",
				"C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg");
		hash = Settings.hashmap;

		// System.out.println(((HashMap<String, Object>) ((HashMap<String,
		// Object>) hash.get("localisationdata")).get("USA")).get("name"));

		// System.out.println(((HashMap<String, Object>) ((HashMap<String,
		// Object>) hash.get("scenariodata")).get("header")).get("startyear"));
		// System.out.println("----------------------------");
		// for (String key : ((HashMap<String, Object>)
		// hash.get("localisationdata")).keySet()) {
		// // System.out.println(key + ((HashMap<String, Object>)
		// // ((HashMap<String, Object>)
		// // hash.get("provincedata")).get(key)).get("city"));
		// System.out.println(key);
		// }

		// new SaveSettings(hash);

	}

}
