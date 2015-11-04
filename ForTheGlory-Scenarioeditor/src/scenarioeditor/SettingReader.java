package scenarioeditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.IntPredicate;

public class SettingReader {
	public static BufferedReader reader;
	public static FileReader file;
	public static String input, line;
	public static int brackets, bracketposition, counter_country, counter_techgroups, counter_techspeed,
			counter_cultures, counter_cultures_city, counter_cultures_buildings, counter_cultures_color;

	public static HashMap<String, Object> provincesettinghashmap, provincehashmap, countryhashmap,
			countrysettinghashmap, countrynamehashmap, culturesettingshashmap, culturehashmap, techgroupsettingshashmap,
			techgrouphashmap,scenarioeeghashmap,scenariohashmap;

	public static String id, name, efficiency, tolerance, tp_negotiation, ferocity, combat, colonization_difficulty,
			continent, region, area, type, terrain, size_modifier, climate, religion, culture, manpower, income, goods,
			city_name, cot_modifier;
	public static String varification;

	public static String countryname, countrytag;

	public SettingReader(String gamepath, String language, HashMap<String, Object> hashmap, String scenariofilepath)
			throws IOException {

		
//		  getCountrySettings(gamepath + "//Db//countries.txt");
		  getProvinces(gamepath + "//Db//Map//provinces.txt"); //
//		  getProvinces2(gamepath + "//Db//Map//provinces.txt");
//		  getLocalisation(gamepath + "//Localisation//" + language +
//		  "//countries.csv", hashmap); getCultures(gamepath +
//		  "//Db//cultures.txt"); getTechgroups(gamepath +
//		  "//Db//Technologies//techgroups.txt");
		
		// USELESS
		// ===============================================
		// getArmynames(gamepath + "//Db//armynames.txt");

//		getScenario(scenariofilepath);

	}

