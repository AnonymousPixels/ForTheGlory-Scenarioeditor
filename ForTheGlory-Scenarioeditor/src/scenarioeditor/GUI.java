package scenarioeditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is more or less the second main class, because it doesn't just
 * create the graphical user interface, it also handles the most of the program
 * flow
 * 
 * @author Felix Beutter
 */

public class GUI implements ActionListener, ChangeListener {

	JFrame frame;
	GridBagLayout layout;
	JPanel panel, pnlMap, pnlOther, pnlGeneral, pnlProvinces, pnlCountries, pnlCountrySettings, pnlCountry,
			pnlCountryPolicy, pnlPolicyDate, pnlCountryGeneral, pnlCountryTechnology, pnlCountryDiplomacy,
			pnlCountryUnits, pnlTechnology, pnlProvincesControl, pnlColonialAttempts, pnlCountryGeneralBooleans,
			pnlCountryGeneralTxf, pnlDiplomacyRelation, pnlCasusBelli, pnlWarned, pnlIndependence, pnlPeace, pnlUnits,
			pnlUnitNumbers, pnlNavalUnits, pnlNavalUnitNumbers;
	JTabbedPane tabbedPane;
	JSplitPane splitPane;
	MapPanel map;
	static JComboBox<String> cbxCountry, cbxCategory, cbxPolicyDateMonth, cbxTechnologyGroup, cbxAi, cbxMonarchtable,
			cbxLeadertable, cbxSelectedProvince, cbxCopy, cbxCulture, cbxReligion, cbxSelectedCountry, cbxCasusBelli,
			cbxCasusBelliMonth, cbxWarnedMonth, cbxIndependenceMonth, cbxPeaceMonth, cbxUnits, cbxUnitLocation,
			cbxNavalUnits, cbxNavalUnitLocation, cbxPolicyDateDay, cbxCasusBelliDay, cbxWarnedDay, cbxIndependenceDay,
			cbxPeaceDay;
	JScrollPane scpCountrySettings, scpProvinces;
	JTextField txfPolicyDateYear, txfTechnologyLand, txfTechnologyNaval, txfTechnologyTrade, txfTechnologyInfra,
			txfTechnologyStability, txfColonialAttempts, txfLoansize, txfTreasury, txfInflation, txfMissionaries,
			txfMerchants, txfDiplomats, txfWhiteMan, txfColonists, txfBadboy, txfDiplomacyRelation, txfCasusBelliYear,
			txfWarnedYear, txfIndependenceYear, txfPeaceYear, txfInfantry, txfCavalry, txfArtillery, txfWarships,
			txfGalleys, txfTransports;
	JLabel lblCountry, lblCategory, lblPolicyDate, lblAristocracy, lblCentralization, lblInnovative, lblMercantilism,
			lblOffensive, lblLand, lblQuality, lblSerfdom, lblTechnologyLand, lblTechnologyNaval, lblStability,
			lblTrade, lblInfra, lblTechnologyGroup, lblAi, lblMonarchtable, lblLeadertable, lblSelectedProvince,
			lblCopy, lblColonialAttempts, lblColonialnation, lblCancelledLoans, lblExtendedLoans, lblLoansize,
			lblTreasury, lblInflation, lblColonists, lblMerchants, lblDiplomats, lblMissionaries, lblBadBoy,
			lblWhiteMan, lblCulture, lblReligion, lblSelectedCountry, lblDiplomacyRelation, lblCasusBelliType,
			lblCasusBelliDate, lblWarned, lblIndependence, lblPeace, lblArmy, lblUnitLocation, lblInfantry, lblCavalry,
			lblArtillery, lblNavy, lblNavalUnitLocation, lblWarships, lblGalleys, lblTransports;
	JButton btnLoad, btnSave, btnCountryDelete, btnUnitAdd, btnUnitRename, btnUnitDel, btnNavalUnitAdd,
			btnNavalUnitRename, btnNavalUnitDel;
	static JSlider sldAristocracy, sldCentralization, sldInnovative, sldMercantilism, sldOffensive, sldLand, sldQuality,
			sldSerfdom;
	JRadioButton rbnOwnProvinces, rbnControlledProvinces, rbnNationalProvinces, rbnKnownProvinces,
			rbnColonialnationTrue, rbnColonialnationFalse, rbnCancelledLoansTrue, rbnCancelledLoansFalse,
			rbnExtendedLoansTrue, rbnExtendedLoansFalse;
	JCheckBox chbMajorProvince, chbTradeAgreement, chbMilitaryAccess, chbRefuseTrade, chbCasusBelli;
	ButtonGroup grpProvinces, grpColonialnation, grpCancelledLoans, grpExtendedLoans;
	BufferedImage imgFrontend, imgBackend;
	ColonyPanel colonyPanel;
	GlobalDataPanel globalDataPanel;
	GameFiles gameFiles;
	HashMap<Color, Integer> hashMap = new HashMap<Color, Integer>();
	HashMap<String, String> values = new HashMap<String, String>();
	HashMap<String, String[]> selectables = new HashMap<String, String[]>();
	static HashMap<String, Object> dataMap = new HashMap<String, Object>();
	Dimension minSize = new Dimension(1200, 720);
	Color clrBackground = new Color(240, 240, 240), clrStandard = new Color(0, 0, 0);
	Font fntStandard = new Font("Verdana", 0, 12);
	static String name = Strings.getString("name"), version = Strings.getString("version"),
			build = Strings.getString("build"), title = name + " | Version: " + version + " (Build: " + build + ")",
			scenarioFilePath = "C://Program Files (x86)//Steam//steamapps//common//For The Glory//Scenarios//1419 - The Grand Campaign.eeg",
			selectedCountryItem;
	String[] months = { Strings.getString("Month.1"), Strings.getString("Month.2"), Strings.getString("Month.3"),
			Strings.getString("Month.4"), Strings.getString("Month.5"), Strings.getString("Month.6"),
			Strings.getString("Month.7"), Strings.getString("Month.8"), Strings.getString("Month.9"),
			Strings.getString("Month.10"), Strings.getString("Month.11"), Strings.getString("Month.12") },
			CountryCategories = { Strings.getString("Category.1"), Strings.getString("Category.2"),
					Strings.getString("Category.3"), Strings.getString("Category.4"), Strings.getString("Category.5") },
			CasusBelliTypes = { Strings.getString("CasusBelliPermanent"), Strings.getString("CasusBelliTemporary") },
			climate = { "arctic", "tropical", "temperate", "ncontinental", "scontinental", "tundra", "desertic" },
			days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
					"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };

