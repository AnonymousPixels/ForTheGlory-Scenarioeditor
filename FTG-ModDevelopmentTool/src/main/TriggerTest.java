package main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class TriggerTest implements ActionListener {
	public static JComboBox domesticselection, areaselection, regionselection,
			continentselection, techgroupselection, religionselection,
			triggerselection, checkselection, country_aaa_selection,
			country_bbb_selection, monthselection, dayselection,
			provinzselection, cultureselection;
	public static String selection, selectionbefore, stringvalue, trigger;
	public static JTextField data;
	public static JButton addtrigger;
	public static int value;
	public static JFormattedTextField year, intdata;


	public TriggerTest() {
		String triggercommands[] = { "(Trigger)", "random", "year", "exists",
				"flag", "event", "ai", "city", "colonialcity", "colony",
				"tradingpost", "provincepopulation", "fortresslevel", "cot",
				"discovered", "controlchange", "ownerchange", "control",
				"owned", "provincereligion", "cityculture", "provinceculture",
				"core_casusbelli", "core_claim", "core_national", "capital",
				"infra", "trade", "stability", "naval", "alliance", "dynastic",
				"vassal", "union", "war", "truce", "atwar", "isvassal",
				"isoverlord", "access", "relation", "leader", "monarch",
				"culture", "religion", "technology", "continent", "region",
				"area", "countrysize", "badboy", "inflation", "treasury",
				"diplomats", "merchants", "colonists", "missionaries",
				"elector", "emperor", "hre", "neighbour", "tag", "domestic",
				"land" };
		String check[] = { "(Yes or No)", "yes", "no" };
		String country_aaa[] = { "(Choose country A)", "ABK", "ACH", "ADA",
				"ADE", "AFG", "AHL", "AHM", "AIN", "AKK", "ALB", "ALQ", "ALD",
				"ALH", "ACL", "ALT", "AMB", "ANC", "ANL", "ANG", "ANH", "ANJ",
				"ANK", "ANN", "ANS", "ANT", "APA", "ANQ", "AQU", "ARG", "ARK",
				"ARP", "ARW", "AGN", "AMG", "ARM", "AMI", "ART", "ASC", "ASH",
				"ASS", "AST", "ASU", "ATH", "ATJ", "AUS", "HAB", "AUV", "AVI",
				"AWA", "AYD", "AYM", "AYU", "AZE", "AZT", "BAD", "BAG", "BAU",
				"BAL", "BAN", "BAS", "BAY", "BYL", "BYM", "BYS", "BRT", "BEJ",
				"BEL", "BGL", "BEN", "BER", "BRG", "BRN", "BIJ", "BIM", "BIS",
				"BLA", "BOR", "BOH", "BOI", "BOV", "BOL", "BOS", "BOU", "HAU",
				"BRA", "BRZ", "BRE", "BRL", "CBE", "BRI", "BEI", "BRU", "BUD",
				"BUG", "BUK", "BUL", "BUN", "BNY", "BUR", "MYA", "BRY", "BUT",
				"BYZ", "CAJ", "CLF", "CAL", "CAM", "CND", "CNI", "CAN", "CRC",
				"CAS", "CAT", "CTW", "CAR", "CPH", "CHC", "CHG", "CHA", "CMG",
				"CRG", "CHE", "CHY", "CHB", "CHK", "CNG", "CHL", "CHM", "CHI",
				"CHN", "CHR", "CHT", "CHO", "CHU", "CUG", "KLE", "KOL", "COL",
				"COM", "CNS", "CON", "CNW", "COR", "CSR", "KUR", "CEE", "CEK",
				"CRE", "CRI", "CRO", "CUB", "CUS", "CYP", "CYR", "DAH", "DAI",
				"DAK", "DAL", "DAG", "DAR", "DAS", "DAU", "DAX", "DEL", "DLH",
				"DEM", "DAN", "DMN", "DUL", "DUR", "CDE", "CDW", "DZU", "ECU",
				"EDE", "EGE", "EGY", "ELS", "ENG", "EPI", "ERE", "SAE", "ETH",
				"FAE", "FAN", "FER", "FEZ", "FIN", "FIR", "FLA", "FOI", "FRA",
				"FRC", "FFT", "FNK", "FRE", "FUC", "FRS", "FRI", "FUL", "GLC",
				"GLL", "VOL", "GAL", "GEL", "GNV", "GEN", "GEO", "GER", "GMY",
				"GHA", "GOL", "STE", "GON", "GOT", "GRA", "GBR", "GCL", "GRE",
				"GRO", "GUA", "GUT", "GUJ", "GIA", "GUR", "GWA", "HMI", "HAD",
				"HAH", "HNT", "HAI", "HAL", "HAM", "HAN", "HSA", "HAS", "HAW",
				"ARA", "HED", "HEK", "HES", "HOC", "HLL", "HND", "HOY", "HUD",
				"FPR", "HUN", "HUR", "HYD", "ICE", "IGA", "ILK", "ILL", "IME",
				"INC", "IND", "INS", "ING", "IOI", "EIR", "OHI", "ISA", "ISH",
				"IST", "ITA", "JAI", "JAM", "NIP", "JAU", "JEN", "JER", "JIC",
				"JOD", "JOL", "JUT", "JUE", "KAF", "KAK", "KLT", "KNB", "KAN",
				"KAR", "KSI", "KTL", "KSH", "KAZ", "KHM", "KHA", "KZK", "KOI",
				"KOK", "KHS", "KHO", "KHT", "KIL", "KLA", "KNI", "KON", "KOR",
				"KRA", "KRD", "KTC", "KUT", "KYO", "KUS", "KRN", "LAI", "LAK",
				"LAN", "LAU", "LEI", "LEN", "LEO", "LIB", "LIE", "LIP", "LIT",
				"LIV", "LOA", "LOR", "LOU", "BYN", "LUA", "LUB", "LUC", "LUN",
				"LUW", "LUX", "LUE", "BLC", "MDW", "MAD", "MAG", "MGN", "MRA",
				"MAH", "MAI", "MAJ", "MKS", "MLC", "MWI", "MAL", "MLI", "MLL",
				"MLW", "MCH", "MNI", "MAN", "MSC", "MSV", "MAS", "MTR", "MAA",
				"MEA", "MEC", "MEI", "MEN", "MES", "MET", "MEW", "MEX", "MIK",
				"MLO", "MIS", "MIX", "MOD", "MDC", "MGD", "MOH", "MOL", "MOM",
				"MNG", "MNT", "MRV", "MRE", "MOR", "MOG", "MUL", "MST", "MUR",
				"MOS", "MSK", "ZIM", "MUN", "MYS", "MZB", "NAJ", "NAP", "NAS",
				"NCH", "NVJ", "NAV", "NAX", "NDO", "NEI", "NEP", "HOL", "NEV",
				"NWZ", "NGU", "NCR", "NKO", "NOG", "NRM", "NOR", "NVG", "NUB",
				"NUE", "OEL", "OIR", "OLD", "OMA", "OPP", "ORI", "ORK", "ORL",
				"ORM", "TUR", "OYO", "PAG", "PAL", "PNM", "PAP", "PRG", "PAR",
				"PAW", "PEG", "PAK", "PRM", "PER", "PEU", "PIA", "POD", "POI",
				"POL", "PMR", "POM", "POS", "POW", "POR", "PON", "POT", "PWA",
				"PRO", "PRU", "PSK", "PUN", "PRH", "PUR", "QAR", "QUA", "QUE",
				"QUI", "RAG", "RAM", "RAV", "REG", "REI", "PFA", "RHI", "RIO",
				"ROM", "RPR", "ROY", "RUS", "RAC", "RWA", "RYA", "RYU", "SLZ",
				"SAM", "SMT", "SAN", "SNH", "SNT", "SAR", "SAV", "SAG", "SAL",
				"SAW", "SWI", "SAC", "SCH", "SHL", "SRU", "SCO", "SEN", "SFU",
				"SER", "SHA", "SHW", "SLL", "SHZ", "SHI", "SIB", "SIC", "PIS",
				"SIL", "SND", "SIO", "SKA", "SMO", "SOL", "SON", "SOU", "SPR",
				"SPA", "SRI", "SEI", "STR", "SUD", "SUL", "SUZ", "SWA", "SWE",
				"HEL", "TAI", "TAU", "TEK", "TKK", "TEM", "TER", "TES", "LAT",
				"TEX", "THA", "THE", "THU", "TIB", "TID", "TIM", "TLA", "TLE",
				"TON", "TOU", "SIE", "TRA", "TRE", "TRN", "TIE", "TRI", "TRP",
				"TSW", "TUA", "TUN", "TOS", "TUS", "TUT", "TVE", "TWS", "TYR",
				"UKR", "ULS", "UNA", "KAL", "UBD", "UKI", "USA", "BYU", "URU",
				"UTR", "UZB", "VAL", "VNZ", "VEN", "VRM", "VER", "VIE", "VIJ",
				"WAG", "WLY", "WLS", "WAL", "WAR", "WER", "WFL", "WES", "WUR",
				"WRZ", "WAA", "XHO", "YAN", "YAZ", "YEM", "YUC", "YUP", "ZAN",
				"ZAP", "ZAR", "ZEA", "ZEE", "ZHO", "ZUL" };
		String month[] = { "(Month)", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12" };
		String day[] = { "Day", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30" };
		String culture[] = { "(Culuture)" };
		String religion[] = { "(Religion)" };
		String techgroup[] = { "(Techgroup)" };
		String continent[] = { "(Continent)" };
		String region[] = { "(Region)" };
		String area[] = { "(Area)" };
		String domestic[] = { "(Domestic)", "aristocracy", "centralization",
				"innovative", "mercantilism", "land", "offensive", "quality",
				"serfdom" };
		String privinz[] = { "(Provinz)" };

		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setAllowsInvalid(false);

		year = new JFormattedTextField(formatter);

		intdata = new JFormattedTextField(formatter);

		triggerselection = new JComboBox(triggercommands);
		checkselection = new JComboBox(check);
		country_aaa_selection = new JComboBox(country_aaa);
		country_bbb_selection = new JComboBox(country_aaa);
		monthselection = new JComboBox(month);
		dayselection = new JComboBox(day);
		cultureselection = new JComboBox(culture);
		religionselection = new JComboBox(religion);
		techgroupselection = new JComboBox(techgroup);
		continentselection = new JComboBox(continent);
		regionselection = new JComboBox(region);
		areaselection = new JComboBox(area);
		domesticselection = new JComboBox(domestic);
		provinzselection = new JComboBox(privinz);

		addtrigger = new JButton();
		addtrigger.setText("Add Trigger");
		addtrigger.addActionListener(this);

		value = 0;

		// year = new JTextField("year");
		data = new JTextField("data");

		GUI.trigger.add(triggerselection);

		selection = (String) triggerselection.getSelectedItem();

		check();
	}

	public void check() {
		while (true) {
			selection = (String) triggerselection.getSelectedItem();

			if (selection != selectionbefore) {

				if (selection == "alliance") {
					// country = aaa country = bbb
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "dynastic") {
					// country = aaa country = bbb
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);

					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "vassal") {
					// country = aaa country = bbb

					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);

					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "union") {
					// country = aaa country = bbb
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "war") {
					// country = aaa country = bbb
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "truce") {
					// country = aaa country = bbb
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(country_bbb_selection);

				}
				if (selection == "atwar") {
					// yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "isvassal") {
					// yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "isoverlord") {
					// yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "access") {
					// aaa (country)
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);

				}
				if (selection == "relation") {
					// country = aaa data = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);
					GUI.trigger.add(intdata);
					data.setText("(Value)");

				}
				if (selection == "leader") {
					// leader = xxxx
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText(" (Leader ID) ");

				}
				if (selection == "monarch") {
					// monarch = xxxx
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText(" (Monarch ID) ");

				}
				if (selection == "culture") {
					// culture = culture_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(cultureselection);

				}
				if (selection == "religion") {
					// religion = religion_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(religionselection);

				}
				if (selection == "technology") {
					// technology = techgroup_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(techgroupselection);

				}
				if (selection == "continent") {
					// continent = continent_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(continentselection);

				}
				if (selection == "region") {
					// region = region_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(regionselection);

				}
				if (selection == "area") {
					// area = area_name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(areaselection);

				}
				if (selection == "countrysize") {
					// countrysize = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Countrysize)");

				}
				if (selection == "badboy") {
					// badboy = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "inflation") {
					// inflation = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "treasury") {
					// treasury = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "diplomats") {
					// diplomats = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "merchants") {
					// merchants = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "colonists") {
					// colonists = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "missionaries") {
					// missionaries = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "elector") {
					// elector = yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "emperor") {
					// emperor = yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "hre") {
					// hre = yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "neighbour") {
					// neighbour = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "tag") {
					// tag = aaa
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);

				}
				if (selection == "domestic") {
					// domestic = { type = aristocracy/ centralization/
					// innovative/ mercantilism/ land/ offensive/ quality/
					// serfdom value = x }

					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(domesticselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "land") {
					// land = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "stability") {
					// naval = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "naval") {
					// stability = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "trade") {
					// trade = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "infra") {
					// infra = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "capital") {
					// capital = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "core_national") {
					// core_national = { province = x data = aaa }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(country_aaa_selection);
				}
				if (selection == "core_claim") {
					// core_claim = { province = x data = aaa }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(country_aaa_selection);
				}
				if (selection == "core_casusbelli") {
					// core_casusbelli = { province = x data = aaa }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(country_aaa_selection);
				}
				if (selection == "provinceculture") {
					// provinceculture = { province = x data = y }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(intdata);
				}
				if (selection == "cityculture") {
					// cityculture = { province = x data = y }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(intdata);

				}
				if (selection == "provincereligion") {
					// provincereligion = { province = x data = y }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(intdata);

				}
				if (selection == "owned") {
					// owned = { province = x data = aaa }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(country_aaa_selection);

				}
				if (selection == "control") {
					// control = { province = x data = aaa }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(country_aaa_selection);

				}
				if (selection == "ownerchange") {
					// ownerchange = { province = x years = y months = m days =
					// d }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(year);
					GUI.trigger.add(monthselection);
					GUI.trigger.add(dayselection);

				}
				if (selection == "controlchange") {
					// controlchange = { province = x years = y months = m days
					// = d }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(year);
					GUI.trigger.add(monthselection);
					GUI.trigger.add(dayselection);

				}
				if (selection == "discovered") {
					// discovered = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "cot") {
					// cot = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "fortresslevel") {
					// fortresslevel = { province = x data = y }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "provincepopulation") {
					// provincepopulation = { province = x data = y }
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(provinzselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "tradingpost") {
					// tradingpost = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "colony") {
					// colony = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "colonialcity") {
					// colonialcity = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "city") {
					// city = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);
					intdata.setText("(Value)");

				}
				if (selection == "event") {
					// event = xxxx
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(intdata);

				}
				if (selection == "ai") {
					// ai = yes / no
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(checkselection);

				}
				if (selection == "flag") {
					// flag = flag name
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(data);
					data.setText("(Flagname)");

				}
				if (selection == "exists") {
					// exists = aaa
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(country_aaa_selection);

				}
				if (selection == "year") {
					// year = x
					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);
					GUI.trigger.add(year);

				}
				if (selection == "random") {
					// random = x

					GUI.trigger.removeAll();

					GUI.trigger.add(triggerselection);

				}

				GUI.trigger.add(addtrigger);
				GUI.trigger.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			selectionbefore = selection;

		}
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addtrigger) {
			if (selection == "alliance") {
				// alliance = { country = aaa country = bbb }
				trigger = "alliance = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "dynastic") {
				// country = aaa country = bbb
				trigger = "dynastic = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "vassal") {
				// country = aaa country = bbb
				trigger = "vassal = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "union") {
				// country = aaa country = bbb
				trigger = "union = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "war") {
				// country = aaa country = bbb
				trigger = "war = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "truce") {
				// country = aaa country = bbb
				trigger = "truce = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " country = "
						+ (String) country_bbb_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "atwar") {
				// yes / no
				trigger = "atwar = "
						+ (String) checkselection.getSelectedItem();
			}
			if (selection == "isvassal") {
				// yes / no
				trigger = "isvassal = "
						+ (String) checkselection.getSelectedItem();
			}
			if (selection == "isoverlord") {
				// yes / no
				trigger = "isoverlord = "
						+ (String) checkselection.getSelectedItem();
			}
			if (selection == "access") {
				// aaa (country)
				trigger = "access = "
						+ (String) country_aaa_selection.getSelectedItem();
			}
			if (selection == "relation") {
				// relation = { country = aaa data = x }
				trigger = "relation = { country = "
						+ (String) country_aaa_selection.getSelectedItem();
				trigger = trigger + " data = "
						+ (String) intdata.getSelectedText() + " }";
			}
			if (selection == "leader") {
				// leader = xxxx
				trigger = "leader = " + intdata.getText();
			}
			if (selection == "monarch") {
				// monarch = xxxx
				trigger = "monarch = " + intdata.getText();
			}
			if (selection == "culture") {
				// culture = culture_name
				trigger = "culture = "
						+ (String) cultureselection.getSelectedItem();
			}
			if (selection == "religion") {
				// religion = religion_name
				trigger = "religion = "
						+ (String) religionselection.getSelectedItem();
			}
			if (selection == "technology") {
				// technology = techgroup_name
				trigger = "technology = "
						+ (String) techgroupselection.getSelectedItem();
			}
			if (selection == "continent") {
				// continent = continent_name
				trigger = "continent = "
						+ (String) continentselection.getSelectedItem();
			}
			if (selection == "region") {
				// region = region_name
				trigger = "region = "
						+ (String) regionselection.getSelectedItem();
			}
			if (selection == "area") {
				// area = area_name
				trigger = "area = " + (String) areaselection.getSelectedItem();
			}
			if (selection == "countrysize") {
				// countrysize = x
				trigger = "countrysize = " + intdata.getText();
			}
			if (selection == "badboy") {
				// badboy = x
				trigger = "badboy = " + intdata.getText();
			}
			if (selection == "inflation") {
				// inflation = x
				trigger = "inflation = " + intdata.getText();
			}
			if (selection == "treasury") {
				// treasury = x
				trigger = "treasury = " + intdata.getText();
			}
			if (selection == "diplomats") {
				// diplomats = x
				trigger = "diplomats = " + intdata.getText();
			}
			if (selection == "merchants") {
				// merchants = x
				trigger = "merchants = " + intdata.getText();
			}
			if (selection == "colonists") {
				// colonists = x
				trigger = "colonists = " + intdata.getText();
			}
			if (selection == "missionaries") {
				// missionaries = x
				trigger = "missionaries = " + intdata.getText();
			}
			if (selection == "elector") {
				// elector = yes / no
				trigger = "elector = "
						+ (String) checkselection.getSelectedItem();
			}
			if (selection == "emperor") {
				// emperor = yes / no
				trigger = "emperor = "
						+ (String) checkselection.getSelectedItem();
			}
			if (selection == "hre") {
				// hre = yes / no
				trigger = "hre = " + (String) checkselection.getSelectedItem();
			}
			if (selection == "neighbour") {
				// neighbour = x
				trigger = "neighbour = " + intdata.getText();
			}
			if (selection == "tag") {
				// tag = aaa
				trigger = "tag = "
						+ (String) country_aaa_selection.getSelectedItem();
			}
			if (selection == "domestic") {
				// domestic = { type = aristocracy/ centralization/
				// innovative/ mercantilism/ land/ offensive/ quality/
				// serfdom value = x }
				trigger = "domestic = { type = "
						+ (String) domesticselection.getSelectedItem()
						+ " value = " + intdata.getText() + " }";
			}
			if (selection == "land") {
				// land = x
				trigger = "land = " + intdata.getText();
			}
			if (selection == "stability") {
				// naval = x
				trigger = "stability = " + intdata.getText();
			}
			if (selection == "naval") {
				// stability = x
				trigger = "naval = " + intdata.getText();
			}
			if (selection == "trade") {
				// trade = x
				trigger = "trade = " + intdata.getText();
			}
			if (selection == "infra") {
				// infra = x
				trigger = "infra = " + intdata.getText();
			}
			if (selection == "capital") {
				// capital = x
				trigger = "capital = " + intdata.getText();
			}
			if (selection == "core_national") {
				// core_national = { province = x data = aaa }
				trigger = "core_national = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "x data = " + intdata.getText() + " }";
			}
			if (selection == "core_claim") {
				// core_claim = { province = x data = aaa }
				trigger = "core_claim = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = "
						+ (String) country_aaa_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "core_casusbelli") {
				// core_casusbelli = { province = x data = aaa }
				trigger = "core_casusbelli = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = "
						+ (String) country_aaa_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "provinceculture") {
				// provinceculture = { province = x data = y }
				trigger = "provinceculture = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = " + intdata.getText() + " }";
			}
			if (selection == "cityculture") {
				// cityculture = { province = x data = y }
				trigger = "cityculture = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = " + intdata.getText() + " }";
			}
			if (selection == "provincereligion") {
				// provincereligion = { province = x data = y }
				trigger = "provincereligion = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = " + intdata.getText() + " }";
			}
			if (selection == "owned") {
				// owned = { province = x data = aaa }
				trigger = "provincereligion = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = "
						+ (String) country_aaa_selection.getSelectedItem()
						+ " }";
			}
			if (selection == "control") {
				// control = { province = x data = aaa }
				trigger = "control = { province = "
						+ (String) provinzselection.getSelectedItem()
						+ "data = "
						+ (String) country_aaa_selection.getSelectedItem()
						+ " }";

			}
			if (selection == "ownerchange") {
				// ownerchange = { province = x years = y months = m days =
				// d }
				stringvalue = (String) provinzselection.getSelectedItem();
				trigger = "ownerchange = { province = " + stringvalue;
				stringvalue = year.getText();
				trigger = trigger + " years = " + stringvalue;
				stringvalue = (String) monthselection.getSelectedItem();
				trigger = trigger + " months = " + stringvalue;
				stringvalue = (String) dayselection.getSelectedItem();
				trigger = trigger + " days = " + stringvalue;

			}
			if (selection == "controlchange") {
				// controlchange = { province = x years = y months = m days = d
				// }
				stringvalue = (String) provinzselection.getSelectedItem();
				trigger = "controlchange = { province = " + stringvalue;
				stringvalue = year.getText();
				trigger = trigger + " years = " + stringvalue;
				stringvalue = (String) monthselection.getSelectedItem();
				trigger = trigger + " months = " + stringvalue;
				stringvalue = (String) dayselection.getSelectedItem();
				trigger = trigger + " days = " + stringvalue;

			}
			if (selection == "discovered") {
				// discovered = x
				stringvalue = intdata.getText();
				trigger = "discovered = " + stringvalue;

			}
			if (selection == "cot") {
				// cot = x
				stringvalue = intdata.getText();
				trigger = "cot = " + stringvalue;

			}
			if (selection == "fortresslevel") {
				// fortresslevel = { province = x data = y }
				stringvalue = (String) provinzselection.getSelectedItem();
				trigger = "fortresslevel = { province = " + stringvalue;
				stringvalue = intdata.getText();
				trigger = trigger + " data = " + stringvalue + " }";

			}
			if (selection == "provincepopulation") {
				// provincepopulation = { province = x data = y }
				stringvalue = (String) provinzselection.getSelectedItem();
				trigger = "provincepopulation = { province = " + stringvalue;
				stringvalue = intdata.getText();
				trigger = trigger + " data = " + stringvalue + " }";

			}
			if (selection == "tradingpost") {
				// tradingpost = x
				stringvalue = intdata.getText();
				trigger = "tradingpost = " + stringvalue;

			}
			if (selection == "colony") {
				// colony = x
				stringvalue = intdata.getText();
				trigger = "colony = " + stringvalue;

			}
			if (selection == "colonialcity") {
				// colonialcity = x
				stringvalue = intdata.getText();
				trigger = "colonialcity = " + stringvalue;

			}
			if (selection == "city") {
				// city = x
				stringvalue = intdata.getText();
				trigger = "city = " + stringvalue;

			}
			if (selection == "event") {
				// event = xxxx
				stringvalue = intdata.getText();
				trigger = "event = " + stringvalue;

			}
			if (selection == "ai") {
				// ai = yes / no
				stringvalue = (String) checkselection.getSelectedItem();
				trigger = "ai = " + stringvalue;

			}
			if (selection == "flag") {
				// flag = flag name
				stringvalue = (String) data.getText();
				trigger = "flag = " + stringvalue;

			}
			if (selection == "exists") {
				// exists = aaa
				stringvalue = (String) country_aaa_selection.getSelectedItem();
				trigger = "exists = " + stringvalue;

			}
			if (selection == "year") {
				// year = x
				stringvalue = year.getText();
				trigger = "year = " + stringvalue;

			}
			if (selection == "random") {
				// random = x
				value = (int) (Math.random() * 100);
				trigger = "random = " + value;

			}
			System.out.println(trigger);
		}

	}

}