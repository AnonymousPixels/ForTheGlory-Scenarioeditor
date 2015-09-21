package scenarioeditor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class SaveSettings {

	public static FileWriter file;
	public static BufferedWriter writer;

	public SaveSettings(HashMap<String, Object> settings, String countryfilepath)
			throws IOException {
		SaveCountries(settings, countryfilepath);

	}

	@SuppressWarnings("unchecked")
	public void SaveCountries(HashMap<String, Object> settings,
			String countryfilepath) throws IOException {
		file = new FileWriter(countryfilepath);
		writer = new BufferedWriter(file);
		String allcountrynames = "";
		String[] countries;
		writer.write("#Countryfile created with the FTG Scenarioeditor from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\n");

		@SuppressWarnings("unchecked")
		Set<String> keys = ((HashMap<String, Object>) settings.get("countrydata")).keySet();

		for (String key : keys) {

			if (key != "" || key != null || key != "\n") {
				allcountrynames = allcountrynames + "," + key;
			}
			

		}
		allcountrynames = allcountrynames.replaceAll(",,", "");
		
		
		countries = allcountrynames.split(",");
		
		for(int i = 0;i < countries.length;i++){
			
			writer.write(countries[i] + "= {" + "\n");
			writer.write("\tpicture = \"" + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("picture") + "\"\n");
			writer.write("\tcolor = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("color") + "\n");
			writer.write("\ttechgroup = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("techgroup") + "\n");
			writer.write("\tleader_language = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("leader_language") + "\n");
			writer.write("\tnew_colony = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("new_colony") + "\n");
			writer.write("\tpicture = \"" + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("picture") + "\"\n");
			writer.write("\tgfx = {\n");
			
			writer.write("\t\tarmy  = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("army") + "\n");
			writer.write("\t\tnavy = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("navy") + "\n");
			writer.write("\t}\n");
			writer.write("\tpolicy = {\n");
			
			writer.write("\t\taristocracy = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("aristocracy") + "\n");
			writer.write("\t\tcentralization = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("centralization") + "\n");
			writer.write("\t\tinnovative = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("innovative") + "\n");
			writer.write("\t\tmercantilism = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("mercantilism") + "\n");
			writer.write("\t\toffensive = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("offensive") + "\n");
			writer.write("\t\tland = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("land") + "\n");
			writer.write("\t\tquality = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("quality") + "\n");
			writer.write("\t\tserfdom = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("serfdom") + "\n");
			writer.write("\t}\n");
			
			
			writer.write("\telector = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("elector") + "\n");
			writer.write("\thistory = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata")).get(countries[i])).get("history") + "\n");
			writer.write("}\n\n");
		}

		

		writer.close();
	}

}
