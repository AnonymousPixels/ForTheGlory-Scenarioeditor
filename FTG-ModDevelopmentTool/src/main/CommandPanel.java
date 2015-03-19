package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class CommandPanel implements ActionListener {

	public static JComboBox domesticselection, areaselection, regionselection,
			continentselection, techgroupselection, religionselection,
			commandselection, checkselection, country_aaa_selection,
			country_bbb_selection, monthselection, dayselection,
			provinzselection, cultureselection;
	public static String selection, selectionbefore, stringvalue, command;
	public static JTextField data;
	public static JButton addcommand;
	public static int value;
	public static JFormattedTextField year, intdata, intdata2;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CommandPanel() {
		String commandlist[] = { "(command)", "alliance", "dynastic", "vassal",
				"breakvassal", "breakoverlord", "inherit", "annex",
				"independence", "relation", "casusbelli", "war",
				"cedeprovince", "control", "giveaccess", "cancelaccess",
				"revokeaccess", "givetrade", "revoketrade", "elector",
				"flagname", "countryname", "wakemonarch", "sleepmonarch",
				"wakeleader", "sleepleader", "conquistador", "explorer", "ADM",
				"MIL", "DIP", "country", "technology", "religion",
				"add_countryculture", "remove_countryculture", "manpower",
				"badboy", "capital", "addcore_national", "addcore_claim",
				"addcore_casusbelli", "removecore_national",
				"removecore_claim", "removecore_casusbelli", "discover",
				"domestic", "land", "naval", "stability", "trade", "infra",
				"treasury", "inflation", "loansize", "population",
				"populationpercent", "provincetax", "provincemanpower",
				"cityname", "provincereligion", "provincereligion",
				"provinceculture", "cityculture", "alt_provincereligion",
				"goods", "terrain", "conversion", "heretic", "hre", "cot",
				"removecot", "mine", "natives", "nativeattack", "revolt",
				"province_revoltrisk", "colonialrevolt", "religiousrevolt",
				"revoltrisk", "gainbuilding", "losebuilding",
				"gainmanufactory", "losemanufactory", "fortress",
				"fortresslevel", "diplomats", "colonists", "merchants",
				"missionaries", "INF", "CAV", "ART", "desertion", "warships",
				"galleys", "transports", "pirates", "privateers", "ai",
				"setflag", "clrflag", "flag", "trigger", "sleepevent", "vp" };
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
		intdata2 = new JFormattedTextField(formatter);

		commandselection = new JComboBox(commandlist);
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

		addcommand = new JButton();
		addcommand.setText("Add command");
		addcommand.addActionListener(this);

		value = 0;

		data = new JTextField("data");

		Main.panel2.add(commandselection);
		Main.panel2.setVisible(false);
		Main.panel2.setVisible(true);
		selection = (String) commandselection.getSelectedItem();

		ActionListener commandlistener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				selection = (String) commandselection.getSelectedItem();
				System.out.println(selection);

				Main.panel2.removeAll();
				Main.panel2.add(commandselection);
				if (selection == "alliance") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "dynastic") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "vassal") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "breakvassal") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "breakoverlord") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "inherit") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "annex") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "independence") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "relation") {
					Main.panel2.add(country_aaa_selection);
					Main.panel2.add(intdata);
				}
				if (selection == "casusbelli") {
					Main.panel2.add(country_aaa_selection);
					Main.panel2.add(intdata);
				}
				if (selection == "war") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "cedeprovince") {
					Main.panel2.add(country_aaa_selection);
					Main.panel2.add(intdata);
				}
				if (selection == "control") {
					Main.panel2.add(intdata);
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "giveaccess") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "cancelaccess") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "revokeaccess") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "givetrade") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "revoketrade") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "elector") {
					Main.panel2.add(country_aaa_selection);
					Main.panel2.add(intdata);
				}
				if (selection == "flagname") {
					Main.panel2.add(data);
				}
				if (selection == "countryname") {
					Main.panel2.add(data);
				}
				if (selection == "wakemonarch") {
					Main.panel2.add(intdata);
				}
				if (selection == "sleepmonarch") {
					Main.panel2.add(intdata);
				}
				if (selection == "wakeleader") {
					Main.panel2.add(intdata);
				}
				if (selection == "sleepleader") {
					Main.panel2.add(intdata);
				}
				if (selection == "conquistador") {
					Main.panel2.add(intdata);
				}
				if (selection == "explorer") {
					Main.panel2.add(intdata);
				}
				if (selection == "ADM") {
					Main.panel2.add(intdata);
					Main.panel2.add(intdata2);
				}
				if (selection == "MIL") {
					Main.panel2.add(intdata);
					Main.panel2.add(intdata2);
				}
				if (selection == "DIP") {
					Main.panel2.add(intdata);
					Main.panel2.add(intdata2);
				}
				if (selection == "country") {
					Main.panel2.add(country_aaa_selection);
				}
				if (selection == "technology") {
					Main.panel2.add(techgroupselection);
				}
				if (selection == "religion") {
					Main.panel2.add(religionselection);
				}
				if (selection == "add_countryculture") {
					Main.panel2.add(cultureselection);
				}
				if (selection == "add_countryculture") {
					Main.panel2.add(cultureselection);
				}
				Main.panel2.add(addcommand);
				Main.panel2.setVisible(false);
				Main.panel2.setVisible(true);
			}
		};
		commandselection.addActionListener(commandlistener);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addcommand) {

			if (selection == "alliance") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = alliance which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "dynastic") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = dynastic which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "vassal") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = vassal which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "breakvassal") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = breakvassal which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "breakoverlord") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = breakoverlord which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";

				}
			}
			if (selection == "inherit") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = inherit which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";

				}
			}
			if (selection == "annex") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = annex which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "independence") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = independence which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "relation") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = relation which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " value = " + intdata.getText() + " }";
				}
			}

			if (selection == "casusbelli") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)"
						|| intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = casusbelli which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " value = " + intdata.getText() + " }";
				}
			}
			if (selection == "war") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = war which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "cedeprovince") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)"
						|| intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = cedeprovince which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " value = " + intdata.getText() + " }";
				}
			}
			if (selection == "control") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)"
						|| intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = control which = "
							+ intdata.getText() + " value = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "giveaccess") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = giveaccess which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "cancelaccess") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = cancelaccess which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "revokeaccess") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = revokeaccess which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "givetrade") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = givetrade which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "revoketrade") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = revoketrade which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "elector") {
				if ((String) country_aaa_selection.getSelectedItem() == "(Choose country A)"
						|| intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = elector which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " value = " + intdata.getText() + " }";
				}
			}
			if (selection == "flagname") {
				if (data.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = flagname which = " + "\""
							+ data.getText() + "\"" + " }";
				}
			}
			if (selection == "countryname") {
				if (data.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = countryname which = " + "\""
							+ data.getText() + "\"" + " }";
				}
			}
			if (selection == "wakemonarch") {
				if (intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = wakemonarch which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "sleepmonarch") {
				if (intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = sleepmonarch which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "wakeleader") {
				if (intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = wakeleader which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "sleepleader") {
				if (intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = sleepleader which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "conquistador") {
				if (intdata.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = conquistador which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "explorer") {
				if (intdata.getText() == "" || intdata2.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = explorer which = "
							+ intdata.getText() + " }";
				}
			}
			if (selection == "ADM") {
				if (intdata.getText() == "" || intdata2.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = ADM which = "
							+ intdata.getText() + " value = "
							+ intdata2.getText() + " }";
				}
			}
			if (selection == "MIL") {
				if (intdata.getText() == "" || intdata2.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = MIL which = "
							+ intdata.getText() + " value = "
							+ intdata2.getText() + " }";
				}
			}
			if (selection == "DIP") {
				if (intdata.getText() == "" || intdata2.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = DIP which = "
							+ intdata.getText() + " value = "
							+ intdata2.getText() + " }";
				}
			}
			if (selection == "country") {
				if (intdata.getText() == "" || intdata2.getText() == "") {
					JOptionPane.showMessageDialog(null,
							"Bitte richtigen Wert eingeben!", "Error - Wert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					command = "command = { type = country which = "
							+ (String) country_aaa_selection.getSelectedItem()
							+ " }";
				}
			}
			if (selection == "technology") {
				command = "command = { type = technology which = "
						+ (String) techgroupselection.getSelectedItem() + " }";
			}

			GUI.txtaScenario.setText(GUI.txtaScenario.getText()+"\n"+command);
		}

	}

}
