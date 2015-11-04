package scenarioeditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

public class SaveSettings {

	public static FileWriter file;
	public static BufferedWriter writer;

	public SaveSettings(HashMap<String, Object> settings) throws IOException {
		try {
			File file = new File(Main.getGameFolderName());
			String string = "//Mods//mod_" + Main.getModFolderName() + ".txt";

			FileWriter filewriter = new FileWriter(file + string);
			filewriter.write(
					"# File created with FTG Scenarioedior from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\r\n");
			filewriter.write("mod = {\r\n");
			filewriter.write("\tname = \"" + Main.getModFolderName() + "\"\r\n");
			filewriter.write("\tdir = \"" + Main.getModFolderName() + "\"\r\n");
			filewriter.write("\tshields = { \"classic\" }\r\n");
			filewriter.write("\tstyle = { \"classic\" }\r\n");
			filewriter.write("}\r\n");
			filewriter.close();

			file = new File(file + "\\Mods\\" + Main.getModFolderName());

			if (!file.exists()) {

				file.mkdir();

				file = new File(file + "\\db");
				file.mkdir();

				file = new File(file + "\\Map");
				file.mkdir();

			}

			file = new File(Main.getGameFolderName() + "\\Mods\\" + Main.getModFolderName());

			SaveCountries(settings, file + "//db//countries.txt");
			SaveProvinces(settings, file + "//db//Map//provinces.txt");
			JOptionPane.showMessageDialog(null, "Das Szenario wurde erfolgreich gespeichert!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Das Szenario konnte nicht gespeichert werden! Schauen sie bitte in der Hilfe.");
		}

	}

