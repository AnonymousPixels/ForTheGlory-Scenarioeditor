package scenarioeditor;

import java.io.IOException;
import java.util.HashMap;

public class settings {

	static HashMap<String, Object> hashmap;

	public static HashMap<String, Object> getsettings(String gamepath, String scenariofilepath) throws IOException {

		hashmap = new HashMap<String, Object>();

		new settingreader(gamepath);
//		new scenarioreader(scenariofilepath);
//		new readIncludes(gamepath);
		return hashmap;

	}

}
