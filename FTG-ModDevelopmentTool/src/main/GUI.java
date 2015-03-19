package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.FTG.*;

public class GUI implements ActionListener {

	String country[] = { "ABK", "ACH", "ADA", "ADE", "AFG", "AHL", "AHM",
			"AIN", "AKK", "ALB", "ALQ", "ALD", "ALH", "ACL", "ALT", "AMB",
			"ANC", "ANL", "ANG", "ANH", "ANJ", "ANK", "ANN", "ANS", "ANT",
			"APA", "ANQ", "AQU", "ARG", "ARK", "ARP", "ARW", "AGN", "AMG",
			"ARM", "AMI", "ART", "ASC", "ASH", "ASS", "AST", "ASU", "ATH",
			"ATJ", "AUS", "HAB", "AUV", "AVI", "AWA", "AYD", "AYM", "AYU",
			"AZE", "AZT", "BAD", "BAG", "BAU", "BAL", "BAN", "BAS", "BAY",
			"BYL", "BYM", "BYS", "BRT", "BEJ", "BEL", "BGL", "BEN", "BER",
			"BRG", "BRN", "BIJ", "BIM", "BIS", "BLA", "BOR", "BOH", "BOI",
			"BOV", "BOL", "BOS", "BOU", "HAU", "BRA", "BRZ", "BRE", "BRL",
			"CBE", "BRI", "BEI", "BRU", "BUD", "BUG", "BUK", "BUL", "BUN",
			"BNY", "BUR", "MYA", "BRY", "BUT", "BYZ", "CAJ", "CLF", "CAL",
			"CAM", "CND", "CNI", "CAN", "CRC", "CAS", "CAT", "CTW", "CAR",
			"CPH", "CHC", "CHG", "CHA", "CMG", "CRG", "CHE", "CHY", "CHB",
			"CHK", "CNG", "CHL", "CHM", "CHI", "CHN", "CHR", "CHT", "CHO",
			"CHU", "CUG", "KLE", "KOL", "COL", "COM", "CNS", "CON", "CNW",
			"COR", "CSR", "KUR", "CEE", "CEK", "CRE", "CRI", "CRO", "CUB",
			"CUS", "CYP", "CYR", "DAH", "DAI", "DAK", "DAL", "DAG", "DAR",
			"DAS", "DAU", "DAX", "DEL", "DLH", "DEM", "DAN", "DMN", "DUL",
			"DUR", "CDE", "CDW", "DZU", "ECU", "EDE", "EGE", "EGY", "ELS",
			"ENG", "EPI", "ERE", "SAE", "ETH", "FAE", "FAN", "FER", "FEZ",
			"FIN", "FIR", "FLA", "FOI", "FRA", "FRC", "FFT", "FNK", "FRE",
			"FUC", "FRS", "FRI", "FUL", "GLC", "GLL", "VOL", "GAL", "GEL",
			"GNV", "GEN", "GEO", "GER", "GMY", "GHA", "GOL", "STE", "GON",
			"GOT", "GRA", "GBR", "GCL", "GRE", "GRO", "GUA", "GUT", "GUJ",
			"GIA", "GUR", "GWA", "HMI", "HAD", "HAH", "HNT", "HAI", "HAL",
			"HAM", "HAN", "HSA", "HAS", "HAW", "ARA", "HED", "HEK", "HES",
			"HOC", "HLL", "HND", "HOY", "HUD", "FPR", "HUN", "HUR", "HYD",
			"ICE", "IGA", "ILK", "ILL", "IME", "INC", "IND", "INS", "ING",
			"IOI", "EIR", "OHI", "ISA", "ISH", "IST", "ITA", "JAI", "JAM",
			"NIP", "JAU", "JEN", "JER", "JIC", "JOD", "JOL", "JUT", "JUE",
			"KAF", "KAK", "KLT", "KNB", "KAN", "KAR", "KSI", "KTL", "KSH",
			"KAZ", "KHM", "KHA", "KZK", "KOI", "KOK", "KHS", "KHO", "KHT",
			"KIL", "KLA", "KNI", "KON", "KOR", "KRA", "KRD", "KTC", "KUT",
			"KYO", "KUS", "KRN", "LAI", "LAK", "LAN", "LAU", "LEI", "LEN",
			"LEO", "LIB", "LIE", "LIP", "LIT", "LIV", "LOA", "LOR", "LOU",
			"BYN", "LUA", "LUB", "LUC", "LUN", "LUW", "LUX", "LUE", "BLC",
			"MDW", "MAD", "MAG", "MGN", "MRA", "MAH", "MAI", "MAJ", "MKS",
			"MLC", "MWI", "MAL", "MLI", "MLL", "MLW", "MCH", "MNI", "MAN",
			"MSC", "MSV", "MAS", "MTR", "MAA", "MEA", "MEC", "MEI", "MEN",
			"MES", "MET", "MEW", "MEX", "MIK", "MLO", "MIS", "MIX", "MOD",
			"MDC", "MGD", "MOH", "MOL", "MOM", "MNG", "MNT", "MRV", "MRE",
			"MOR", "MOG", "MUL", "MST", "MUR", "MOS", "MSK", "ZIM", "MUN",
			"MYS", "MZB", "NAJ", "NAP", "NAS", "NCH", "NVJ", "NAV", "NAX",
			"NDO", "NEI", "NEP", "HOL", "NEV", "NWZ", "NGU", "NCR", "NKO",
			"NOG", "NRM", "NOR", "NVG", "NUB", "NUE", "OEL", "OIR", "OLD",
			"OMA", "OPP", "ORI", "ORK", "ORL", "ORM", "TUR", "OYO", "PAG",
			"PAL", "PNM", "PAP", "PRG", "PAR", "PAW", "PEG", "PAK", "PRM",
			"PER", "PEU", "PIA", "POD", "POI", "POL", "PMR", "POM", "POS",
			"POW", "POR", "PON", "POT", "PWA", "PRO", "PRU", "PSK", "PUN",
			"PRH", "PUR", "QAR", "QUA", "QUE", "QUI", "RAG", "RAM", "RAV",
			"REG", "REI", "PFA", "RHI", "RIO", "ROM", "RPR", "ROY", "RUS",
			"RAC", "RWA", "RYA", "RYU", "SLZ", "SAM", "SMT", "SAN", "SNH",
			"SNT", "SAR", "SAV", "SAG", "SAL", "SAW", "SWI", "SAC", "SCH",
			"SHL", "SRU", "SCO", "SEN", "SFU", "SER", "SHA", "SHW", "SLL",
			"SHZ", "SHI", "SIB", "SIC", "PIS", "SIL", "SND", "SIO", "SKA",
			"SMO", "SOL", "SON", "SOU", "SPR", "SPA", "SRI", "SEI", "STR",
			"SUD", "SUL", "SUZ", "SWA", "SWE", "HEL", "TAI", "TAU", "TEK",
			"TKK", "TEM", "TER", "TES", "LAT", "TEX", "THA", "THE", "THU",
			"TIB", "TID", "TIM", "TLA", "TLE", "TON", "TOU", "SIE", "TRA",
			"TRE", "TRN", "TIE", "TRI", "TRP", "TSW", "TUA", "TUN", "TOS",
			"TUS", "TUT", "TVE", "TWS", "TYR", "UKR", "ULS", "UNA", "KAL",
			"UBD", "UKI", "USA", "BYU", "URU", "UTR", "UZB", "VAL", "VNZ",
			"VEN", "VRM", "VER", "VIE", "VIJ", "WAG", "WLY", "WLS", "WAL",
			"WAR", "WER", "WFL", "WES", "WUR", "WRZ", "WAA", "XHO", "YAN",
			"YAZ", "YEM", "YUC", "YUP", "ZAN", "ZAP", "ZAR", "ZEA", "ZEE",
			"ZHO", "ZUL" };

