package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.SaveSettings;
import scenarioeditor.Settings;

public class WriterMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		HashMap<String, Object> hash = new HashMap<String, Object>();

		hash = scenarioeditor.Settings.getSettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
				"German", "1419 - The Grand Campaign.eeg");
//		hash = Settings.hashmap;

		// System.out.println(((HashMap<String, Object>) ((HashMap<String,
		// Object>) hash.get("localisationdata")).get("USA")).get("name"));

		System.out.println((HashMap<String, Object>) hash.get("culturedata"));
		System.out.println("----------------------------");
		for (String key : ((HashMap<String, Object>) hash.get("culturedata")).keySet()) {
			System.out.println(key + ((HashMap<String, Object>) ((HashMap<String, Object>) hash.get("culturedata")).get("culturedatatag")));

		}

		// new SaveSettings(hash);

	}

}
