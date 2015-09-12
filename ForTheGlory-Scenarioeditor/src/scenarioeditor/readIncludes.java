package scenarioeditor;

import java.io.IOException;

public class readIncludes {
	public readIncludes(String gamepath) {
		String[] includes = new String[9999];

		for (int c = 0; c < includes.length; c++) {
			includes[c] = scenarioreader.include_array[c];
		}
		int i = 0;
		while (includes[i] != null) {
			try {
				new scenarioreader(gamepath + includes[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