	public static JFrame frame;
	public static JPanel trigger, scenario, options, preview, date, deathdate;
	public static GridBagLayout layout;

	// Options
	public JLabel lblName;
	public JTextField txtName;

	public JLabel lblDescription;
	public JScrollPane scrDescription;
	public JTextArea txtaDescription;

	public JCheckBox chkRandom;

	public JLabel lblComment;
	public JScrollPane scrComment;
	public JTextArea txtaComment;

	public JLabel lblID;
	public JTextField txtID;

	public JLabel lblCountry;
	public JComboBox jcbCountry;

	// Date
	public JComboBox jcbDateDay;
	public JComboBox jcbDateMonth;
	public JTextField txtDateYear;

	public JComboBox jcbDeathdateDay;
	public JComboBox jcbDeathdateMonth;
	public JTextField txtDeathdateYear;

	// Preview
	JTextArea edtPreview;
	JScrollPane scrPreview;
	JButton btnSave;
	JButton btnLoad;
	JButton btnRefresh;

	// Trigger
	JScrollPane scrTrigger;
	static JTextArea txtaTrigger;

	// Scenario
	JScrollPane scrScenario;
	static JTextArea txtaScenario;

	public static int width, height;

	public GUI() {

		layout = new GridBagLayout();

		frame = new JFrame("FTG Mod Development Tool | " + FTG.version);
		frame.setSize(900, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);

		new Main();
		
		optionsPnl();
		datePnl();
		deathdatePnl();
		previewPnl();
		triggerPnl();
		scenarioPnl();
		frame.setVisible(true);
	}

