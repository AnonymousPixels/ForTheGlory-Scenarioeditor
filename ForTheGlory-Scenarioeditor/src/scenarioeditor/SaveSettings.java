package scenarioeditor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class SaveSettings {

	public static FileWriter file;
	public static BufferedWriter writer;

	public SaveSettings(HashMap<String, Object> settings,
			String countryfilepath, String provincefilepath) throws IOException {
		
		System.out.println(Main.getModFolderName());
		
		SaveCountries(settings, countryfilepath);
		SaveProvinces(settings, provincefilepath);

	}

	@SuppressWarnings("unchecked")
	public void SaveProvinces(HashMap<String, Object> settings,
			String provincefilepath) throws IOException {
		file = new FileWriter(provincefilepath);
		writer = new BufferedWriter(file);
		String allprovinces = "";
		String[] provinces;

		writer.write("#Provincefile created with the FTG Scenarioeditor from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\n");
		Set<String> keys = ((HashMap<String, Object>) settings
				.get("provincedata")).keySet();

		for (String key : keys) {

			if (key != "" || key != null || key != "\n") {
				allprovinces = allprovinces + "," + key;
			}

		}

		allprovinces = allprovinces.replaceAll(",,", "");

		provinces = allprovinces.split(",");

		for (int i = 0; i < provinces.length; i++) {
			if (provinces[i] != null
					&& !provinces[i].equals("0")
					&& i != 0
					&& !((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("provincedata")).get(provinces[i])).get("id").equals("0")) {
				writer.write("province = {\n");

				writer.write("\tid = " + provinces[i] + "\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("name") != null) {
					writer.write("\tname = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("name") + "\"\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("continent") != null) {
					writer.write("\tcontinent = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("continent") + "\"\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("region") != null) {
					writer.write("\tregion = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("region") + "\"\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("area") != null) {
					writer.write("\tarea = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("area") + "\"\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("type") != null) {
					writer.write("\ttype = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("type") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("sea_adjacency") != null) {
					writer.write("\tsea_adjacency = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("sea_adjacency") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("terrain") != null) {
					writer.write("\tterrain = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("terrain") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("size_modifier") != null) {
					writer.write("\tsize_modifier = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("size_modifier") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("climate") != null) {
					writer.write("\tclimate = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("climate") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("religion") != null) {
					writer.write("\treligion = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("religion") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("culture") != null) {
					writer.write("\tculture = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("culture") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("manpower") != null) {
					writer.write("\tmanpower = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("manpower") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("income") != null) {
					writer.write("\tincome = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("income") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("goods") != null) {
					writer.write("\tgoods = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("goods") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("value") != null) {
					writer.write("\tvalue = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("value") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("city_name") != null) {
					writer.write("\tcity_name = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("city_name") + "\"\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("cot_modifier") != null) {
					writer.write("\tcot_modifier = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("cot_modifier") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("colonization_difficulty") != null) {
					writer.write("\tcolonization_difficulty = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("colonization_difficulty") + "\n");
				}
				writer.write("\tnatives = {\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("combat") != null) {
					writer.write("\t\tcombat = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("combat") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("ferocity") != null) {
					writer.write("\t\tferocity = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("ferocity") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("efficiency") != null) {
					writer.write("\t\tefficiency = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("efficiency") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("tp_negotiation") != null) {
					writer.write("\t\ttp_negotiation = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("tp_negotiation") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("tolerance") != null) {
					writer.write("\t\ttolerance = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("tolerance") + "\n");
				}
				writer.write("\t}\n");
				writer.write("\tgfx = {\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("city") != null) {
					writer.write("\t\tcity = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("city") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("army") != null) {
					writer.write("\t\tarmy = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("army") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("port") != null) {
					writer.write("\t\tport = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("port") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("manufactory") != null) {
					writer.write("\t\tmanufactory = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("manufactory") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("terrain1") != null) {
					writer.write("\t\tterrain1 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("terrain1") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("terrain2") != null) {
					writer.write("\t\tterrain2 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("terrain2") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("terrain3") != null) {
					writer.write("\t\tterrain3 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("terrain3") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i]))
						.get("terrain4") != null) {
					writer.write("\t\tterrain4 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("terrain4") + "\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings
						.get("provincedata")).get(provinces[i])).get("river") != null) {
					writer.write("\t\triver = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
									.get("provincedata")).get(provinces[i]))
									.get("river") + "\n");
				}
				writer.write("\t}\n");

				writer.write("\thistory = { }\n");
				writer.write("}\n");

			}

		}
		writer.close();

	}

	@SuppressWarnings("unchecked")
	public void SaveCountries(HashMap<String, Object> settings,
			String countryfilepath) throws IOException {
		file = new FileWriter(countryfilepath);
		writer = new BufferedWriter(file);
		String allcountrynames = "";
		String[] countries;
		writer.write("#Countryfile created with the FTG Scenarioeditor from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\n");

		Set<String> keys = ((HashMap<String, Object>) settings
				.get("countrydata")).keySet();

		for (String key : keys) {

			if (key != "" || key != null || key != "\n") {
				allcountrynames = allcountrynames + "," + key;
			}

		}
		allcountrynames = allcountrynames.replaceAll(",,", "");

		countries = allcountrynames.split(",");

		for (int i = 0; i < countries.length; i++) {

			writer.write(countries[i] + "= {" + "\n");
			writer.write("\tpicture = \""
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("picture") + "\"\n");
			writer.write("\tcolor = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("color") + "\n");
			writer.write("\ttechgroup = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("techgroup") + "\n");
			writer.write("\tleader_language = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("leader_language") + "\n");
			writer.write("\tnew_colony = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("new_colony") + "\n");
			writer.write("\tpicture = \""
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("picture") + "\"\n");
			writer.write("\tgfx = {\n");

			writer.write("\t\tarmy  = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i])).get("army")
					+ "\n");
			writer.write("\t\tnavy = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i])).get("navy")
					+ "\n");
			writer.write("\t}\n");
			writer.write("\tpolicy = {\n");

			writer.write("\t\taristocracy = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("aristocracy") + "\n");
			writer.write("\t\tcentralization = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("centralization") + "\n");
			writer.write("\t\tinnovative = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("innovative") + "\n");
			writer.write("\t\tmercantilism = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("mercantilism") + "\n");
			writer.write("\t\toffensive = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("offensive") + "\n");
			writer.write("\t\tland = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i])).get("land")
					+ "\n");
			writer.write("\t\tquality = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("quality") + "\n");
			writer.write("\t\tserfdom = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("serfdom") + "\n");
			writer.write("\t}\n");

			writer.write("\telector = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("elector") + "\n");
			writer.write("\thistory = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
							.get("countrydata")).get(countries[i]))
							.get("history") + "\n");
			writer.write("}\n\n");
		}

		writer.close();
	}

}
