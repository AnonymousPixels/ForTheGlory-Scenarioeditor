package scenarioeditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class scenarioreader {
	public static BufferedReader reader;
	public static FileReader file;
	public static String input, scenarioname, startdate, enddate,
			selectablestring;
	public static int counter_country, counter_include, bracket;
	public static String[] tag_array, ai_array, colonialattempts_array,
			colonialnation_array, major_array, colonists_array,
			merchants_array, treasury_array, inflation_array, whiteman_array,
			religion_array, culture_array, knownprovinces_array,
			controlledprovinces_array, nationalprovinces_array,
			city_name_array, ownedprovinces_array, city_fortress_array,
			city_population_array, city_location_array, city_capital_array,
			landunit_id_array, landunit_name_array, landunit_location_array,
			landunit_infantry_array, landunit_artillery_array,
			landunit_cavalry_array, technology_stability_array,
			technology_naval_array, technology_land_array,
			technology_infra_array, technology_trade_array, selectable_array,
			include_array, cancelledloans_array, extendedloans_array, diplomats_array, technology_group_array;

	public scenarioreader(String path) throws IOException {
		file = new FileReader(path);
		reader = new BufferedReader(file);
		tag_array = new String[9999];
		ai_array = new String[9999];
		colonialattempts_array = new String[9999];
		colonialnation_array = new String[9999];
		major_array = new String[9999];
		colonists_array = new String[9999];
		merchants_array = new String[9999];
		treasury_array = new String[9999];
		inflation_array = new String[9999];
		whiteman_array = new String[9999];
		religion_array = new String[9999];
		culture_array = new String[9999];
		knownprovinces_array = new String[9999];
		ownedprovinces_array = new String[9999];
		controlledprovinces_array = new String[9999];
		nationalprovinces_array = new String[9999];
		city_name_array = new String[9999];
		city_fortress_array = new String[9999];
		city_population_array = new String[9999];
		city_location_array = new String[9999];
		city_capital_array = new String[9999];
		landunit_id_array = new String[9999];
		landunit_name_array = new String[9999];
		landunit_location_array = new String[9999];
		landunit_infantry_array = new String[9999];
		landunit_artillery_array = new String[9999];
		landunit_cavalry_array = new String[9999];
		technology_stability_array = new String[9999];
		technology_infra_array = new String[9999];
		technology_trade_array = new String[9999];
		technology_land_array = new String[9999];
		technology_naval_array = new String[9999];
		selectable_array = new String[9999];
		include_array = new String[9999];
		cancelledloans_array = new String[9999];
		extendedloans_array = new String[9999];
		diplomats_array = new String[9999];
		technology_group_array = new String[9999];

		counter_include = 0;
		counter_country = 0;
		input = "";
		selectablestring = "";

		input = reader.readLine();
		while (input != null) {
			System.out.println(input);

			if (input.contains("name")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("name", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll("\"", "");
				System.out.println(input);
				scenarioname = input;
			}
			if (input.contains("startdate")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("startdate", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replace("{", "");
				input = input.replaceAll("}", "");
				input = input.replaceAll("day", "");
				input = input.replaceAll("month", ".");
				input = input.replaceAll("year", ".");
				System.out.println(input);
				startdate = input;
			}

			if (input.contains("enddate")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("enddate", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replace("{", "");
				input = input.replaceAll("}", "");
				input = input.replaceAll("day", "");
				input = input.replaceAll("month", ".");
				input = input.replaceAll("year", ".");
				System.out.println(input);
				enddate = input;
			}

			if (input.contains("selectable")) {

				while (!input.contains("}")) {
					input = reader.readLine();
					System.out.println(input);
					selectablestring = selectablestring + input;
				}
				selectablestring = selectablestring.replaceAll("		", "");
				selectablestring = selectablestring.replaceAll("	", "");
				selectablestring = selectablestring.replaceAll("}", "");
				System.out.println(selectablestring);
				selectable_array = selectablestring.split(" ");

			}
			if (input.contains("include")) {
				input = input.replaceAll("include", "");
				input = input.replaceAll("\"", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll("  ", "");
				input = input.replace("\\", "//");
				include_array[counter_include] = input;
				counter_include++;
				System.out.println(input);

			}

			if (input.replace(" ", "").contains("country={")) {
				counter_country++;
			}
			if (input.contains("tag")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("tag", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				tag_array[counter_country] = input;
			}
			if (input.contains("ai")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("ai=", "");
				input = input.replaceAll("	", "");
				System.out.println(input);
				ai_array[counter_country] = input;
			}
			if (input.contains("colonialattempts")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("colonialattempts", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				colonialattempts_array[counter_country] = input;

			}
			if (input.contains("colonialnation")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("colonialnation", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				colonialnation_array[counter_country] = input;
			}
			if (input.contains("major")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("major", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				major_array[counter_country] = input;
			}
			if (input.contains("colonists")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("colonists", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				colonists_array[counter_country] = input;
			}

			if (input.contains("cancelledloans")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("cancelledloans", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				cancelledloans_array[counter_country] = input;
			}

			if (input.contains("extendedloans")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("extendedloans", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				extendedloans_array[counter_country] = input;
			}

			if (input.contains("merchants")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("merchants", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				merchants_array[counter_country] = input;
			}
			if (input.contains("treasury")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("treasury", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				treasury_array[counter_country] = input;
			}
			if (input.contains("inflation")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("inflation", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				inflation_array[counter_country] = input;
			}
			
			if (input.contains("diplomats")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("diplomats", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				diplomats_array[counter_country] = input;
			}
			
			if (input.contains("whiteman")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("whiteman", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				whiteman_array[counter_country] = input;
			}
			if (input.contains("religion")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("religion", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("type", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				religion_array[counter_country] = input;
			}
			if (input.contains("culture")) {
				input = input.replaceAll(" ", "");
				input = input.replaceAll("culture", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("type", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				System.out.println(input);
				culture_array[counter_country] = input;
			}
			if (input.contains("knownprovinces")) {
				input = input.replaceAll(" ", ";");
				input = input.replaceAll("knownprovinces", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll(";;;", "");
				input = input.replaceAll(";;", "");
				System.out.println(input);
				knownprovinces_array[counter_country] = input;
			}
			if (input.contains("ownedprovinces")) {
				input = input.replaceAll(" ", ";");
				input = input.replaceAll("ownedprovinces", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll(";;;", "");
				input = input.replaceAll(";;", "");
				System.out.println(input);
				ownedprovinces_array[counter_country] = input;
			}
			if (input.contains("controlledprovinces")) {
				input = input.replaceAll(" ", ";");
				input = input.replaceAll("controlledprovinces", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll(";;;", "");
				input = input.replaceAll(";;", "");
				System.out.println(input);
				controlledprovinces_array[counter_country] = input;
			}
			if (input.contains("nationalprovinces")) {
				input = input.replaceAll(" ", ";");
				input = input.replaceAll("nationalprovinces", "");
				input = input.replaceAll("}", "");
				input = input.replace("{", "");
				input = input.replaceAll("	", "");
				input = input.replaceAll("=", "");
				input = input.replaceAll(";;;", "");
				input = input.replaceAll(";;", "");
				System.out.println(input);
				nationalprovinces_array[counter_country] = input;
			}

			if (input.contains("city")) {
				while (!input.contains("	}")) {
					input = reader.readLine();
					System.out.println(input);
					if (input.contains("name")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("name", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll("\"", "");
						System.out.println(input);
						city_name_array[counter_country] = input;
					}

					if (input.contains("fortress")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("fortress", "");
						input = input.replaceAll("level", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						city_fortress_array[counter_country] = input;
					}

					if (input.contains("population")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("population", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						city_population_array[counter_country] = input;
					}

					if (input.contains("location")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("location", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						city_location_array[counter_country] = input;
					}

					if (input.contains("capital")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("capital", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						city_capital_array[counter_country] = input;
					}
				}

			}

			if (input.contains("landunit")) {
				while (!input.contains("	}")) {
					input = reader.readLine();
					System.out.println(input);
					if (input.contains("id")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("id", "");
						input = input.replaceAll("type", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						landunit_id_array[counter_country] = input;
					}

					if (input.contains("name")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("name", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll("\"", "");
						System.out.println(input);
						landunit_name_array[counter_country] = input;
					}

					if (input.contains("infantry")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("infantry", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						landunit_infantry_array[counter_country] = input;
					}

					if (input.contains("location")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("location", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						landunit_location_array[counter_country] = input;
					}
					if (input.contains("cavalry")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("cavalry", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						landunit_cavalry_array[counter_country] = input;
					}
					if (input.contains("artillery")) {
						input = input.replaceAll(" ", "");
						input = input.replaceAll("artillery", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						landunit_artillery_array[counter_country] = input;
					}
				}

			}
			if (input.contains("technology")) {
				while (!input.contains("	}")) {
					input = reader.readLine();
					System.out.println(input);
					if (input.contains("stability")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("stability", "");
						input = input.replaceAll("level", "");
						input = input.replaceAll("value", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						technology_stability_array[counter_country] = input;
					}
					if (input.contains("infra")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("infra", "");
						input = input.replaceAll("level", "");
						input = input.replaceAll("value", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						technology_infra_array[counter_country] = input;
					}
					if (input.contains("trade")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("trade", "");
						input = input.replaceAll("level", "");
						input = input.replaceAll("value", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						technology_trade_array[counter_country] = input;
					}
					if (input.contains("land")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("land", "");
						input = input.replaceAll("level", "");
						input = input.replaceAll("value", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						technology_land_array[counter_country] = input;
					}
					if (input.contains("naval")) {
						input = input.replaceAll(" ", ";");
						input = input.replaceAll("naval", "");
						input = input.replaceAll("level", "");
						input = input.replaceAll("value", "");
						input = input.replaceAll("	", "");
						input = input.replace("{", "");
						input = input.replaceAll("}", "");
						input = input.replaceAll("=", "");
						input = input.replaceAll(";;;", ";");
						input = input.replaceAll(";;;;;", "");
						input = input.replaceAll(";;;", "");
						System.out.println(input);
						technology_naval_array[counter_country] = input;
					}
					if(input.contains("group")){
						input = input.replaceAll(" ", "");
						input = input.replaceAll("group", "");
						input = input.replaceAll("	", "");
						input = input.replaceAll("=", "");
						System.out.println(input);
						technology_group_array[counter_country] = input;
					}
				}
			}
			input = reader.readLine();

		}
		

		settings.hashmap.put("scenario_technology_group", technology_group_array);
		settings.hashmap.put("scenario_diplomats", diplomats_array);
		settings.hashmap.put("scenario_extendedloans", extendedloans_array);
		settings.hashmap.put("scenario_cancelledloans", cancelledloans_array);
		settings.hashmap.put("scenario_include", include_array);
		settings.hashmap.put("scenario_selectable", selectable_array);
		settings.hashmap.put("scenario_technology_naval", technology_naval_array);
		settings.hashmap.put("scenario_technology_land", technology_land_array);
		settings.hashmap.put("scenario_technology_trade", technology_trade_array);
		settings.hashmap.put("scenario_technology_infra", technology_infra_array);
		settings.hashmap.put("scenario_technology_stability", technology_stability_array);
		settings.hashmap.put("scenario_landunit_cavalry", landunit_cavalry_array);
		settings.hashmap.put("scenario_landunit_artillery", landunit_artillery_array);
		settings.hashmap.put("scenario_landunit_infantry", landunit_infantry_array);
		settings.hashmap.put("scenario_landunit_location", landunit_location_array);
		settings.hashmap.put("scenario_landunit_name", landunit_name_array);
		settings.hashmap.put("scenario_landunit_id", landunit_id_array);
		settings.hashmap.put("scenario_city_capital", city_capital_array);
		settings.hashmap.put("scenario_city_location", city_location_array);
		settings.hashmap.put("scenario_city_population", city_population_array);
		settings.hashmap.put("scenario_city_fortress", city_fortress_array);
		settings.hashmap.put("scenario_city_name", city_name_array);
		settings.hashmap.put("scenario_nationalprovinces", nationalprovinces_array);
		settings.hashmap.put("scenario_controlledprovinces", controlledprovinces_array);
		settings.hashmap.put("scenario_knownprovinces", knownprovinces_array);
		settings.hashmap.put("scenario_ownedprovinces", ownedprovinces_array);
		settings.hashmap.put("scenario_culture", culture_array);
		settings.hashmap.put("scenario_religion", religion_array);
		settings.hashmap.put("scenario_whiteman", whiteman_array);
		settings.hashmap.put("scenario_inflation", inflation_array);
		settings.hashmap.put("scenario_treasury", treasury_array);
		settings.hashmap.put("scenario_merchants", merchants_array);
		settings.hashmap.put("scenario_colonists", colonists_array);
		settings.hashmap.put("scenario_major", major_array);
		settings.hashmap.put("scenario_colonialnation", colonialnation_array);
		settings.hashmap.put("scenario_colonialattempts", colonialattempts_array);
		settings.hashmap.put("scenario_ai", ai_array);
		settings.hashmap.put("scenario_tag", tag_array);

	}

}