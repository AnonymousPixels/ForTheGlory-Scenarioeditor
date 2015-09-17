package test;

import java.io.IOException;
import java.util.HashMap;

import scenarioeditor.settingreader;
import scenarioeditor.settings;

public class ReaderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash;
		try {
			new settingreader("C://Program Files (x86)//Steam//steamapps//common//For The Glory");
			
//			hash = scenarioeditor.settings.getsettings("C://Program Files (x86)//Steam//steamapps//common//For The Glory",
//					"C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
