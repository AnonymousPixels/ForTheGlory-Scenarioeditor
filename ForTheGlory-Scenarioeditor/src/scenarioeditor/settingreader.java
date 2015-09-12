package scenarioeditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class settingreader {
	public static BufferedReader reader;
	public static FileReader file;
	public static String input;
	public static int brackets, bracketposition, counter_country, counter_techgroups, counter_techspeed,
			counter_cultures, counter_cultures_city, counter_cultures_buildings, counter_cultures_color;
	public static String[] shortcountryname_array, cultures_array, cultures_city_array, cultures_color_array,
			cultures_buildings_array, techgroups_array, techspeed_array;

	public static String[] newcountry_array, picture_array, color_array, techgroup_array, leader_language_array,
			new_colony_array, army_array, navy_array, aristocracy_array, centralization_array, innovative_array,
			mercantilism_array, offensive_array, land_array, quality_array, serfdom_array, elector_array;

	public settingreader(String gamepath) {
		// Nur Coutries keine eigenschaften
		// getCountries(gamepath + "//Db//countries.txt");

		// Vollständig
		// getCountrySettings(gamepath + "//Db//countries.txt");

		// Vollständig
		// getCultures(gamepath + "//Db//cultures.txt");

		// Vollständig
		// getTechgroups(gamepath + "//Db//Technologies//techgroups.txt");

		// VIEL AUSZULESEN NICHT FERTIG
		getProvinces(gamepath + "//Db//Map//provinces.txt");

		// Nicht sicher mit einlesen
		// getArmynames(gamepath + "//Db//armynames.txt");

	}

	public void getCountrySettings(String countryfilepath) {
		try {
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
					System.out.println("Country: " + input + " " + counter_country + " " + bracketposition);
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

		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		settings.hashmap.put("country_list", newcountry_array);
		settings.hashmap.put("country_picture", picture_array);
		settings.hashmap.put("country_color", color_array);
		settings.hashmap.put("country_techgroup", techgroup_array);
		settings.hashmap.put("country_leader_language", leader_language_array);
		settings.hashmap.put("country_new_colony", new_colony_array);
		settings.hashmap.put("country_army", army_array);
		settings.hashmap.put("country_navy", navy_array);
		settings.hashmap.put("country_aristocracy", aristocracy_array);
		settings.hashmap.put("country_centralization", centralization_array);
		settings.hashmap.put("country_innovative", innovative_array);
		settings.hashmap.put("country_mercantilism", mercantilism_array);
		settings.hashmap.put("country_offensive_array", offensive_array);
		settings.hashmap.put("countrylist_land_array", land_array);

	}

	// useless
	public void getCountries(String countryfilepath) {
		try {
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
				System.out.println(input);
				input = reader.readLine();

			}

		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getCultures(String countryfilepath) {
		try {
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

		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		settings.hashmap.put("cultures_list", cultures_array);
		settings.hashmap.put("cultures_city", cultures_city_array);
		settings.hashmap.put("cultures_buildings", cultures_buildings_array);
		settings.hashmap.put("cultures_color", cultures_color_array);

	}

	public void getTechgroups(String countryfilepath) {
		try {
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

				System.out.println(input);
				input = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		settings.hashmap.put("techgroups_list", techgroups_array);
		settings.hashmap.put("techgroups_speed", techspeed_array);
	}

	public void getProvinces(String countryfilepath) {
		try {
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
		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getArmynames(String countryfilepath) {
		try {
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
		} catch (FileNotFoundException e) {
			System.out.println("Error, Can´t read File!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
