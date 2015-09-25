package test;


import java.io.IOException;

import scenarioeditor.ScenarioReader;

public class ReadIncludes {
	public ReadIncludes(String gamepath) throws IOException {
		String[] includes = new String[9999];

		for (int c = 0; c < includes.length; c++) {
			includes[c] = ScenarioReader.include_array[c];
		}
		int i = 0;
		while (includes[i] != null) {

			new ScenarioReader(gamepath + includes[i]);

		}
	}
}