	@SuppressWarnings("unchecked")
	public void SaveProvinces(HashMap<String, Object> settings, String provincefilepath) throws IOException {
		file = new FileWriter(provincefilepath);
		writer = new BufferedWriter(file);
		String allprovinces = "";
		String[] provinces;

		writer.write(
				"#Provincefile created with the FTG Scenarioeditor from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\r\n");
		Set<String> keys = ((HashMap<String, Object>) settings.get("provincedata")).keySet();

		for (String key : keys) {

			if (key != "" || key != null || key != "\n") {
				allprovinces = allprovinces + "," + key;
			}

		}

		allprovinces = allprovinces.replaceAll(",,", "");

		provinces = allprovinces.split(",");

		for (int i = 0; i < provinces.length; i++) {
			if (provinces[i] != null && !provinces[i].equals("0") && i != 0
					&& !((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
							.get(provinces[i])).get("id").equals("0")) {
				writer.write("province = {\r\n");

				writer.write("\tid = " + provinces[i] + "\r\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("name") != null) {
					writer.write("\tname = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("name")
							+ "\"\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("continent") != null) {
					writer.write("\tcontinent = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("continent")
							+ "\"\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("region") != null) {
					writer.write("\tregion = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("region")
							+ "\"\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("area") != null) {
					writer.write("\tarea = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("area")
							+ "\"\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("type") != null) {
					writer.write("\ttype = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("type")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("sea_adjacency") != null) {
					writer.write("\tsea_adjacency = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("sea_adjacency")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("terrain") != null) {
					writer.write("\tterrain = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("terrain")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("size_modifier") != null) {
					writer.write("\tsize_modifier = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("size_modifier")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("climate") != null) {
					writer.write("\tclimate = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("climate")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("religion") != null) {
					writer.write("\treligion = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("religion")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("culture") != null) {
					writer.write("\tculture = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("culture")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("manpower") != null) {
					writer.write("\tmanpower = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("manpower")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("income") != null) {
					writer.write("\tincome = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("income")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("goods") != null) {
					writer.write("\tgoods = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("goods")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("value") != null) {
					writer.write("\tvalue = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("value")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("city_name") != null) {
					writer.write("\tcity_name = \""
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("city_name")
							+ "\"\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("cot_modifier") != null) {
					writer.write("\tcot_modifier = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("cot_modifier")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("colonization_difficulty") != null) {
					writer.write(
							"\tcolonization_difficulty = "
									+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings
											.get("provincedata")).get(provinces[i])).get("colonization_difficulty")
									+ "\r\n");
				}
				writer.write("\tnatives = {\r\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("combat") != null) {
					writer.write("\t\tcombat = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("combat")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("ferocity") != null) {
					writer.write("\t\tferocity = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("ferocity")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("efficiency") != null) {
					writer.write("\t\tefficiency = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("efficiency")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("tp_negotiation") != null) {
					writer.write("\t\ttp_negotiation = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("tp_negotiation")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("tolerance") != null) {
					writer.write("\t\ttolerance = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("tolerance")
							+ "\r\n");
				}
				writer.write("\t}\r\n");
				writer.write("\tgfx = {\r\n");

				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("city") != null) {
					writer.write("\t\tcity = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("city")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("army") != null) {
					writer.write("\t\tarmy = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("army")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("port") != null) {
					writer.write("\t\tport = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("port")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("manufactory") != null) {
					writer.write("\t\tmanufactory = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("manufactory")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("terrain1") != null) {
					writer.write("\t\tterrain1 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("terrain1")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("terrain2") != null) {
					writer.write("\t\tterrain2 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("terrain2")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("terrain3") != null) {
					writer.write("\t\tterrain3 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("terrain3")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("terrain4") != null) {
					writer.write("\t\tterrain4 = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("terrain4")
							+ "\r\n");
				}
				if (((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
						.get(provinces[i])).get("river") != null) {
					writer.write("\t\triver = "
							+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("provincedata"))
									.get(provinces[i])).get("river")
							+ "\r\n");
				}
				writer.write("\t}\r\n");

				writer.write("\thistory = { }\r\n");
				writer.write("}\r\n");

			}

		}
		writer.close();

	}

	@SuppressWarnings("unchecked")
	public void SaveCountries(HashMap<String, Object> settings, String string) throws IOException {
		file = new FileWriter(string);
		writer = new BufferedWriter(file);
		String allcountrynames = "";
		String[] countries;
		writer.write(
				"#Countryfile created with the FTG Scenarioeditor from Felix Beutter, Johannes Groﬂ & Maximilian von Gaisberg\r\n");

		Set<String> keys = ((HashMap<String, Object>) settings.get("countrydata")).keySet();

		for (String key : keys) {

			if (key != "" || key != null || key != "\n") {
				allcountrynames = allcountrynames + "," + key;
			}

		}
		allcountrynames = allcountrynames.replaceAll(",,", "");

		countries = allcountrynames.split(",");

		for (int i = 0; i < countries.length; i++) {

			writer.write(countries[i] + "= {" + "\r\n");
			writer.write("\tpicture = \""
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("picture")
					+ "\"\r\n");
			writer.write(
					"\tcolor = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("color") + "\r\n");
			writer.write("\ttechgroup = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("techgroup")
					+ "\r\n");
			writer.write("\tleader_language = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("leader_language")
					+ "\r\n");
			writer.write("\tnew_colony = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("new_colony")
					+ "\r\n");
			writer.write("\tpicture = \""
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("picture")
					+ "\"\r\n");
			writer.write("\tgfx = {\r\n");

			writer.write(
					"\t\tarmy  = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("army") + "\r\n");
			writer.write(
					"\t\tnavy = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("navy") + "\r\n");
			writer.write("\t}\r\n");
			writer.write("\tpolicy = {\r\n");

			writer.write("\t\taristocracy = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("aristocracy")
					+ "\r\n");
			writer.write("\t\tcentralization = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("centralization")
					+ "\r\n");
			writer.write("\t\tinnovative = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("innovative")
					+ "\r\n");
			writer.write("\t\tmercantilism = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("mercantilism")
					+ "\r\n");
			writer.write("\t\toffensive = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("offensive")
					+ "\r\n");
			writer.write(
					"\t\tland = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("land") + "\r\n");
			writer.write("\t\tquality = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("quality")
					+ "\r\n");
			writer.write("\t\tserfdom = "
					+ ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("serfdom")
					+ "\r\n");
			writer.write("\t}\r\n");

			writer.write(
					"\telector = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("elector") + "\r\n");
			writer.write(
					"\thistory = " + ((HashMap<String, Object>) ((HashMap<String, Object>) settings.get("countrydata"))
							.get(countries[i])).get("history") + "\r\n");
			writer.write("}\r\n\r\n");
		}

		writer.close();
	}

}
