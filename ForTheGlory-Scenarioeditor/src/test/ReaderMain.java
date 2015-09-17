package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.Settings;

public class ReaderMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		HashMap<String, Object> hash;
		hash = new HashMap<String, Object>();

		Settings.getSettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
				"C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg");
				// new SettingReader("C://Program Files
				// (x86)//Steam//steamapps//common//For The Glory");

		// hash = scenarioeditor.settings.getsettings("C://Program Files
		// (x86)//Steam//steamapps//common//For The Glory",
		// "C://Program Files (x86)//Steam//steamapps//common//For The
		// Glory//Scenarios//1419 - The Grand Campaign.eeg");

	}
}