	static void addComponent(Container cont, GridBagLayout gbl, Component c,
			int x, int y, int width, int height, double weightx,
			double weighty, Insets insets) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.insets = insets;
		gbl.setConstraints(c, gbc);
		cont.add(c);
	}

	void optionsPnl() {

		GridBagLayout lytOptions = new GridBagLayout();

		options = new JPanel();
		options.setBorder(BorderFactory.createTitledBorder("Options"));
		options.setLayout(lytOptions);

		lblName = new JLabel("Name:");
		addComponent(options, lytOptions, lblName, 1, 1, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		txtName = new JTextField("Event1");
		addComponent(options, lytOptions, txtName, 2, 1, 1, 1, 0.5, 0,
				new Insets(5, 5, 5, 5));

		lblID = new JLabel("ID:");
		addComponent(options, lytOptions, lblID, 3, 1, 1, 1, 0, 0, new Insets(
				5, 5, 5, 5));
		txtID = new JTextField("");
		addComponent(options, lytOptions, txtID, 4, 1, 1, 1, 0.5, 0,
				new Insets(5, 5, 5, 5));

		lblDescription = new JLabel("Description");
		addComponent(options, lytOptions, lblDescription, 1, 2, 2, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		txtaDescription = new JTextArea("");
		scrDescription = new JScrollPane(txtaDescription);
		addComponent(options, lytOptions, scrDescription, 1, 3, 2, 1, 0, 1,
				new Insets(5, 5, 5, 5));

		chkRandom = new JCheckBox("random");
		addComponent(options, lytOptions, chkRandom, 1, 4, 2, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		lblComment = new JLabel("Head Comment");
		addComponent(options, lytOptions, lblComment, 3, 2, 2, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		txtaComment = new JTextArea("");
		scrComment = new JScrollPane(txtaComment);
		addComponent(options, lytOptions, scrComment, 3, 3, 2, 1, 0, 1,
				new Insets(5, 5, 5, 5));

		jcbCountry = new JComboBox(country);
		addComponent(options, lytOptions, jcbCountry, 3, 4, 2, 1, 0, 0,
				new Insets(5, 5, 5, 5));

		addComponent(frame.getContentPane(), layout, options, 1, 1, 2, 1, 1, 1,
				new Insets(5, 5, 5, 5));
	}

	void datePnl() {

		date = new JPanel();
		date.setBorder(BorderFactory.createTitledBorder("Startdate"));

		GridBagLayout lytDate = new GridBagLayout();

		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		String[] months = { "january", "february", "march", "april", "mai",
				"june", "july", "august", "september", "october", "november",
				"december" };
		jcbDateDay = new JComboBox(days);
		jcbDateMonth = new JComboBox(months);
		txtDateYear = new JTextField("1337");

		addComponent(date, lytDate, jcbDateDay, 1, 1, 1, 1, 1, 1, new Insets(5,
				5, 5, 5));
		addComponent(date, lytDate, jcbDateMonth, 2, 1, 1, 1, 1, 1, new Insets(
				5, 5, 5, 5));
		addComponent(date, lytDate, txtDateYear, 3, 1, 1, 1, 1, 1, new Insets(
				5, 5, 5, 5));

		addComponent(frame.getContentPane(), layout, date, 1, 2, 1, 1, 1, 0.1,
				new Insets(5, 5, 5, 5));
		// new TriggerTest();
	}

	void deathdatePnl() {

		deathdate = new JPanel();
		deathdate.setBorder(BorderFactory.createTitledBorder("Deathdate"));

		GridBagLayout lytDeathdate = new GridBagLayout();

		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		String[] months = { "january", "february", "march", "april", "mai",
				"june", "july", "august", "september", "october", "november",
				"december" };
		jcbDeathdateDay = new JComboBox(days);
		jcbDeathdateMonth = new JComboBox(months);
		txtDeathdateYear = new JTextField("1337");

		addComponent(deathdate, lytDeathdate, jcbDeathdateDay, 1, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, jcbDeathdateMonth, 2, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, txtDeathdateYear, 3, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));

		addComponent(frame.getContentPane(), layout, deathdate, 2, 2, 1, 1, 1,
				0.1, new Insets(5, 5, 5, 5));
		// new TriggerTest();
	}

	void triggerPnl() {

		trigger = new JPanel();
		trigger.setBorder(BorderFactory.createTitledBorder("Trigger"));
		GridBagLayout lytTrigger = new GridBagLayout();

		txtaTrigger = new JTextArea("");
		scrTrigger = new JScrollPane(txtaTrigger);
		GUI.trigger.setLayout(lytTrigger);
		addComponent(trigger, lytTrigger, scrTrigger, 1, 2, 1, 1, 1, 1,
				new Insets(5, 5, 5, 5));

		addComponent(trigger, lytTrigger, Main.panel, 1, 1, 1, 1, 1, 1,  new Insets(5, 5, 5, 5));
		
		// new TriggerPanel();

		addComponent(frame.getContentPane(), layout, trigger, 1, 3, 2, 1, 1, 1,
				new Insets(5, 5, 5, 5));
	}

	void scenarioPnl() {

		scenario = new JPanel();
		scenario.setBorder(BorderFactory.createTitledBorder("Scenario"));

		GridBagLayout lytScenario = new GridBagLayout();

		txtaScenario = new JTextArea("asd");
		scrScenario = new JScrollPane(txtaScenario);
		GUI.trigger.setLayout(lytScenario);
		addComponent(scenario, lytScenario, scrScenario, 1, 2, 1, 1, 1, 1,
				new Insets(5, 5, 5, 5));

		addComponent(scenario, lytScenario, Main.panel2, 1, 1, 1, 1, 1, 1,  new Insets(5, 5, 5, 5));

		addComponent(frame.getContentPane(), layout, scenario, 1, 4, 2, 1, 1,
				1, new Insets(5, 5, 5, 5));
	}

	void previewPnl() {

		preview = new JPanel();
		preview.setBorder(BorderFactory.createTitledBorder("Preview"));

		GridBagLayout lytPreview = new GridBagLayout();
		preview.setLayout(lytPreview);

		edtPreview = new JTextArea("Felix Aufgabe");
		scrPreview = new JScrollPane(edtPreview);

		btnRefresh = new JButton("Refresh");
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");

		btnRefresh.addActionListener(this);
		btnSave.addActionListener(this);
		btnLoad.addActionListener(this);

		addComponent(preview, lytPreview, scrPreview, 1, 1, 3, 1, 1, 1,
				new Insets(5, 5, 5, 5));

		addComponent(preview, lytPreview, btnRefresh, 1, 2, 1, 1, 0.3, 0,
				new Insets(5, 5, 5, 5));

		addComponent(preview, lytPreview, btnSave, 2, 2, 1, 1, 0.3, 0,
				new Insets(5, 5, 5, 5));

		addComponent(preview, lytPreview, btnLoad, 3, 2, 1, 1, 0.3, 0,
				new Insets(5, 5, 5, 5));

		addComponent(frame.getContentPane(), layout, preview, 3, 1, 2, 5, 2, 1,
				new Insets(5, 5, 5, 5));
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == btnRefresh) {

			FTG.properties.setProperty("name", txtName.getText());
			FTG.properties.setProperty("id", txtID.getText());
			FTG.properties
					.setProperty("description", txtaDescription.getText());
			FTG.properties.setProperty("comment", txtaComment.getText());

			// TODO Felix!
		}

		if (ae.getSource() == btnSave) {

			// TODO Felix!
		}

		if (ae.getSource() == btnLoad) {

			txtName.setText(FTG.properties.getProperty("name"));
			txtID.setText(FTG.properties.getProperty("id"));
			txtaComment.setText(FTG.properties.getProperty("comment"));
			txtaDescription.setText(FTG.properties.getProperty("description"));
			if (FTG.properties.getProperty("random") == "1")
				chkRandom.setSelected(true);
			else
				chkRandom.setSelected(false);
			jcbCountry.setSelectedIndex(Arrays.binarySearch(country,
					FTG.properties.getProperty("country")));

			// TODO Felix!
		}

	}

}
