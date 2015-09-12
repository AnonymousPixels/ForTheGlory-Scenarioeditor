package scenarioeditor;

import java.io.IOException;
import java.util.HashMap;

public class settings {

	static HashMap<String, String[]> hashmap;

	public static HashMap<String, String[]> getsettings(String gamepath,
			String scenariofilepath) throws IOException {

		hashmap = new HashMap<String, String[]>();

		
		// new settingreader(gamepath)
		new scenarioreader(scenariofilepath);
		// new readIncludes(gamepath);
		return hashmap;

	}

}
