package scenarioeditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.AbstractDocument.BranchElement;

import org.omg.CORBA.OMGVMCID;

public class SettingReader {
	public static BufferedReader reader;
	public static FileReader file;
	public static String input, line;
	public static int brackets, bracketposition, counter_country,
			counter_techgroups, counter_techspeed, counter_cultures,
			counter_cultures_city, counter_cultures_buildings,
			counter_cultures_color;
	public static String[] shortcountryname_array, cultures_array,
			cultures_city_array, cultures_color_array,
			cultures_buildings_array, techgroups_array, techspeed_array;

	public static String[] newcountry_array, picture_array, color_array,
			techgroup_array, leader_language_array, new_colony_array,
			army_array, navy_array, aristocracy_array, centralization_array,
			innovative_array, mercantilism_array, offensive_array, land_array,
			quality_array, serfdom_array, elector_array;

	public static HashMap<String, Object> provincesettinghashmap,
			provincehashmap, countryhashmap, countrysettinghashmap;

	public static String id, name, efficiency, tolerance, tp_negotiation,
			ferocity, combat, colonization_difficulty, continent, region, area,
			type, terrain, size_modifier, climate, religion, culture, manpower,
			income, goods, city_name, cot_modifier;
	public static String varification;

	// , String countryfilepath, String culturefilepath, String
	// techgroupfilepath, String provincefilepath, String armynamesfilepath

	public SettingReader(String gamepath) throws IOException {

		// getCountries(gamepath + "//Db//countries.txt");
		// getCountrySettings(gamepath + "//Db//countries.txt");
		getCountrySettingsNEW(gamepath + "//Db//countries.txt");
		// getCultures(gamepath + "//Db//cultures.txt");
		// getTechgroups(gamepath + "//Db//Technologies//techgroups.txt");

		// getProvinces(gamepath + "//Db//Map//provinces - kopie.txt");

		// getArmynames(gamepath + "//Db//armynames.txt");

	}

	public void getCountrySettings(String countryfilepath) throws IOException {

		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		input = "";
		counter_country = 1;
		bracketposition = 0;
		input = reader.readLine();

		newcountry_array = new String[9999];
		picture_array = new String[9999];
		color_array = new String[9999];
		techgroup_array = new String[9999];
		leader_language_array = new String[9999];
		new_colony_array = new String[9999];
		army_array = new String[9999];
		navy_array = new String[9999];
		aristocracy_array = new String[9999];
		centralization_array = new String[9999];
		innovative_array = new String[9999];
		mercantilism_array = new String[9999];
		offensive_array = new String[9999];
		land_array = new String[9999];
		quality_array = new String[9999];
		serfdom_array = new String[9999];
		elector_array = new String[9999];

		while (input != null) {
			if (input.contains("{")) {
				brackets++;

			}
			if (input.contains("}")) {
				brackets--;
			}
			System.out.println(input);
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");

			if (brackets == 1 && input.indexOf("=") == 3) {
				bracketposition = input.indexOf("=");
				input = input.substring(0, bracketposition);
				System.out.println("Country: " + input + " " + counter_country
						+ " " + bracketposition);
				newcountry_array[counter_country] = input;
				counter_country++;

			}
			if (input.contains("picture=")) {
				input = input.replaceAll("picture=", "");
				input = input.replaceAll("\"", "");
				picture_array[counter_country - 1] = input;
				// System.out.println("Picture: " + input + " "
				// + (counter_country-1));
			}
			if (input.contains("color=")) {
				input = input.replaceAll("color=", "");
				color_array[counter_country - 1] = input;
				// System.out.println("Color: " + input);
			}
			if (input.contains("techgroup=")) {
				input = input.replaceAll("techgroup=", "");
				techgroup_array[counter_country - 1] = input;
				// System.out.println("Techgroup: " + input);
			}
			if (input.contains("leader_language=")) {
				input = input.replaceAll("leader_language=", "");
				leader_language_array[counter_country - 1] = input;
				// System.out.println("Leader_language: " + input);
			}
			if (input.contains("new_colony=")) {
				input = input.replaceAll("new_colony=", "");
				new_colony_array[counter_country - 1] = input;
				// System.out.println("new_colony: " + input);
			}
			if (input.contains("army=")) {
				input = input.replaceAll("army=", "");
				army_array[counter_country - 1] = input;
				// System.out.println("army: " + input);
			}
			if (input.contains("navy=")) {
				input = input.replaceAll("navy=", "");
				navy_array[counter_country - 1] = input;
				// System.out.println("navy: " + input);
			}
			if (input.contains("aristocracy=")) {
				input = input.replaceAll("aristocracy=", "");
				aristocracy_array[counter_country - 1] = input;
				// System.out.println("aristocracy: " + input);
			}
			if (input.contains("centralization=")) {
				input = input.replaceAll("centralization=", "");
				centralization_array[counter_country - 1] = input;
				// System.out.println("centralization: " + input);
			}
			if (input.contains("innovative=")) {
				input = input.replaceAll("innovative=", "");
				innovative_array[counter_country - 1] = input;
				// System.out.println("innovative: " + input);
			}
			if (input.contains("mercantilism=")) {
				input = input.replaceAll("mercantilism=", "");
				mercantilism_array[counter_country - 1] = input;
				// System.out.println("mercantilism: " + input);
			}
			if (input.contains("offensive=")) {
				input = input.replaceAll("offensive=", "");
				offensive_array[counter_country - 1] = input;
				// System.out.println("offensive: " + input);
			}
			if (input.contains("land=")) {
				input = input.replaceAll("land=", "");
				land_array[counter_country - 1] = input;
				// System.out.println("land: " + input);
			}
			if (input.contains("quality=")) {
				input = input.replaceAll("quality=", "");
				quality_array[counter_country - 1] = input;
				// System.out.println("quality: " + input);
			}
			if (input.contains("serfdom=")) {
				input = input.replaceAll("serfdom=", "");
				serfdom_array[counter_country - 1] = input;
				// System.out.println("serfdom: " + input);
			}
			if (input.contains("elector=")) {
				input = input.replaceAll("elector=", "");
				elector_array[counter_country - 1] = input;
				// System.out.println("elector: " + input);
			}

			input = reader.readLine();

		}

		Settings.hashmap.put("country_list", newcountry_array);
		Settings.hashmap.put("country_picture", picture_array);
		Settings.hashmap.put("country_color", color_array);
		Settings.hashmap.put("country_techgroup", techgroup_array);
		Settings.hashmap.put("country_leader_language", leader_language_array);
		Settings.hashmap.put("country_new_colony", new_colony_array);
		Settings.hashmap.put("country_army", army_array);
		Settings.hashmap.put("country_navy", navy_array);
		Settings.hashmap.put("country_aristocracy", aristocracy_array);
		Settings.hashmap.put("country_centralization", centralization_array);
		Settings.hashmap.put("country_innovative", innovative_array);
		Settings.hashmap.put("country_mercantilism", mercantilism_array);
		Settings.hashmap.put("country_offensive_array", offensive_array);
		Settings.hashmap.put("countrylist_land_array", land_array);

	}