	private void getScenario(String scenariofilepath) throws IOException {
		// TODO hashmap für jedes land, informationen in hashmap
		scenarioeeghashmap = new HashMap<String, Object>();
		scenariohashmap = new HashMap<String, Object>();
		file = new FileReader(scenariofilepath);
		reader = new BufferedReader(file);
		input = reader.readLine();
		line = "";

		while (input != null) {
			if (input.indexOf("#") != 1) {
				
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");
		
		for (String input : lines) {
			input = input.replaceAll("\t", "");
			input = input.replaceAll("\"", "");
			System.out.println(input);
			if ((input != null && input != "") && brackets == 0 && input.contains("= {")) {
				varification = input.substring(0, input.indexOf("= {"));
				System.out.println("varification: " + varification);
			}
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			if (input.trim().charAt(0) == '#') {
				
			}
			if (input.contains("history")) {
			}
			
			
			if(brackets >= 1){
				String[] checkFor = { "name", "startyear" ,  "endyear" , "startdate" , };
				for (String s : checkFor) {
					
					if (input.contains(s) && s != null) {

						String property = input.replaceAll(s + "=", "");
						scenariohashmap.put(s, property);

					}
				}
			}
			if (brackets == 0 && varification != null) {

				scenarioeeghashmap.put(varification, scenariohashmap.clone());

			}
		}
		
		
		Settings.putInHashMap("scenariodata", scenarioeeghashmap.clone());
		
//		getScenarioSettings();

	}

	private void getScenarioSettings() {
		// TODO Auto-generated method stub

	}

	public void getLocalisation(String localisationpath, HashMap<String, Object> hashmap) throws IOException {
		countrynamehashmap = new HashMap<String, Object>();
		countryhashmap = new HashMap<String, Object>();
		file = new FileReader(localisationpath);
		reader = new BufferedReader(file);
		input = reader.readLine();
		line = "";

		while (input != null) {
			if (input.indexOf("#") != 1) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");

		for (int i = 0; i < lines.length; i++) {
			if (!lines[i].contains("_DESC") && lines[i].charAt(0) != '#') {

				countrytag = lines[i].substring(0, 3);
				countryname = lines[i].substring(4, lines[i].lastIndexOf(";")).replaceAll(";", "");
				countryhashmap.put("name", countryname);
				countrynamehashmap.put(countrytag, countryhashmap.clone());

			}
		}

		Settings.hashmap.put("localisation", countrynamehashmap.clone());

	}

	public void getCountrySettings(String countryfilepath) throws IOException {
		countrysettinghashmap = new HashMap<String, Object>();
		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";
		varification = "";

		input = reader.readLine();
		while (input != null) {

			if (input.indexOf("#") != 1) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");
		countryhashmap = new HashMap<String, Object>();
		for (String input : lines) {
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			input = input.replaceAll("\"", "");
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			if (input.trim().charAt(0) == '#') {

			}
			if (input.contains("history")) {
			} else if ((input != null || input != "") && brackets == 1 && input.contains("={")) {
				varification = input.substring(0, 3);
			}
			String[] checkFor = { "picture", "color", "techgroup", "leader_language", "combat",
					"colonization_difficulty", "cot_modifier", "new_colony", "army", "navy", "aristocracy",
					"centralization", "innovative", "mercantilism", "offensive", "land", "serfdom", "quality",
					"elector", "history", "varification" };
			for (String s : checkFor) {

				if (input.contains(s) && s != null) {
					String property = input.replaceAll(s + "=", "");
					countryhashmap.put(s, property);

				}
			}
			if (brackets == 0) {

				countrysettinghashmap.put(varification, countryhashmap.clone());

			}
		}

		// Iterator<Entry<String, Object>> it = countrysettinghashmap.entrySet()
		// .iterator();
		// while (it.hasNext()) {
		// Map.Entry pair = (Map.Entry) it.next();
		// System.out.println(pair.getKey() + " = " + pair.getValue());
		// }

		Settings.putInHashMap("countrydata", countrysettinghashmap.clone());

	}

	public void getCultures(String culturefilepath) throws IOException {

		culturesettingshashmap = new HashMap<String, Object>();
		file = new FileReader(culturefilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";
		varification = "";

		input = reader.readLine();
		while (input != null) {

			if (input.indexOf("#") != 1 || input.indexOf("#") != 0) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");
		culturehashmap = new HashMap<String, Object>();
		for (String input : lines) {
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			input = input.replaceAll("\"", "");
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			if (input.trim().charAt(0) == '#') {

			}
			if ((input != null || input != "") && brackets == 1 && input.contains("={")) {
				varification = input.substring(0, input.indexOf("="));
			}
			String[] checkFor = { "city", "buildings", "color" };
			for (String s : checkFor) {

				if (input.contains(s) && s != null) {
					String property = input.replaceAll(s + "=", "");
					culturehashmap.put(s, property);

				}
			}
			if (brackets == 0) {

				culturesettingshashmap.put(varification, culturehashmap.clone());

			}
		}

		Settings.putInHashMap("culturedata", culturesettingshashmap.clone());

	}

	public void getTechgroups(String techgroupfilepath) throws IOException {

		techgroupsettingshashmap = new HashMap<String, Object>();
		file = new FileReader(techgroupfilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";
		varification = "";

		input = reader.readLine();
		while (input != null) {

			if (input.indexOf("#") != 1 || input.indexOf("#") != 0) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");
		techgrouphashmap = new HashMap<String, Object>();
		for (String input : lines) {
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			input = input.replaceAll("\"", "");
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			if (input.trim().charAt(0) == '#') {

			}
			if ((input != null || input != "") && brackets == 1 && input.contains("={")) {
				varification = input.substring(0, input.indexOf("="));
			}
			String[] checkFor = { "tech_speed" };
			for (String s : checkFor) {

				if (input.contains(s) && s != null) {
					String property = input.replaceAll(s + "=", "");
					techgrouphashmap.put(s, property);

				}
			}
			if (brackets == 0) {

				techgroupsettingshashmap.put(varification, techgrouphashmap.clone());

			}
		}

		Settings.putInHashMap("techgroupdata", techgroupsettingshashmap.clone());
	}

	public void getProvinces(String countryfilepath) throws IOException {
		provincesettinghashmap = new HashMap<String, Object>();
		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";

		input = reader.readLine();
		while (input != null) {
			if (input.indexOf("#") != 1 || input.indexOf("#") != 0) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		System.out.println("Finish wwfawfihawfonlaf");
		
		String[] lines = line.split("[\\r\\n]+");
		provincehashmap = new HashMap<String, Object>();
		for (String input : lines) {

			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			input = input.replaceAll("\"", "");
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			if (input.trim().charAt(0) == '#') {

			}
			String[] checkFor = { "terrain", "sea_adjacency", "tolerance", "tp_negotiation", "efficiency", "ferocity",
					"combat", "colonization_difficulty", "cot_modifier", "city_name", "goods", "income", "manpower",
					"culture", "religion", "climate", "size_modifier", "terrain", "type", "area", "region", "continent",
					"name", "id", "terrain1", "city", "terrain2", "terrain3", "terrain4", "river" };
			for (String s : checkFor) {
				
				if (input.contains(s)) {
					String property = input.replaceAll(s + "=", "");
					
					
					provincehashmap.put(s, property);
					
					
					
					if (s.contains("id") && property.length() <= 4)
						id = property;

				}

			}
			if (brackets == 0) {
				provincesettinghashmap.put(id, provincehashmap.clone());
				provincehashmap.clear();
			}
		}
		Settings.putInHashMap("provincedata", provincesettinghashmap.clone());

	}

	public void getProvinces2(String countryfilepath) throws IOException {
		provincesettinghashmap = new HashMap<String, Object>();
		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";

		input = reader.readLine();
		while (input != null) {
			if (input.indexOf("#") != 1 || input.indexOf("#") != 0) {
				// System.out.println(input);
				line = line + input + "\n";
				input = reader.readLine();
			}
		}

		String[] lines = line.split("[\\r\\n]+");
		provincehashmap = new HashMap<String, Object>();
		for (String input : lines) {
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			input = input.replaceAll("\"", "");
			if (input.contains("{")) {
				brackets++;
			}
			if (input.contains("}")) {
				brackets--;
			}
			String[] checkFor = { "terrain", "sea_adjacency", "tolerance", "tp_negotiation", "efficiency", "ferocity",
					"combat", "colonization_difficulty", "cot_modifier", "city_name", "goods", "income", "manpower",
					"culture", "religion", "climate", "size_modifier", "terrain", "type", "area", "region", "continent",
					"name", "id", "terrain1", "city", "terrain2", "terrain3", "terrain4", "river" };

			for (String s : checkFor) {
				String newinput = "";
				if (input.indexOf("=") > 0) {
					newinput = input.substring(0, input.indexOf("="));
				}
				if (newinput.equals(s)) {

					String property = input.replaceAll(s + "=", "");
					System.out.println(id + " " + input);
					provincehashmap.put(s, property);
					if (s.contains("id") && property.length() <= 4) {
						id = property;
					}

				}

			}
			if (brackets == 0) {
				provincesettinghashmap.put(id, provincehashmap.clone());
			}
		}
		Settings.putInHashMap("provincedata", provincesettinghashmap.clone());

	}
}
