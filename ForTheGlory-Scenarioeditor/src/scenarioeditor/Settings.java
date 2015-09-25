package scenarioeditor;

import java.io.IOException;
import java.util.HashMap;

public class Settings {

	public static HashMap<String, Object> hashmap;

	public static HashMap<String, Object> getSettings(String gamepath,
			String scenariofilepath) throws IOException {

		hashmap = new HashMap<String, Object>();

		new SettingReader(gamepath);
		System.out.println(Main.getModFolderName());
		// new scenarioreader(scenariofilepath);
		// new readIncludes(gamepath);
		return hashmap;
	}

	public static void putInHashMap(String key, Object value) {
		hashmap.put(key, value);

	}

}