	public void getCountrySettingsNEW(String countryfilepath)
			throws IOException {
		countrysettinghashmap = new HashMap<String, Object>();
		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		input = "";
		id = "";
		line = "";
		varification = "";

		input = reader.readLine();
		while (input != null) {
			line = line + input + "\n";
			input = reader.readLine();
		}

		String[] lines = line.split("[\\r\\n]+");
		countryhashmap = new HashMap<String, Object>();
		for (String input : lines) {
			System.out.println(input);
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
			} else if ((input != null || input != "") && brackets == 1
					&& input.contains("={")) {
				varification = input.substring(0, 3);
				System.out.println("Varibla: " + varification);
			}
			String[] checkFor = { "picture", "color", "techgroup",
					"leader_language", "combat", "colonization_difficulty",
					"cot_modifier", "new_colony", "army", "navy",
					"aristocracy", "centralization", "innovative",
					"mercantilism", "offensive", "land", "serfdom", "quality",
					"elector", "history", "varification" };
			for (String s : checkFor) {

				if (input.contains(s)) {
					String property = input.replaceAll(s + "=", "");
					countryhashmap.put(s, property);
				}
			}
			if (brackets == 0) {
				System.out.println();
				countrysettinghashmap.put(varification, countryhashmap.clone());
			}
		}

