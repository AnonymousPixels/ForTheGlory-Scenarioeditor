package scenariogenerator;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ColonyPanel extends JPanel {

	static JLabel lblID;

	JLabel lblID2;

	JLabel lblName;

	JLabel lblType;

	JLabel lblTerrain;

	JLabel lblClimate;

	JLabel lblReligion;

	JLabel lblCulture;

	JLabel lblManpower;

	JLabel lblIncome;

	JLabel lblGoods;

	JLabel lblValue;

	JLabel lblCotModifier;

	JLabel lblColonizationDifficulty;

	JLabel lblLooted;

	JLabel lblDate;

	JLabel lblMine;

	JLabel lblNatives;

	JLabel lblFerocity;

	JLabel lblTolerance;

	JLabel lblNegotiation;

	JLabel lblProvinceRevoltrisk;

	JLabel lblTax;

	JTextField txtName, txtManpower, txtIncome, txtValue, txtCotModifier,
			txtColonizationDifficulty, txtLootedYear, txtMine, txtTax;

	JComboBox jcbType, jcbTerrain, jcbClimate, jcbReligion, jcbCulture,
			jcbGoods, jcbLootedDay, jcbLootedMonth;

	JCheckBox chkLooted, chkWhiteman;

	JSlider sldNatives, sldFerocity, sldTolerance, sldNegotiation,
			sldProvinceRevoltrisk;

	static JPanel pnlPopulation, pnlGeography;

	JPanel pnlFinance;

	JPanel pnlNatives;
	static GridBagLayout layout;

	public ColonyPanel(Map<String, String> map) {
		super();
		layout = new GridBagLayout();

		this.setLayout(layout);

		lblID = new JLabel("ID:");
		lblID2 = new JLabel(map.get("id"));
		lblName = new JLabel("Name:");
		lblType = new JLabel("Typ:");
		lblTerrain = new JLabel("Terrain:");
		lblClimate = new JLabel("Klima:");
		lblReligion = new JLabel("Religion:");
		lblCulture = new JLabel("Kultur:");
		lblManpower = new JLabel("Soldatenanzahl:");
		lblIncome = new JLabel("Einnahmen:");
		lblGoods = new JLabel("G�ter:");
		lblValue = new JLabel("G�terwert:");
		lblCotModifier = new JLabel("CoT Modifikator:");
		lblColonizationDifficulty = new JLabel("Kolonisierungsschwierigkeit:");

		txtName = new JTextField(map.get("name"));
		txtManpower = new JTextField(map.get("manpower"));
		txtIncome = new JTextField(map.get("income"));
		txtValue = new JTextField(map.get("value"));
		txtCotModifier = new JTextField(map.get("cotmodifier"));
		txtColonizationDifficulty = new JTextField(
				map.get("colonizationdifficulty"));
		txtLootedYear = new JTextField(map.get("lootedYear"));
		txtMine = new JTextField(map.get("Mine"));
		txtTax = new JTextField(map.get("Tax"));

		jcbType = new JComboBox();
		jcbTerrain = new JComboBox();
		jcbClimate = new JComboBox();
		jcbReligion = new JComboBox();
		jcbCulture = new JComboBox();
		jcbGoods = new JComboBox();
		jcbLootedDay = new JComboBox();
		jcbLootedMonth = new JComboBox();
		jcbLootedMonth = new JComboBox();

		this.setPreferredSize(new Dimension(400, 600));

		addPnlPopulation();
		addPnlGeography();

	}

	void addPnlPopulation() {
//		pnlPopulation = new JPanel();
//		pnlPopulation.setLayout(layout);
//		// pnlPopulation.setBackground(Color.RED);
//		// pnlPopulation.setOpaque(true);
//		pnlPopulation
//				.setBorder(BorderFactory.createTitledBorder("Bev�lkerung"));
//		addComponent(this, layout, pnlPopulation, 1, 1, 1, 1, 1, 0, new Insets(
//				5, 5, 5, 5));

		// Komponenten

		addComponent(this, layout, lblID, 1, 1, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, lblID2, 2, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblName, 1, 2, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, txtName, 2, 2, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblManpower, 1, 3, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, txtManpower, 2, 3, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblIncome, 1, 4, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, txtIncome, 2, 4, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblReligion, 1, 5, 1, 1, 0, 0,
				new Insets(5, 5, 30, 5));
		addComponent(this, layout, jcbReligion, 2, 5, 1, 1, 1, 0,
				new Insets(5, 5, 30, 5));

		addComponent(this, layout, lblType, 1, 6, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, jcbType, 2, 6, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

	}

	void addPnlGeography() {
//		pnlGeography = new JPanel();
//		pnlGeography.setLayout(layout);
//		pnlGeography.setBorder(BorderFactory.createTitledBorder("Geographie"));
//		addComponent(this, layout, pnlGeography, 1, 2, 1, 1, 1, 0, new Insets(
//				5, 5, 5, 5));

		addComponent(this, layout, lblTerrain, 1, 7, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, jcbTerrain, 2, 7, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblCulture, 1,8, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, jcbCulture, 2, 8, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblClimate, 1, 9, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, jcbClimate, 2, 9, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));

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
}