	public GUI() throws IOException, InterruptedException {

		readData();

		layout = new GridBagLayout();

		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(layout);
		frame.setMinimumSize(minSize);

		panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(clrBackground);
		addComponent(frame, layout, panel, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		splitPane = new JSplitPane();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

		pnlMap = new JPanel();
		pnlMap.setLayout(layout);
		pnlMap.setBackground(clrBackground);

		splitPane.setLeftComponent(pnlMap);
		splitPane.setRightComponent(tabbedPane);

		splitPane.setResizeWeight(1);

		pnlOther = new JPanel();
		pnlOther.setLayout(layout);
		pnlOther.setBackground(clrBackground);

		addComponent(pnlOther, layout, new JPanel(), 0, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		btnLoad = new JButton(Strings.getString("GUI.3"));
		btnLoad.addActionListener(this);
		btnLoad.setEnabled(false);
		addComponent(pnlOther, layout, btnLoad, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		btnSave = new JButton(Strings.getString("GUI.4"));
		btnSave.addActionListener(this);
		addComponent(pnlOther, layout, btnSave, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		try {

			imgFrontend = ImageIO.read(GUI.class.getResource("/frontend.png"));
			imgBackend = ImageIO.read(GUI.class.getResource("/backend.png"));
			map = new MapPanel(imgFrontend, imgBackend,
					LoadMapFile.LoadFile(new File(GUI.class.getResource("/affiliation.txt").getPath())));

		} catch (IOException e) {

			System.out.println("Error while reading images! Program shuts down...");
			System.exit(1);
		}

		// if (!createHashMap(new File(Main.path + "\\affiliation.txt"))) {
		//
		// System.out
		// .println("Error while reading 'affiliation.txt'! Program shuts
		// down...");
		// System.exit(1);
		// }

		fillHashMaps();

		createPnlProvinces();
		createPnlGeneral();
		createPnlCountries();

		addComponent(pnlMap, layout, map, 0, 0, 1, 1, 1, 1, new Insets(10, 10, 10, 10));
		addComponent(pnlMap, layout, pnlOther, 0, 1, 1, 1, 1, 0, new Insets(0, 10, 10, 10));
		addComponent(panel, layout, splitPane, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		tabbedPane.add(Strings.getString("GUI.0"), pnlGeneral);
		tabbedPane.add(Strings.getString("GUI.1"), pnlProvinces);
		tabbedPane.add(Strings.getString("GUI.2"), pnlCountries);
		tabbedPane.setPreferredSize(new Dimension(280, 500));

		setData(dataMap);

		Main.finishedLoading = true;

		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	static void setData(HashMap<String, Object> map) {

		// Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		// while (it.hasNext()) {
		// @SuppressWarnings("rawtypes")
		// Map.Entry pair = (Map.Entry) it.next();
		// System.out.println(pair.getKey() + " = " + pair.getValue());
		// }

		Set<String> keys = ((HashMap<String, Object>) map.get("countrydata")).keySet();
		String[] coutryTags = keys.toArray(new String[keys.size()]);
		Arrays.sort(coutryTags);
		cbxCountry.removeAll();
		for (String s : coutryTags)
			if (!s.equals(""))
				cbxCountry.addItem(s);

		selectedCountryItem = coutryTags[0];
		setValues(map);
	}

	static void setValues(HashMap<String, Object> map) {

		sldAristocracy.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("aristocracy")));
		sldCentralization.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("centralization")));
		sldInnovative.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("innovative")));
		sldMercantilism.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("mercantilism")));
		sldOffensive.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("offensive")));
		sldLand.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("land")));
		sldQuality.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("quality")));
		sldSerfdom.setValue(
				Integer.parseInt((String) ((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata"))
						.get(cbxCountry.getSelectedItem())).get("serfdom")));
	}

	void saveValues(HashMap<String, Object> map) {

		if (selectedCountryItem != null) {

			if (sldAristocracy != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("aristocracy", String.valueOf(sldAristocracy.getValue()));
			if (sldCentralization != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("centralization", String.valueOf(sldCentralization.getValue()));
			if (sldInnovative != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("innovative", String.valueOf(sldInnovative.getValue()));
			if (sldMercantilism != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("mercantilism", String.valueOf(sldMercantilism.getValue()));
			if (sldOffensive != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("offensive", String.valueOf(sldOffensive.getValue()));
			if (sldLand != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("land", String.valueOf(sldLand.getValue()));
			if (sldQuality != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("quality", String.valueOf(sldQuality.getValue()));
			if (sldSerfdom != null)
				((HashMap<String, Object>) ((HashMap<String, Object>) map.get("countrydata")).get(selectedCountryItem))
						.put("serfdom", String.valueOf(sldSerfdom.getValue()));
		}
	}

	static HashMap<String, Object> getData() {

		// TODO fill dataMap

		return dataMap;
	}

	void readData() {

		try {
			dataMap = Settings.getSettings(Main.path, scenarioFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void fillHashMaps() {

		values.put("id", "1");
		values.put("name", "Test");
		values.put("manpower", "1444555");
		values.put("income", "245");
		values.put("value", "0");
		values.put("cotmodifier", "0");
		values.put("colonizationdifficulty", "0");
		values.put("lootedYear", "0");
		values.put("religion", "hussite");
		values.put("terrain", "plains");
		values.put("culture", "abenaki");
		values.put("climate", "arctic");
		values.put("goods", "cloth");
		values.put("looted", "true");
		values.put("whiteman", "true");
	}

	void createPnlGeneral() throws IOException {

		pnlGeneral = new JPanel();
		pnlGeneral.setLayout(layout);
		pnlGeneral.setBackground(clrBackground);

		selectables.put("continent", GameFiles.loadTags("continent"));
		selectables.put("area", GameFiles.loadTags("area"));
		selectables.put("region", GameFiles.loadTags("region"));

		globalDataPanel = new GlobalDataPanel(values, selectables);

		// scpProvinces = new JScrollPane(globalDataPanel);
		// scpProvinces.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scpProvinces.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addComponent(pnlGeneral, layout, globalDataPanel, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlProvinces() throws IOException {

		pnlProvinces = new JPanel();
		pnlProvinces.setLayout(layout);
		pnlProvinces.setBackground(clrBackground);

		gameFiles = new GameFiles(Main.path + "\\");

		selectables.put("terrain", gameFiles.loadTerrains());
		selectables.put("climate", climate);
		selectables.put("religion", gameFiles.loadReligions());
		selectables.put("culture", gameFiles.loadCultures());
		selectables.put("goods", gameFiles.loadGoods());

		colonyPanel = new ColonyPanel(values, selectables);

		// scpProvinces = new JScrollPane(colonyPanel);
		// scpProvinces.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scpProvinces.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addComponent(pnlProvinces, layout, colonyPanel, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlCountries() {

		int y = 0;

		pnlCountries = new JPanel();
		pnlCountries.setLayout(layout);
		pnlCountries.setBackground(clrBackground);

		lblCountry = new JLabel(Strings.getString("GUI.5"), SwingConstants.LEFT);
		lblCountry.setForeground(clrStandard);
		lblCountry.setFont(fntStandard);
		addComponent(pnlCountries, layout, lblCountry, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		pnlCountry = new JPanel();
		pnlCountry.setLayout(layout);
		pnlCountry.setBackground(clrBackground);
		addComponent(pnlCountries, layout, pnlCountry, 0, y, 1, 1, 1, 0, new Insets(0, 0, 0, 0));
		y++;

		cbxCountry = new JComboBox<String>();
		cbxCountry.addActionListener(this);
		addComponent(pnlCountry, layout, cbxCountry, 0, 0, 1, 1, 1, 0, new Insets(0, 5, 5, 5));

		btnCountryDelete = new JButton(Strings.getString("GUI.6"));
		btnCountryDelete.addActionListener(this);
		addComponent(pnlCountry, layout, btnCountryDelete, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		lblCategory = new JLabel(Strings.getString("GUI.7"), SwingConstants.LEFT);
		lblCategory.setForeground(clrStandard);
		lblCategory.setFont(fntStandard);
		addComponent(pnlCountries, layout, lblCategory, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxCategory = new JComboBox<String>(CountryCategories);
		cbxCategory.addActionListener(this);
		addComponent(pnlCountries, layout, cbxCategory, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlCountrySettings = new JPanel();
		pnlCountrySettings.setLayout(layout);
		pnlCountrySettings.setBackground(clrBackground);

		scpCountrySettings = new JScrollPane(pnlCountrySettings);
		scpCountrySettings.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scpCountrySettings.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addComponent(pnlCountries, layout, scpCountrySettings, 0, y, 1, 1, 1, 1, new Insets(5, 5, 10, 5));
		y++;

		createPnlCountrySettings();
	}

	void createPnlCountrySettings() {

		createPnlCountryGeneral();
		createPnlCountryPolicy();
		createPnlCountryTechnology();
		createPnlCountryDiplomacy();
		createPnlCountryUnits();

		pnlCountryGeneral.setVisible(true);
		pnlCountryPolicy.setVisible(false);
		pnlCountryTechnology.setVisible(false);
		pnlCountryDiplomacy.setVisible(false);
		pnlCountryUnits.setVisible(false);
	}

	void createPnlCountryGeneral() {

		int y = 0;

		pnlCountryGeneral = new JPanel();
		pnlCountryGeneral.setLayout(layout);
		pnlCountryGeneral.setBackground(clrBackground);
		addComponent(pnlCountrySettings, layout, pnlCountryGeneral, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		pnlProvincesControl = new JPanel();
		pnlProvincesControl.setLayout(layout);
		pnlProvincesControl.setBackground(clrBackground);
		pnlProvincesControl.setBorder(BorderFactory.createTitledBorder(Strings.getString("GUI.35")));
		addComponent(pnlCountryGeneral, layout, pnlProvincesControl, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		rbnOwnProvinces = new JRadioButton(Strings.getString("GUI.36"));
		rbnOwnProvinces.addChangeListener(this);
		rbnOwnProvinces.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, rbnOwnProvinces, 0, 0, 1, 1, 0, 0, new Insets(5, 5, 5, 5));

		rbnControlledProvinces = new JRadioButton(Strings.getString("GUI.37"));
		rbnControlledProvinces.addChangeListener(this);
		rbnControlledProvinces.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, rbnControlledProvinces, 1, 0, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		rbnNationalProvinces = new JRadioButton(Strings.getString("GUI.38"));
		rbnNationalProvinces.addChangeListener(this);
		rbnNationalProvinces.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, rbnNationalProvinces, 0, 1, 1, 1, 0, 0, new Insets(0, 5, 5, 5));

		rbnKnownProvinces = new JRadioButton(Strings.getString("GUI.39"));
		rbnKnownProvinces.addChangeListener(this);
		rbnKnownProvinces.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, rbnKnownProvinces, 1, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		grpProvinces = new ButtonGroup();
		grpProvinces.add(rbnOwnProvinces);
		grpProvinces.add(rbnControlledProvinces);
		grpProvinces.add(rbnNationalProvinces);
		grpProvinces.add(rbnKnownProvinces);

		lblSelectedProvince = new JLabel(Strings.getString("GUI.40"), SwingConstants.LEFT);
		lblSelectedProvince.setForeground(clrStandard);
		lblSelectedProvince.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, lblSelectedProvince, 0, 2, 2, 1, 1, 0, new Insets(5, 5, 5, 5));

		cbxSelectedProvince = new JComboBox<String>();
		cbxSelectedProvince.addActionListener(this);
		addComponent(pnlProvincesControl, layout, cbxSelectedProvince, 0, 3, 2, 1, 1, 0, new Insets(0, 5, 5, 5));

		chbMajorProvince = new JCheckBox(Strings.getString("GUI.41"));
		chbMajorProvince.setSelected(false);
		chbMajorProvince.setForeground(clrStandard);
		chbMajorProvince.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, chbMajorProvince, 0, 4, 2, 1, 1, 0, new Insets(5, 5, 5, 5));

		lblCopy = new JLabel(Strings.getString("GUI.42"), SwingConstants.LEFT);
		lblCopy.setForeground(clrStandard);
		lblCopy.setFont(fntStandard);
		addComponent(pnlProvincesControl, layout, lblCopy, 0, 5, 2, 1, 1, 0, new Insets(0, 5, 5, 5));

		cbxCopy = new JComboBox<String>();
		cbxCopy.addActionListener(this);
		addComponent(pnlProvincesControl, layout, cbxCopy, 0, 6, 2, 1, 1, 0, new Insets(0, 5, 5, 5));

		lblCulture = new JLabel(Strings.getString("GUI.58"), SwingConstants.LEFT);
		lblCulture.setForeground(clrStandard);
		lblCulture.setFont(fntStandard);
		addComponent(pnlCountryGeneral, layout, lblCulture, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		cbxCulture = new JComboBox<String>();
		cbxCulture.addActionListener(this);
		addComponent(pnlCountryGeneral, layout, cbxCulture, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblReligion = new JLabel(Strings.getString("GUI.59"), SwingConstants.LEFT);
		lblReligion.setForeground(clrStandard);
		lblReligion.setFont(fntStandard);
		addComponent(pnlCountryGeneral, layout, lblReligion, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxReligion = new JComboBox<String>();
		cbxReligion.addActionListener(this);
		addComponent(pnlCountryGeneral, layout, cbxReligion, 0, y, 1, 1, 1, 0, new Insets(0, 5, 10, 5));
		y++;

		pnlCountryGeneralBooleans = new JPanel();
		pnlCountryGeneralBooleans.setLayout(layout);
		pnlCountryGeneralBooleans.setBackground(clrBackground);
		addComponent(pnlCountryGeneral, layout, pnlCountryGeneralBooleans, 0, y, 1, 1, 1, 0, new Insets(0, 5, 10, 5));
		y++;

		lblColonialnation = new JLabel(Strings.getString("GUI.44"), SwingConstants.LEFT);
		lblColonialnation.setForeground(clrStandard);
		lblColonialnation.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, lblColonialnation, 0, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 5));

		rbnColonialnationTrue = new JRadioButton(Strings.getString("GUI.45"));
		rbnColonialnationTrue.addChangeListener(this);
		rbnColonialnationTrue.setFont(fntStandard);
		rbnColonialnationTrue.setSelected(true);
		addComponent(pnlCountryGeneralBooleans, layout, rbnColonialnationTrue, 1, 0, 1, 1, 0, 0,
				new Insets(0, 0, 0, 5));

		rbnColonialnationFalse = new JRadioButton(Strings.getString("GUI.46"));
		rbnColonialnationFalse.addChangeListener(this);
		rbnColonialnationFalse.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, rbnColonialnationFalse, 2, 0, 1, 1, 0, 0,
				new Insets(0, 0, 0, 0));

		grpColonialnation = new ButtonGroup();
		grpColonialnation.add(rbnColonialnationTrue);
		grpColonialnation.add(rbnColonialnationFalse);

		lblCancelledLoans = new JLabel(Strings.getString("GUI.47"), SwingConstants.LEFT);
		lblCancelledLoans.setForeground(clrStandard);
		lblCancelledLoans.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, lblCancelledLoans, 0, 1, 1, 1, 1, 0, new Insets(0, 0, 0, 5));

		rbnCancelledLoansTrue = new JRadioButton(Strings.getString("GUI.45"));
		rbnCancelledLoansTrue.addChangeListener(this);
		rbnCancelledLoansTrue.setFont(fntStandard);
		rbnCancelledLoansTrue.setSelected(true);
		addComponent(pnlCountryGeneralBooleans, layout, rbnCancelledLoansTrue, 1, 1, 1, 1, 0, 0,
				new Insets(0, 0, 0, 5));

		rbnCancelledLoansFalse = new JRadioButton(Strings.getString("GUI.46"));
		rbnCancelledLoansFalse.addChangeListener(this);
		rbnCancelledLoansFalse.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, rbnCancelledLoansFalse, 2, 1, 1, 1, 0, 0,
				new Insets(0, 0, 0, 0));

		grpCancelledLoans = new ButtonGroup();
		grpCancelledLoans.add(rbnCancelledLoansTrue);
		grpCancelledLoans.add(rbnCancelledLoansFalse);

		lblExtendedLoans = new JLabel(Strings.getString("GUI.48"), SwingConstants.LEFT);
		lblExtendedLoans.setForeground(clrStandard);
		lblExtendedLoans.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, lblExtendedLoans, 0, 2, 1, 1, 1, 0, new Insets(0, 0, 0, 5));

		rbnExtendedLoansTrue = new JRadioButton(Strings.getString("GUI.45"));
		rbnExtendedLoansTrue.addChangeListener(this);
		rbnExtendedLoansTrue.setFont(fntStandard);
		rbnExtendedLoansTrue.setSelected(true);
		addComponent(pnlCountryGeneralBooleans, layout, rbnExtendedLoansTrue, 1, 2, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		rbnExtendedLoansFalse = new JRadioButton(Strings.getString("GUI.46"));
		rbnExtendedLoansFalse.addChangeListener(this);
		rbnExtendedLoansFalse.setFont(fntStandard);
		addComponent(pnlCountryGeneralBooleans, layout, rbnExtendedLoansFalse, 2, 2, 1, 1, 0, 0,
				new Insets(0, 0, 0, 0));

		grpExtendedLoans = new ButtonGroup();
		grpExtendedLoans.add(rbnExtendedLoansTrue);
		grpExtendedLoans.add(rbnExtendedLoansFalse);

		pnlCountryGeneralTxf = new JPanel();
		pnlCountryGeneralTxf.setLayout(layout);
		pnlCountryGeneralTxf.setBackground(clrBackground);
		addComponent(pnlCountryGeneral, layout, pnlCountryGeneralTxf, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblColonialAttempts = new JLabel(Strings.getString("GUI.43"));
		lblColonialAttempts.setForeground(clrStandard);
		lblColonialAttempts.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblColonialAttempts, 0, 0, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfColonialAttempts = new JTextField();
		txfColonialAttempts.setBackground(Color.white);
		txfColonialAttempts.setForeground(clrStandard);
		txfColonialAttempts.setPreferredSize(new Dimension(50, 20));
		txfColonialAttempts.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfColonialAttempts, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblLoansize = new JLabel(Strings.getString("GUI.49"), SwingConstants.LEFT);
		lblLoansize.setForeground(clrStandard);
		lblLoansize.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblLoansize, 0, 1, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfLoansize = new JTextField();
		txfLoansize.setBackground(Color.white);
		txfLoansize.setForeground(clrStandard);
		txfLoansize.setPreferredSize(new Dimension(50, 20));
		txfLoansize.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfLoansize, 1, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblTreasury = new JLabel(Strings.getString("GUI.50"), SwingConstants.LEFT);
		lblTreasury.setForeground(clrStandard);
		lblTreasury.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblTreasury, 0, 2, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfTreasury = new JTextField();
		txfTreasury.setBackground(Color.white);
		txfTreasury.setForeground(clrStandard);
		txfTreasury.setPreferredSize(new Dimension(50, 20));
		txfTreasury.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfTreasury, 1, 2, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblInflation = new JLabel(Strings.getString("GUI.51"), SwingConstants.LEFT);
		lblInflation.setForeground(clrStandard);
		lblInflation.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblInflation, 0, 3, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfInflation = new JTextField();
		txfInflation.setBackground(Color.white);
		txfInflation.setForeground(clrStandard);
		txfInflation.setPreferredSize(new Dimension(50, 20));
		txfInflation.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfInflation, 1, 3, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblColonists = new JLabel(Strings.getString("GUI.52"), SwingConstants.LEFT);
		lblColonists.setForeground(clrStandard);
		lblColonists.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblColonists, 0, 4, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfColonists = new JTextField();
		txfColonists.setBackground(Color.white);
		txfColonists.setForeground(clrStandard);
		txfColonists.setPreferredSize(new Dimension(50, 20));
		txfColonists.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfColonists, 1, 4, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblMerchants = new JLabel(Strings.getString("GUI.53"), SwingConstants.LEFT);
		lblMerchants.setForeground(clrStandard);
		lblMerchants.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblMerchants, 0, 5, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfMerchants = new JTextField();
		txfMerchants.setBackground(Color.white);
		txfMerchants.setForeground(clrStandard);
		txfMerchants.setPreferredSize(new Dimension(50, 20));
		txfMerchants.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfMerchants, 1, 5, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblDiplomats = new JLabel(Strings.getString("GUI.54"), SwingConstants.LEFT);
		lblDiplomats.setForeground(clrStandard);
		lblDiplomats.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblDiplomats, 0, 6, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfDiplomats = new JTextField();
		txfDiplomats.setBackground(Color.white);
		txfDiplomats.setForeground(clrStandard);
		txfDiplomats.setPreferredSize(new Dimension(50, 20));
		txfDiplomats.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfDiplomats, 1, 6, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblMissionaries = new JLabel(Strings.getString("GUI.55"), SwingConstants.LEFT);
		lblMissionaries.setForeground(clrStandard);
		lblMissionaries.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblMissionaries, 0, 7, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfMissionaries = new JTextField();
		txfMissionaries.setBackground(Color.white);
		txfMissionaries.setForeground(clrStandard);
		txfMissionaries.setPreferredSize(new Dimension(50, 20));
		txfMissionaries.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfMissionaries, 1, 7, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblBadBoy = new JLabel(Strings.getString("GUI.56"), SwingConstants.LEFT);
		lblBadBoy.setForeground(clrStandard);
		lblBadBoy.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblBadBoy, 0, 8, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfBadboy = new JTextField();
		txfBadboy.setBackground(Color.white);
		txfBadboy.setForeground(clrStandard);
		txfBadboy.setPreferredSize(new Dimension(50, 20));
		txfBadboy.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfBadboy, 1, 8, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblWhiteMan = new JLabel(Strings.getString("GUI.57"), SwingConstants.LEFT);
		lblWhiteMan.setForeground(clrStandard);
		lblWhiteMan.setFont(fntStandard);
		addComponent(pnlCountryGeneralTxf, layout, lblWhiteMan, 0, 9, 1, 1, 1, 0, new Insets(0, 0, 5, 5));

		txfWhiteMan = new JTextField();
		txfWhiteMan.setBackground(Color.white);
		txfWhiteMan.setForeground(clrStandard);
		txfWhiteMan.setPreferredSize(new Dimension(50, 20));
		txfWhiteMan.setEditable(true);
		addComponent(pnlCountryGeneralTxf, layout, txfWhiteMan, 1, 9, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		addComponent(pnlCountryGeneral, layout, new JPanel(), 0, y, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlCountryTechnology() {

		int y = 0;

		pnlCountryTechnology = new JPanel();
		pnlCountryTechnology.setLayout(layout);
		pnlCountryTechnology.setBackground(clrBackground);
		addComponent(pnlCountrySettings, layout, pnlCountryTechnology, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		pnlTechnology = new JPanel();
		pnlTechnology.setLayout(layout);
		pnlTechnology.setBackground(clrBackground);
		addComponent(pnlCountryTechnology, layout, pnlTechnology, 0, y, 1, 1, 1, 0, new Insets(0, 0, 0, 0));
		y++;

		lblTechnologyLand = new JLabel(Strings.getString("GUI.26"), SwingConstants.LEFT);
		lblTechnologyLand.setForeground(clrStandard);
		lblTechnologyLand.setFont(fntStandard);
		addComponent(pnlTechnology, layout, lblTechnologyLand, 0, 0, 1, 1, 1, 0, new Insets(5, 5, 5, 10));

		txfTechnologyLand = new JTextField();
		txfTechnologyLand.setBackground(Color.white);
		txfTechnologyLand.setForeground(clrStandard);
		txfTechnologyLand.setPreferredSize(new Dimension(50, 20));
		txfTechnologyLand.setEditable(true);
		addComponent(pnlTechnology, layout, txfTechnologyLand, 1, 0, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		lblTechnologyNaval = new JLabel(Strings.getString("GUI.27"), SwingConstants.LEFT);
		lblTechnologyNaval.setForeground(clrStandard);
		lblTechnologyNaval.setFont(fntStandard);
		addComponent(pnlTechnology, layout, lblTechnologyNaval, 0, 1, 1, 1, 1, 0, new Insets(5, 5, 5, 10));

		txfTechnologyNaval = new JTextField();
		txfTechnologyNaval.setBackground(Color.white);
		txfTechnologyNaval.setForeground(clrStandard);
		txfTechnologyNaval.setPreferredSize(new Dimension(50, 20));
		txfTechnologyNaval.setEditable(true);
		addComponent(pnlTechnology, layout, txfTechnologyNaval, 1, 1, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		lblTrade = new JLabel(Strings.getString("GUI.28"), SwingConstants.LEFT);
		lblTrade.setForeground(clrStandard);
		lblTrade.setFont(fntStandard);
		addComponent(pnlTechnology, layout, lblTrade, 0, 2, 1, 1, 1, 0, new Insets(5, 5, 5, 10));

		txfTechnologyTrade = new JTextField();
		txfTechnologyTrade.setBackground(Color.white);
		txfTechnologyTrade.setForeground(clrStandard);
		txfTechnologyTrade.setPreferredSize(new Dimension(50, 20));
		txfTechnologyTrade.setEditable(true);
		addComponent(pnlTechnology, layout, txfTechnologyTrade, 1, 2, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		lblInfra = new JLabel(Strings.getString("GUI.29"), SwingConstants.LEFT);
		lblInfra.setForeground(clrStandard);
		lblInfra.setFont(fntStandard);
		addComponent(pnlTechnology, layout, lblInfra, 0, 3, 1, 1, 1, 0, new Insets(5, 5, 5, 10));

		txfTechnologyInfra = new JTextField();
		txfTechnologyInfra.setBackground(Color.white);
		txfTechnologyInfra.setForeground(clrStandard);
		txfTechnologyInfra.setPreferredSize(new Dimension(50, 20));
		txfTechnologyInfra.setEditable(true);
		addComponent(pnlTechnology, layout, txfTechnologyInfra, 1, 3, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		lblStability = new JLabel(Strings.getString("GUI.30"), SwingConstants.LEFT);
		lblStability.setForeground(clrStandard);
		lblStability.setFont(fntStandard);
		addComponent(pnlTechnology, layout, lblStability, 0, 4, 1, 1, 1, 0, new Insets(5, 5, 5, 10));

		txfTechnologyStability = new JTextField();
		txfTechnologyStability.setBackground(Color.white);
		txfTechnologyStability.setForeground(clrStandard);
		txfTechnologyStability.setPreferredSize(new Dimension(50, 20));
		txfTechnologyStability.setEditable(true);
		addComponent(pnlTechnology, layout, txfTechnologyStability, 1, 4, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		lblTechnologyGroup = new JLabel(Strings.getString("GUI.31"), SwingConstants.LEFT);
		lblTechnologyGroup.setForeground(clrStandard);
		lblTechnologyGroup.setFont(fntStandard);
		addComponent(pnlCountryTechnology, layout, lblTechnologyGroup, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		cbxTechnologyGroup = new JComboBox<String>();
		cbxTechnologyGroup.addActionListener(this);
		addComponent(pnlCountryTechnology, layout, cbxTechnologyGroup, 0, y, 1, 1, 0, 0, new Insets(0, 5, 5, 5));
		y++;

		lblAi = new JLabel(Strings.getString("GUI.32"), SwingConstants.LEFT);
		lblAi.setForeground(clrStandard);
		lblAi.setFont(fntStandard);
		addComponent(pnlCountryTechnology, layout, lblAi, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxAi = new JComboBox<String>();
		cbxAi.addActionListener(this);
		addComponent(pnlCountryTechnology, layout, cbxAi, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblMonarchtable = new JLabel(Strings.getString("GUI.33"), SwingConstants.LEFT);
		lblMonarchtable.setForeground(clrStandard);
		lblMonarchtable.setFont(fntStandard);
		addComponent(pnlCountryTechnology, layout, lblMonarchtable, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxMonarchtable = new JComboBox<String>();
		cbxMonarchtable.addActionListener(this);
		addComponent(pnlCountryTechnology, layout, cbxMonarchtable, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblLeadertable = new JLabel(Strings.getString("GUI.34"), SwingConstants.LEFT);
		lblLeadertable.setForeground(clrStandard);
		lblLeadertable.setFont(fntStandard);
		addComponent(pnlCountryTechnology, layout, lblLeadertable, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxLeadertable = new JComboBox<String>();
		cbxLeadertable.addActionListener(this);
		addComponent(pnlCountryTechnology, layout, cbxLeadertable, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		addComponent(pnlCountryTechnology, layout, new JPanel(), 0, y, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlCountryDiplomacy() {

		int y = 0;

		pnlCountryDiplomacy = new JPanel();
		pnlCountryDiplomacy.setLayout(layout);
		pnlCountryDiplomacy.setBackground(clrBackground);
		addComponent(pnlCountrySettings, layout, pnlCountryDiplomacy, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		lblSelectedCountry = new JLabel(Strings.getString("GUI.60"));
		lblSelectedCountry.setForeground(clrStandard);
		lblSelectedCountry.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblSelectedCountry, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		cbxSelectedCountry = new JComboBox<String>();
		cbxSelectedCountry.addActionListener(this);
		addComponent(pnlCountryDiplomacy, layout, cbxSelectedCountry, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlDiplomacyRelation = new JPanel();
		pnlDiplomacyRelation.setLayout(layout);
		pnlDiplomacyRelation.setBackground(clrBackground);
		addComponent(pnlCountryDiplomacy, layout, pnlDiplomacyRelation, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		lblDiplomacyRelation = new JLabel(Strings.getString("GUI.61"), SwingConstants.LEFT);
		lblDiplomacyRelation.setForeground(clrStandard);
		lblDiplomacyRelation.setFont(fntStandard);
		addComponent(pnlDiplomacyRelation, layout, lblDiplomacyRelation, 0, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 5));

		txfDiplomacyRelation = new JTextField();
		txfDiplomacyRelation.setBackground(Color.white);
		txfDiplomacyRelation.setForeground(clrStandard);
		txfDiplomacyRelation.setPreferredSize(new Dimension(50, 20));
		txfDiplomacyRelation.setEditable(true);
		addComponent(pnlDiplomacyRelation, layout, txfDiplomacyRelation, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		chbCasusBelli = new JCheckBox(Strings.getString("GUI.65"));
		chbCasusBelli.setSelected(false);
		chbCasusBelli.setForeground(clrStandard);
		chbCasusBelli.setFont(fntStandard);
		chbCasusBelli.addChangeListener(this);
		addComponent(pnlCountryDiplomacy, layout, chbCasusBelli, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		lblCasusBelliDate = new JLabel(Strings.getString("GUI.67"), SwingConstants.LEFT);
		lblCasusBelliDate.setForeground(clrStandard);
		lblCasusBelliDate.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblCasusBelliDate, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlCasusBelli = new JPanel();
		pnlCasusBelli.setLayout(layout);
		pnlCasusBelli.setBackground(clrBackground);
		addComponent(pnlCountryDiplomacy, layout, pnlCasusBelli, 0, y, 1, 1, 1, 0, new Insets(0, 5, 0, 5));
		y++;

		cbxCasusBelliDay = new JComboBox<String>(days);
		cbxCasusBelliDay.addActionListener(this);
		addComponent(pnlCasusBelli, layout, cbxCasusBelliDay, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlCasusBelli, layout, new JLabel("."), 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		cbxCasusBelliMonth = new JComboBox<String>(months);
		cbxCasusBelliMonth.addActionListener(this);
		addComponent(pnlCasusBelli, layout, cbxCasusBelliMonth, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlCasusBelli, layout, new JLabel("."), 3, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		txfCasusBelliYear = new JTextField();
		txfCasusBelliYear.setBackground(Color.white);
		txfCasusBelliYear.setForeground(clrStandard);
		txfCasusBelliYear.setPreferredSize(new Dimension(50, 20));
		txfCasusBelliYear.setEditable(true);
		addComponent(pnlCasusBelli, layout, txfCasusBelliYear, 4, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		addComponent(pnlCasusBelli, layout, new JPanel(), 5, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblCasusBelliType = new JLabel(Strings.getString("GUI.66"), SwingConstants.LEFT);
		lblCasusBelliType.setForeground(clrStandard);
		lblCasusBelliType.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblCasusBelliType, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxCasusBelli = new JComboBox<String>(CasusBelliTypes);
		cbxCasusBelli.addActionListener(this);
		addComponent(pnlCountryDiplomacy, layout, cbxCasusBelli, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblWarned = new JLabel(Strings.getString("GUI.68"));
		lblWarned.setForeground(clrStandard);
		lblWarned.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblWarned, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		pnlWarned = new JPanel();
		pnlWarned.setLayout(layout);
		pnlWarned.setBackground(clrBackground);
		addComponent(pnlCountryDiplomacy, layout, pnlWarned, 0, y, 1, 1, 1, 0, new Insets(0, 5, 0, 5));
		y++;

		cbxWarnedDay = new JComboBox<String>(days);
		cbxWarnedDay.addActionListener(this);
		addComponent(pnlWarned, layout, cbxWarnedDay, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlWarned, layout, new JLabel("."), 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		cbxWarnedMonth = new JComboBox<String>(months);
		cbxWarnedMonth.addActionListener(this);
		addComponent(pnlWarned, layout, cbxWarnedMonth, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlWarned, layout, new JLabel("."), 3, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		txfWarnedYear = new JTextField();
		txfWarnedYear.setBackground(Color.white);
		txfWarnedYear.setForeground(clrStandard);
		txfWarnedYear.setPreferredSize(new Dimension(50, 20));
		txfWarnedYear.setEditable(true);
		addComponent(pnlWarned, layout, txfWarnedYear, 4, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		addComponent(pnlWarned, layout, new JPanel(), 5, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblIndependence = new JLabel(Strings.getString("GUI.69"), SwingConstants.LEFT);
		lblIndependence.setForeground(clrStandard);
		lblIndependence.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblIndependence, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		pnlIndependence = new JPanel();
		pnlIndependence.setLayout(layout);
		pnlIndependence.setBackground(clrBackground);
		addComponent(pnlCountryDiplomacy, layout, pnlIndependence, 0, y, 1, 1, 1, 0, new Insets(0, 5, 0, 5));
		y++;

		cbxIndependenceDay = new JComboBox<String>(days);
		cbxIndependenceDay.addActionListener(this);
		addComponent(pnlIndependence, layout, cbxIndependenceDay, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlIndependence, layout, new JLabel("."), 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		cbxIndependenceMonth = new JComboBox<String>(months);
		cbxIndependenceMonth.addActionListener(this);
		addComponent(pnlIndependence, layout, cbxIndependenceMonth, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlIndependence, layout, new JLabel("."), 3, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		txfIndependenceYear = new JTextField();
		txfIndependenceYear.setBackground(Color.white);
		txfIndependenceYear.setForeground(clrStandard);
		txfIndependenceYear.setPreferredSize(new Dimension(50, 20));
		txfIndependenceYear.setEditable(true);
		addComponent(pnlIndependence, layout, txfIndependenceYear, 4, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		addComponent(pnlIndependence, layout, new JPanel(), 5, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblPeace = new JLabel(Strings.getString("GUI.70"), SwingConstants.LEFT);
		lblPeace.setForeground(clrStandard);
		lblPeace.setFont(fntStandard);
		addComponent(pnlCountryDiplomacy, layout, lblPeace, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		pnlPeace = new JPanel();
		pnlPeace.setLayout(layout);
		pnlPeace.setBackground(clrBackground);
		addComponent(pnlCountryDiplomacy, layout, pnlPeace, 0, y, 1, 1, 1, 0, new Insets(0, 5, 0, 5));
		y++;

		cbxPeaceDay = new JComboBox<String>(days);
		cbxPeaceDay.addActionListener(this);
		addComponent(pnlPeace, layout, cbxPeaceDay, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlPeace, layout, new JLabel("."), 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		cbxPeaceMonth = new JComboBox<String>(months);
		cbxPeaceMonth.addActionListener(this);
		addComponent(pnlPeace, layout, cbxPeaceMonth, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlPeace, layout, new JLabel("."), 3, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		txfPeaceYear = new JTextField();
		txfPeaceYear.setBackground(Color.white);
		txfPeaceYear.setForeground(clrStandard);
		txfPeaceYear.setPreferredSize(new Dimension(50, 20));
		txfPeaceYear.setEditable(true);
		addComponent(pnlPeace, layout, txfPeaceYear, 4, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		addComponent(pnlPeace, layout, new JPanel(), 5, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		chbTradeAgreement = new JCheckBox(Strings.getString("GUI.62"));
		chbTradeAgreement.setSelected(false);
		chbTradeAgreement.setForeground(clrStandard);
		chbTradeAgreement.setFont(fntStandard);
		chbTradeAgreement.addChangeListener(this);
		addComponent(pnlCountryDiplomacy, layout, chbTradeAgreement, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		chbMilitaryAccess = new JCheckBox(Strings.getString("GUI.63"));
		chbMilitaryAccess.setSelected(false);
		chbMilitaryAccess.setForeground(clrStandard);
		chbMilitaryAccess.setFont(fntStandard);
		chbMilitaryAccess.addChangeListener(this);
		addComponent(pnlCountryDiplomacy, layout, chbMilitaryAccess, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		chbRefuseTrade = new JCheckBox(Strings.getString("GUI.64"));
		chbRefuseTrade.setSelected(false);
		chbRefuseTrade.setForeground(clrStandard);
		chbRefuseTrade.setFont(fntStandard);
		chbRefuseTrade.addChangeListener(this);
		addComponent(pnlCountryDiplomacy, layout, chbRefuseTrade, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		addComponent(pnlCountryDiplomacy, layout, new JPanel(), 0, y, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlCountryUnits() {

		int y = 0;

		pnlCountryUnits = new JPanel();
		pnlCountryUnits.setLayout(layout);
		pnlCountryUnits.setBackground(clrBackground);
		addComponent(pnlCountrySettings, layout, pnlCountryUnits, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		lblArmy = new JLabel(Strings.getString("GUI.71"), SwingConstants.LEFT);
		lblArmy.setForeground(clrStandard);
		lblArmy.setFont(fntStandard);
		addComponent(pnlCountryUnits, layout, lblArmy, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		cbxUnits = new JComboBox<String>();
		cbxUnits.addActionListener(this);
		addComponent(pnlCountryUnits, layout, cbxUnits, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlUnits = new JPanel();
		pnlUnits.setLayout(layout);
		pnlUnits.setBackground(clrBackground);
		addComponent(pnlCountryUnits, layout, pnlUnits, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		btnUnitAdd = new JButton(Strings.getString("GUI.73"));
		btnUnitAdd.addActionListener(this);
		addComponent(pnlUnits, layout, btnUnitAdd, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		btnUnitRename = new JButton(Strings.getString("GUI.74"));
		btnUnitRename.addActionListener(this);
		addComponent(pnlUnits, layout, btnUnitRename, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		btnUnitDel = new JButton(Strings.getString("GUI.75"));
		btnUnitDel.addActionListener(this);
		addComponent(pnlUnits, layout, btnUnitDel, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		addComponent(pnlUnits, layout, new JPanel(), 3, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblUnitLocation = new JLabel(Strings.getString("GUI.76"), SwingConstants.LEFT);
		lblUnitLocation.setForeground(clrStandard);
		lblUnitLocation.setFont(fntStandard);
		addComponent(pnlCountryUnits, layout, lblUnitLocation, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxUnitLocation = new JComboBox<String>();
		cbxUnitLocation.addActionListener(this);
		addComponent(pnlCountryUnits, layout, cbxUnitLocation, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlUnitNumbers = new JPanel();
		pnlUnitNumbers.setLayout(layout);
		pnlUnitNumbers.setBackground(clrBackground);
		addComponent(pnlCountryUnits, layout, pnlUnitNumbers, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblInfantry = new JLabel(Strings.getString("GUI.77"), SwingConstants.LEFT);
		lblInfantry.setForeground(clrStandard);
		lblInfantry.setFont(fntStandard);
		addComponent(pnlUnitNumbers, layout, lblInfantry, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlUnitNumbers, layout, new JPanel(), 1, 0, 1, 1, 1, 0, new Insets(0, 0, 5, 0));

		txfInfantry = new JTextField();
		txfInfantry.setBackground(Color.white);
		txfInfantry.setForeground(clrStandard);
		txfInfantry.setPreferredSize(new Dimension(50, 20));
		txfInfantry.setEditable(true);
		addComponent(pnlUnitNumbers, layout, txfInfantry, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblCavalry = new JLabel(Strings.getString("GUI.78"), SwingConstants.LEFT);
		lblCavalry.setForeground(clrStandard);
		lblCavalry.setFont(fntStandard);
		addComponent(pnlUnitNumbers, layout, lblCavalry, 0, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlUnitNumbers, layout, new JPanel(), 1, 1, 1, 1, 1, 0, new Insets(0, 0, 5, 0));

		txfCavalry = new JTextField();
		txfCavalry.setBackground(Color.white);
		txfCavalry.setForeground(clrStandard);
		txfCavalry.setPreferredSize(new Dimension(50, 20));
		txfCavalry.setEditable(true);
		addComponent(pnlUnitNumbers, layout, txfCavalry, 2, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblArtillery = new JLabel(Strings.getString("GUI.79"), SwingConstants.LEFT);
		lblArtillery.setForeground(clrStandard);
		lblArtillery.setFont(fntStandard);
		addComponent(pnlUnitNumbers, layout, lblArtillery, 0, 2, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		addComponent(pnlUnitNumbers, layout, new JPanel(), 1, 2, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		txfArtillery = new JTextField();
		txfArtillery.setBackground(Color.white);
		txfArtillery.setForeground(clrStandard);
		txfArtillery.setPreferredSize(new Dimension(50, 20));
		txfArtillery.setEditable(true);
		addComponent(pnlUnitNumbers, layout, txfArtillery, 2, 2, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		lblNavy = new JLabel(Strings.getString("GUI.72"), SwingConstants.LEFT);
		lblNavy.setForeground(clrStandard);
		lblNavy.setFont(fntStandard);
		addComponent(pnlCountryUnits, layout, lblNavy, 0, y, 1, 1, 1, 0, new Insets(10, 5, 5, 5));
		y++;

		cbxNavalUnits = new JComboBox<String>();
		cbxNavalUnits.addActionListener(this);
		addComponent(pnlCountryUnits, layout, cbxNavalUnits, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlNavalUnits = new JPanel();
		pnlNavalUnits.setLayout(layout);
		pnlNavalUnits.setBackground(clrBackground);
		addComponent(pnlCountryUnits, layout, pnlNavalUnits, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		btnNavalUnitAdd = new JButton(Strings.getString("GUI.80"));
		btnNavalUnitAdd.addActionListener(this);
		addComponent(pnlNavalUnits, layout, btnNavalUnitAdd, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		btnNavalUnitRename = new JButton(Strings.getString("GUI.81"));
		btnNavalUnitRename.addActionListener(this);
		addComponent(pnlNavalUnits, layout, btnNavalUnitRename, 1, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		btnNavalUnitDel = new JButton(Strings.getString("GUI.82"));
		btnNavalUnitDel.addActionListener(this);
		addComponent(pnlNavalUnits, layout, btnNavalUnitDel, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		addComponent(pnlNavalUnits, layout, new JPanel(), 3, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblNavalUnitLocation = new JLabel(Strings.getString("GUI.83"), SwingConstants.LEFT);
		lblNavalUnitLocation.setForeground(clrStandard);
		lblNavalUnitLocation.setFont(fntStandard);
		addComponent(pnlCountryUnits, layout, lblNavalUnitLocation, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxNavalUnitLocation = new JComboBox<String>();
		cbxNavalUnitLocation.addActionListener(this);
		addComponent(pnlCountryUnits, layout, cbxNavalUnitLocation, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		pnlNavalUnitNumbers = new JPanel();
		pnlNavalUnitNumbers.setLayout(layout);
		pnlNavalUnitNumbers.setBackground(clrBackground);
		addComponent(pnlCountryUnits, layout, pnlNavalUnitNumbers, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblWarships = new JLabel(Strings.getString("GUI.84"), SwingConstants.LEFT);
		lblWarships.setForeground(clrStandard);
		lblWarships.setFont(fntStandard);
		addComponent(pnlNavalUnitNumbers, layout, lblWarships, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlNavalUnitNumbers, layout, new JPanel(), 1, 0, 1, 1, 1, 0, new Insets(0, 0, 5, 0));

		txfWarships = new JTextField();
		txfWarships.setBackground(Color.white);
		txfWarships.setForeground(clrStandard);
		txfWarships.setPreferredSize(new Dimension(50, 20));
		txfWarships.setEditable(true);
		addComponent(pnlNavalUnitNumbers, layout, txfWarships, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblGalleys = new JLabel(Strings.getString("GUI.85"), SwingConstants.LEFT);
		lblGalleys.setForeground(clrStandard);
		lblGalleys.setFont(fntStandard);
		addComponent(pnlNavalUnitNumbers, layout, lblGalleys, 0, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlNavalUnitNumbers, layout, new JPanel(), 1, 1, 1, 1, 1, 0, new Insets(0, 0, 5, 0));

		txfGalleys = new JTextField();
		txfGalleys.setBackground(Color.white);
		txfGalleys.setForeground(clrStandard);
		txfGalleys.setPreferredSize(new Dimension(50, 20));
		txfGalleys.setEditable(true);
		addComponent(pnlNavalUnitNumbers, layout, txfGalleys, 2, 1, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		lblTransports = new JLabel(Strings.getString("GUI.86"), SwingConstants.LEFT);
		lblTransports.setForeground(clrStandard);
		lblTransports.setFont(fntStandard);
		addComponent(pnlNavalUnitNumbers, layout, lblTransports, 0, 2, 1, 1, 0, 0, new Insets(0, 0, 0, 5));

		addComponent(pnlNavalUnitNumbers, layout, new JPanel(), 1, 2, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		txfTransports = new JTextField();
		txfTransports.setBackground(Color.white);
		txfTransports.setForeground(clrStandard);
		txfTransports.setPreferredSize(new Dimension(50, 20));
		txfTransports.setEditable(true);
		addComponent(pnlNavalUnitNumbers, layout, txfTransports, 2, 2, 1, 1, 0, 0, new Insets(0, 0, 0, 0));

		addComponent(pnlCountryUnits, layout, new JPanel(), 0, y, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	void createPnlCountryPolicy() {

		int y = 0;

		pnlCountryPolicy = new JPanel();
		pnlCountryPolicy.setLayout(layout);
		pnlCountryPolicy.setBackground(clrBackground);
		addComponent(pnlCountrySettings, layout, pnlCountryPolicy, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		lblPolicyDate = new JLabel(Strings.getString("GUI.8"), SwingConstants.LEFT);
		lblPolicyDate.setForeground(clrStandard);
		lblPolicyDate.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblPolicyDate, 0, y, 1, 1, 1, 0, new Insets(5, 5, 5, 5));
		y++;

		pnlPolicyDate = new JPanel();
		pnlPolicyDate.setLayout(layout);
		pnlPolicyDate.setBackground(clrBackground);
		addComponent(pnlCountryPolicy, layout, pnlPolicyDate, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		cbxPolicyDateDay = new JComboBox<String>(days);
		cbxPolicyDateDay.addActionListener(this);
		addComponent(pnlPolicyDate, layout, cbxPolicyDateDay, 0, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlPolicyDate, layout, new JLabel("."), 1, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		cbxPolicyDateMonth = new JComboBox<String>(months);
		cbxPolicyDateMonth.addActionListener(this);
		addComponent(pnlPolicyDate, layout, cbxPolicyDateMonth, 2, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		addComponent(pnlPolicyDate, layout, new JLabel("."), 3, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 5));

		txfPolicyDateYear = new JTextField();
		txfPolicyDateYear.setBackground(Color.white);
		txfPolicyDateYear.setForeground(clrStandard);
		txfPolicyDateYear.setPreferredSize(new Dimension(50, 20));
		txfPolicyDateYear.setEditable(true);
		addComponent(pnlPolicyDate, layout, txfPolicyDateYear, 4, 0, 1, 1, 0, 0, new Insets(0, 0, 5, 0));

		addComponent(pnlPolicyDate, layout, new JPanel(), 5, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		lblAristocracy = new JLabel(Strings.getString("GUI.10"), SwingConstants.LEFT);
		lblAristocracy.setForeground(clrStandard);
		lblAristocracy.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblAristocracy, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldAristocracy = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldAristocracy.addChangeListener(this);
		sldAristocracy.setMajorTickSpacing(1);
		sldAristocracy.setPaintTicks(true);
		sldAristocracy.setSnapToTicks(true);
		sldAristocracy.setPaintLabels(true);
		sldAristocracy.setToolTipText(Strings.getString("GUI.11"));
		addComponent(pnlCountryPolicy, layout, sldAristocracy, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblCentralization = new JLabel(Strings.getString("GUI.12"), SwingConstants.LEFT);
		lblCentralization.setForeground(clrStandard);
		lblCentralization.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblCentralization, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldCentralization = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldCentralization.addChangeListener(this);
		sldCentralization.setMajorTickSpacing(1);
		sldCentralization.setPaintTicks(true);
		sldCentralization.setSnapToTicks(true);
		sldCentralization.setPaintLabels(true);
		sldCentralization.setToolTipText(Strings.getString("GUI.13"));
		addComponent(pnlCountryPolicy, layout, sldCentralization, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblInnovative = new JLabel(Strings.getString("GUI.14"), SwingConstants.LEFT);
		lblInnovative.setForeground(clrStandard);
		lblInnovative.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblInnovative, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldInnovative = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldInnovative.addChangeListener(this);
		sldInnovative.setMajorTickSpacing(1);
		sldInnovative.setPaintTicks(true);
		sldInnovative.setSnapToTicks(true);
		sldInnovative.setPaintLabels(true);
		sldInnovative.setToolTipText(Strings.getString("GUI.15"));
		addComponent(pnlCountryPolicy, layout, sldInnovative, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblMercantilism = new JLabel(Strings.getString("GUI.16"), SwingConstants.LEFT);
		lblMercantilism.setForeground(clrStandard);
		lblMercantilism.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblMercantilism, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldMercantilism = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldMercantilism.addChangeListener(this);
		sldMercantilism.setMajorTickSpacing(1);
		sldMercantilism.setPaintTicks(true);
		sldMercantilism.setSnapToTicks(true);
		sldMercantilism.setPaintLabels(true);
		sldMercantilism.setToolTipText(Strings.getString("GUI.17"));
		addComponent(pnlCountryPolicy, layout, sldMercantilism, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblOffensive = new JLabel(Strings.getString("GUI.18"), SwingConstants.LEFT);
		lblOffensive.setForeground(clrStandard);
		lblOffensive.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblOffensive, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldOffensive = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldOffensive.addChangeListener(this);
		sldOffensive.setMajorTickSpacing(1);
		sldOffensive.setPaintTicks(true);
		sldOffensive.setSnapToTicks(true);
		sldOffensive.setPaintLabels(true);
		sldOffensive.setToolTipText(Strings.getString("GUI.19"));
		addComponent(pnlCountryPolicy, layout, sldOffensive, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblLand = new JLabel(Strings.getString("GUI.20"), SwingConstants.LEFT);
		lblLand.setForeground(clrStandard);
		lblLand.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblLand, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldLand = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		sldLand.addChangeListener(this);
		sldLand.setMajorTickSpacing(1);
		sldLand.setPaintTicks(true);
		sldLand.setSnapToTicks(true);
		sldLand.setPaintLabels(true);
		sldLand.setToolTipText(Strings.getString("GUI.21"));
		addComponent(pnlCountryPolicy, layout, sldLand, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblQuality = new JLabel(Strings.getString("GUI.22"), SwingConstants.LEFT);
		lblQuality.setForeground(clrStandard);
		lblQuality.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblQuality, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldQuality = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldQuality.addChangeListener(this);
		sldQuality.setMajorTickSpacing(1);
		sldQuality.setPaintTicks(true);
		sldQuality.setSnapToTicks(true);
		sldQuality.setPaintLabels(true);
		sldQuality.setToolTipText(Strings.getString("GUI.23"));
		addComponent(pnlCountryPolicy, layout, sldQuality, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		lblSerfdom = new JLabel(Strings.getString("GUI.24"), SwingConstants.LEFT);
		lblSerfdom.setForeground(clrStandard);
		lblSerfdom.setFont(fntStandard);
		addComponent(pnlCountryPolicy, layout, lblSerfdom, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		sldSerfdom = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		sldSerfdom.addChangeListener(this);
		sldSerfdom.setMajorTickSpacing(1);
		sldSerfdom.setPaintTicks(true);
		sldSerfdom.setSnapToTicks(true);
		sldSerfdom.setPaintLabels(true);
		sldSerfdom.setToolTipText(Strings.getString("GUI.25"));
		addComponent(pnlCountryPolicy, layout, sldSerfdom, 0, y, 1, 1, 1, 0, new Insets(0, 5, 5, 5));
		y++;

		addComponent(pnlCountryPolicy, layout, new JPanel(), 0, y, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
	}

	boolean createHashMap(File f) {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(f));
			hashMap = new HashMap<Color, Integer>();

			int r, g, b, i;
			String line = reader.readLine();
			while (line != null) {

				line = line.trim();

				r = Integer.parseInt(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1, line.length());
				g = Integer.parseInt(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1, line.length());
				b = Integer.parseInt(line.substring(0, line.indexOf(':')));
				line = line.substring(line.indexOf(':') + 1, line.length());
				i = Integer.parseInt(line);

				hashMap.put(new Color(r, g, b), i);
				line = reader.readLine();

				return true;
			}

			reader.close();

		} catch (IOException e) {
			System.out.println(
					"Error while creating HashMap! Check file (-location) and try again. Program shuts down...");
			System.exit(1);
		}

		return false;
	}

	void addComponent(Container cont, GridBagLayout gbl, Component c, int x, int y, int width, int height,
			double weightx, double weighty, Insets insets) {
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

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSave) {

			saveValues(dataMap);
			Thread save = new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						new SaveSettings(dataMap);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			save.start();
		}

		if (e.getSource() == cbxCountry) {

			saveValues(dataMap);
			setValues(dataMap);
			selectedCountryItem = (String) cbxCountry.getSelectedItem();
		}

		if (e.getSource() == cbxCategory) {

			String category0 = Strings.getString("Category.1");
			String category1 = Strings.getString("Category.2");
			String category2 = Strings.getString("Category.3");
			String category3 = Strings.getString("Category.4");
			String category4 = Strings.getString("Category.5");

			String item = cbxCategory.getSelectedItem().toString();

			pnlCountryGeneral.setVisible(false);
			pnlCountryPolicy.setVisible(false);
			pnlCountryTechnology.setVisible(false);
			pnlCountryDiplomacy.setVisible(false);
			pnlCountryUnits.setVisible(false);

			if (item.contains(category0))
				pnlCountryGeneral.setVisible(true);
			else if (item.contains(category1))
				pnlCountryPolicy.setVisible(true);
			else if (item.contains(category2))
				pnlCountryTechnology.setVisible(true);
			else if (item.contains(category3))
				pnlCountryDiplomacy.setVisible(true);
			else if (item.contains(category4))
				pnlCountryUnits.setVisible(true);
		}
	}

	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == chbCasusBelli) {

			if (chbCasusBelli.isSelected()) {

				cbxCasusBelliDay.setEnabled(true);
				cbxCasusBelliMonth.setEnabled(true);
				txfCasusBelliYear.setEnabled(true);
				cbxCasusBelli.setEnabled(true);
			} else {

				cbxCasusBelliDay.setEnabled(false);
				cbxCasusBelliMonth.setEnabled(false);
				txfCasusBelliYear.setEnabled(false);
				cbxCasusBelli.setEnabled(false);
			}
		}
	}
}