		Iterator<Entry<String, Object>> it = countrysettinghashmap.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}

		Settings.putInHashMap("countrydata", countrysettinghashmap.clone());

	}

	// useless
	public void getCountries(String countryfilepath) throws IOException {

		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		counter_country = 0;
		input = "";
		shortcountryname_array = new String[9999];
		bracketposition = 0;

		input = reader.readLine();
		while (input != null) {
			if (input.contains("{")) {
				brackets++;

			}
			if (input.contains("}")) {
				brackets--;
			}

			if (brackets == 1 && input != null) {
				input = input.replace(" ", "");
				input = input.replace("	", "");
				input = input.replaceAll("\t", "");
				input = input.replaceAll("\n", "");
				input = input.replaceAll("\r", "");
				bracketposition = input.indexOf("={");
				if (bracketposition < 0) {
					bracketposition = 0;
				}
				input = input.substring(0, bracketposition);
				input = input.replace(" ", "");
				input = input.replace("history", "");
				if (input.length() == 3) {

					shortcountryname_array[counter_country] = input;
					counter_country++;
				}
			}

			input = reader.readLine();

		}

	}

	public void getCultures(String countryfilepath) throws IOException {

		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		counter_cultures = 0;
		counter_cultures_city = 0;
		counter_cultures_buildings = 0;
		counter_cultures_color = 0;
		input = "";
		cultures_array = new String[9999];
		cultures_city_array = new String[9999];
		cultures_color_array = new String[9999];
		cultures_buildings_array = new String[9999];

		bracketposition = 0;

		input = reader.readLine();
		while (input != null) {
			if (input.contains("{")) {
				brackets++;

			}
			if (input.contains("}")) {
				brackets--;
			}
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");
			if (brackets == 1 && input != null) {
				if (input.contains("={")) {
					input = input.replace("={", "");
					cultures_array[counter_cultures] = input;
					counter_cultures++;
				}

				if (input.contains("city=")) {
					input = input.replace("city=", "");
					cultures_city_array[counter_cultures] = input;
					counter_cultures_city++;
				}
				if (input.contains("buildings=")) {
					input = input.replace("buildings=", "");
					cultures_buildings_array[counter_cultures] = input;
					counter_cultures_buildings++;
				}
				if (input.contains("color=")) {
					input = input.replace("color=", "");
					cultures_color_array[counter_cultures] = input;
					counter_cultures_color++;
				}

			}

			input = reader.readLine();

		}

		Settings.hashmap.put("cultures_list", cultures_array);
		Settings.hashmap.put("cultures_city", cultures_city_array);
		Settings.hashmap.put("cultures_buildings", cultures_buildings_array);
		Settings.hashmap.put("cultures_color", cultures_color_array);

	}

	public void getTechgroups(String countryfilepath) throws IOException {

		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		counter_techgroups = 0;
		counter_techspeed = 0;
		input = "";
		techgroups_array = new String[9999];
		techspeed_array = new String[9999];
		bracketposition = 0;

		input = reader.readLine();
		while (input != null) {
			if (input.contains("{")) {
				brackets++;

			}
			if (input.contains("}")) {
				brackets--;
			}
			input = input.replaceAll(" ", "");
			input = input.replaceAll("	", "");

			if (brackets == 1 && input != null && input.contains("={")) {
				bracketposition = input.indexOf("={");
				if (bracketposition < 0) {
					bracketposition = 0;
				}
				input = input.substring(0, bracketposition);
				input = input.replace("={", "");
				techgroups_array[counter_techgroups] = input;
				counter_techgroups++;
			}
			if (brackets == 1 && input != null && input.contains("tech_speed=")) {
				input = input.replaceAll("tech_speed=", "");
				techspeed_array[counter_techspeed] = input;
				counter_techspeed++;
			}

			input = reader.readLine();
		}

		Settings.hashmap.put("techgroups_list", techgroups_array);
		Settings.hashmap.put("techgroups_speed", techspeed_array);
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
			line = line + input + "\n";
			input = reader.readLine();
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
			if (input.trim().charAt(0) == '#') {

			}
			String[] checkFor = { "tolerance", "tp_negotiation", "efficiency",
					"ferocity", "combat", "colonization_difficulty",
					"cot_modifier", "city_name", "goods", "income", "manpower",
					"culture", "religion", "climate", "size_modifier",
					"terrain", "type", "area", "region", "continent", "name",
					"id", "terrain1", "terrain2", "terrain3", "terrain4", };
			for (String s : checkFor) {

				if (input.contains(s)) {

					String property = input.replaceAll(s + "=", "");
					provincehashmap.put(s, property);
					if (s.contains("id"))
						id = property;
				}
			}
			if (brackets == 0) {
				provincesettinghashmap.put(id, provincehashmap.clone());
			}
		}
		// Iterator<Entry<String, Object>> it =
		// provincesettinghashmap.entrySet().iterator();
		// while (it.hasNext()) {
		// Map.Entry pair = (Map.Entry) it.next();
		// System.out.println(pair.getKey() + " = " + pair.getValue());
		// }

		// Settings.hashmap.put("provincedata", provincesettinghashmap.clone());
		Settings.putInHashMap("provincedata", provincesettinghashmap.clone());
	}

	public void getArmynames(String countryfilepath) throws IOException {

		file = new FileReader(countryfilepath);
		reader = new BufferedReader(file);
		counter_techgroups = 0;
		counter_techspeed = 0;
		input = "";
		techgroups_array = new String[9999];
		techspeed_array = new String[9999];
		bracketposition = 0;

		input = reader.readLine();
		while (input != null) {
			if (input.contains("{")) {
				brackets++;

			}
			if (input.contains("}")) {
				brackets--;
			}

			System.out.println(input);
			input = reader.readLine();
		}

	}
}
