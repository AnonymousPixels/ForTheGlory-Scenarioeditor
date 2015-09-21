package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.SaveSettings;
import scenarioeditor.Settings;

public class WriterMain {

	public static void main(String[] args) throws IOException {
		HashMap<String, Object> hash;
		hash = new HashMap<String, Object>();

		Settings.getSettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
				"C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg");
		hash = Settings.hashmap;
		
//		System.out.println(((HashMap<String, Object>) ((HashMap<String, Object>) hash.get("countrydata")).get("RAM")).get("offensive"));

		
		new SaveSettings(hash, "C://Users//Johannes//Desktop//Text.txt");

	}

}
