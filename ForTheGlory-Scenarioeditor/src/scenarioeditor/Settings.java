package scenarioeditor;

import java.io.IOException;
import java.util.HashMap;

public class Settings {

	public static HashMap<String, Object> hashmap;

	public static HashMap<String, Object> getSettings(String gamepath,  String scenariofilepath)
			throws IOException {

		hashmap = new HashMap<String, Object>();
		String language = "German";
		//Language is the name of the folder in the Localisation folder.
		new SettingReader(gamepath, language, hashmap);
		return hashmap;
	}

	public static void putInHashMap(String key, Object value) {
		hashmap.put(key, value);

	}

}
