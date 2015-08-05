package scenariogenerator;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ColonyPanel extends JPanel {

	JLabel lblID, lblID2, lblName, lblTerrain, lblClimate, lblReligion,
			lblCulture, lblManpower, lblIncome, lblGoods, lblValue,
			lblCotModifier, lblColonizationDifficulty, lblLooted, lblDate,
			lblMine, lblNatives, lblFerocity, lblTolerance, lblNegotiation,
			lblProvinceRevoltrisk, lblTax;

	JTextField txtName, txtManpower, txtIncome, txtValue, txtCotModifier,
			txtColonizationDifficulty, txtLootedYear, txtMine, txtTax;

	JComboBox<String> jcbTerrain, jcbClimate, jcbReligion, jcbCulture,
			jcbGoods, jcbLootedDay, jcbLootedMonth;

	JCheckBox chkLooted, chkWhiteman;

	JSlider sldNatives, sldFerocity, sldTolerance, sldNegotiation,
			sldProvinceRevoltrisk;

	JPanel pnlPopulation, pnlGeography, pnlFinance, pnlNatives;
	static GridBagLayout layout;

	public ColonyPanel(Map<String, String> map,
			Map<String, String[]> selectables) {
		super();
		layout = new GridBagLayout();

		this.setLayout(layout);

		lblID = new JLabel("ID:");
		lblID2 = new JLabel(map.get("id"));
		lblName = new JLabel("Name:");
		;
		lblTerrain = new JLabel("Terrain:");
		lblClimate = new JLabel("Klima:");
		lblReligion = new JLabel("Religion:");
		lblCulture = new JLabel("Kultur:");
		lblManpower = new JLabel("Soldatenanzahl:");
		lblIncome = new JLabel("Einnahmen:");
		lblGoods = new JLabel("Güter:");
		lblValue = new JLabel("Güterwert:");
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
		txtMine = new JTextField(map.get("mine"));
		txtTax = new JTextField(map.get("tax"));

		jcbTerrain = new JComboBox<String>();
		for (String s : selectables.get("terrain"))
			jcbTerrain.addItem(s);
		jcbClimate = new JComboBox<String>();
		for (String s : selectables.get("climate"))
			jcbClimate.addItem(s);
		jcbReligion = new JComboBox<String>();
		for (String s : selectables.get("religion"))
			jcbReligion.addItem(s);
		jcbCulture = new JComboBox<String>();
		for (String s : selectables.get("culture"))
			jcbCulture.addItem(s);
		jcbGoods = new JComboBox<String>();
		for (String s : selectables.get("goods"))
			jcbGoods.addItem(s);
		jcbLootedDay = new JComboBox<String>();
		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		for (String s : days)
			jcbLootedDay.addItem(s);
		jcbLootedMonth = new JComboBox<String>();
		for (String s : months)
			jcbLootedMonth.addItem(s);

		chkLooted = new JCheckBox("Geplündert?");
		if (map.get("looted") == "true")
			chkLooted.setSelected(true);
		chkWhiteman = new JCheckBox("Von Europäern entdeckt?");
		if (map.get("whiteman") == "true")
			chkWhiteman.setSelected(true);

		this.setPreferredSize(new Dimension(400, 600));

		addPnlPopulation();
		addPnlGeography();
		addPnlGoods();
		addPnlLooted();
	}

	public HashMap<String, String> getData() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("name", txtName.getText());
		map.put("manpower", txtManpower.getText());
		map.put("income", txtIncome.getText());
		map.put("value", txtValue.getText());
		map.put("cotmodifier", txtCotModifier.getText());
		map.put("colonizationdifficulty", txtColonizationDifficulty.getText());
		map.put("lootedYear", txtLootedYear.getText());
		map.put("mine", txtMine.getText());
		map.put("tax", txtTax.getText());
		map.put("looted", chkLooted.isSelected() ? "true" : "false");
		map.put("whiteman", chkWhiteman.isSelected() ? "true" : "false");

		return map;
	}

	public void setData(HashMap<String, String> map) {
		txtName.setText(map.get("name"));
		txtManpower.setText(map.get("manpower"));
		txtIncome.setText(map.get("income"));
		txtValue.setText(map.get("value"));
		txtCotModifier.setText(map.get("cotmodifier"));
		txtColonizationDifficulty.setText(map.get("colonizationdifficulty"));
		txtLootedYear.setText(map.get("lootedYear"));
		txtMine.setText(map.get("mine"));
		txtTax.setText(map.get("tax"));

		chkLooted = new JCheckBox("Geplündert?");
		if (map.get("looted") == "true")
			chkLooted.setSelected(true);
		chkWhiteman = new JCheckBox("Von Europäern entdeckt?");
		if (map.get("whiteman") == "true")
			chkWhiteman.setSelected(true);
	}

	void addPnlPopulation() {

		// Komponenten

		addComponent(this, layout, lblID, 1, 1, 1, 1, 0, 0, new Insets(5, 5, 5,
				5));
		addComponent(this, layout, lblID2, 2, 1, 3, 1, 1, 0, new Insets(5, 5,
				5, 5));

		addComponent(this, layout, lblName, 1, 2, 1, 1, 0, 0, new Insets(5, 5,
				5, 5));
		addComponent(this, layout, txtName, 2, 2, 3, 1, 1, 0, new Insets(5, 5,
				5, 5));

		addComponent(this, layout, lblManpower, 1, 3, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, txtManpower, 2, 3, 3, 1, 1, 0, new Insets(5,
				5, 5, 5));

		addComponent(this, layout, lblIncome, 1, 4, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, txtIncome, 2, 4, 3, 1, 1, 0, new Insets(5,
				5, 5, 5));

		addComponent(this, layout, lblReligion, 1, 5, 1, 1, 0, 0, new Insets(5,
				5, 40, 5));
		addComponent(this, layout, jcbReligion, 2, 5, 3, 1, 1, 0, new Insets(5,
				5, 40, 5));

	}

	void addPnlGeography() {

		addComponent(this, layout, lblTerrain, 1, 7, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, jcbTerrain, 2, 7, 3, 1, 1, 0, new Insets(5,
				5, 5, 5));

		addComponent(this, layout, lblCulture, 1, 8, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, jcbCulture, 2, 8, 3, 1, 1, 0, new Insets(5,
				5, 5, 5));

		addComponent(this, layout, lblClimate, 1, 9, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, jcbClimate, 2, 9, 3, 1, 1, 0, new Insets(5,
				5, 5, 5));

	}

	void addPnlGoods() {
		addComponent(this, layout, lblGoods, 1, 10, 1, 1, 0, 0, new Insets(40,
				5, 5, 5));
		addComponent(this, layout, jcbGoods, 2, 10, 3, 1, 0, 0, new Insets(40,
				5, 5, 5));

		addComponent(this, layout, lblValue, 1, 11, 1, 1, 0, 0, new Insets(5,
				5, 5, 5));
		addComponent(this, layout, txtValue, 2, 11, 3, 1, 0, 0, new Insets(5,
				5, 5, 5));

		addComponent(this, layout, lblCotModifier, 1, 12, 1, 1, 0, 0,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, txtCotModifier, 2, 12, 3, 1, 0, 0,
				new Insets(5, 5, 5, 5));

		addComponent(this, layout, lblColonizationDifficulty, 1, 13, 1, 1, 0,
				0, new Insets(5, 5, 5, 5));
		addComponent(this, layout, txtColonizationDifficulty, 2, 13, 3, 1, 0,
				0, new Insets(5, 5, 5, 5));
	}

	void addPnlLooted() {
		addComponent(this, layout, chkLooted, 1, 14, 1, 1, 0, 0, new Insets(40,
				5, 5, 5));
		addComponent(this, layout, txtLootedYear, 4, 14, 1, 1, 0, 0,
				new Insets(40, 5, 5, 5));
		addComponent(this, layout, jcbLootedMonth, 3, 14, 1, 1, 0, 0,
				new Insets(40, 5, 5, 5));
		addComponent(this, layout, jcbLootedDay, 2, 14, 1, 1, 0, 0, new Insets(
				40, 5, 5, 5));

		addComponent(this, layout, chkWhiteman, 1, 15, 2, 1, 0, 0, new Insets(
				5, 5, 5, 5));
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
