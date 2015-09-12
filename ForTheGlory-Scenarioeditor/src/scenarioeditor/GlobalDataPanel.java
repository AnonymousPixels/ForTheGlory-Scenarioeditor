package scenarioeditor;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GlobalDataPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -247067539212798277L;
	JLabel lblType;
	GridBagLayout layout;
	JPanel date, deathdate, discoveries, etablishment, wars, alliances;
	JComboBox<String> jcbDateDay, jcbDateMonth, jcbDeathdateDay,
			jcbDeathdateMonth, jcbType, jcbDiscovery;
	JComboBox<String> jcbType2, jcbEtablishment;
	JTextField txtDateYear, txtDeathdateYear;
	JButton btnAdd, btnAdd2, btnAdd3, btnAdd4;
	JCheckBox chkValue, chkValue2;
	JEditorPane jepDiscovery, jepEtablishment;
	static JEditorPane jepWar;
	static JEditorPane jepAlliance;
	JScrollPane jspDiscovery, jspEtablishment, jspWar, jspAlliance;

	String[] continent, areas, regions;

	Map<?, ?> map, selectables;

	public GlobalDataPanel(Map<String, String> map,
			Map<String, String[]> selectables) {
		super();

		layout = new GridBagLayout();

		this.map = map;
		this.selectables = selectables;

		continent = selectables.get("continent");
		areas = selectables.get("area");
		regions = selectables.get("region");

		this.setLayout(layout);

		datePnl();
		deathdatePnl();
		discoveriesPanel();
		etablishmentsPanel();
		warsPanel();
		alliancesPanel();

		Component[] comp = this.getComponents();
		for (Component component : comp) {
			component.setFont(new Font("Verdana", 0, 12));
		}

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
		jcbDateDay = new JComboBox<String>(days);
		jcbDateMonth = new JComboBox<String>(months);
		txtDateYear = new JTextField("1337");

		addComponent(date, lytDate, jcbDateDay, 1, 1, 1, 1, 1, 1, new Insets(5,
				5, 5, 5));
		addComponent(date, lytDate, jcbDateMonth, 2, 1, 1, 1, 1, 1, new Insets(
				5, 5, 5, 5));
		addComponent(date, lytDate, txtDateYear, 3, 1, 1, 1, 1, 1, new Insets(
				5, 5, 5, 5));

		addComponent(this, layout, date, 1, 1, 1, 1, 1, 0, new Insets(5, 5, 5,
				5));
		// new TriggerTest();
	}

	public void setData(Map<String, String> map) {
		jcbDateDay.setSelectedItem(map.get("dateDay"));
		jcbDateMonth.setSelectedItem(map.get("dateMonth"));
		jcbDeathdateDay.setSelectedItem(map.get("deathdateDay"));
		jcbDeathdateMonth.setSelectedItem(map.get("deathdateDay"));
		txtDateYear.setText((String) map.get("dateYear"));
		txtDeathdateYear.setText((String) map.get("deathdateYear"));
		jepDiscovery.setText((String) map.get("discoveries"));
		jepEtablishment.setText((String) map.get("etablishments"));
		jepWar.setText((String) map.get("wars"));
		jepAlliance.setText((String) map.get("alliances"));

	}

	public Map<String, String> getData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dateDay", jcbDateDay.getSelectedItem().toString());
		map.put("dateMonth", jcbDateMonth.getSelectedItem().toString());
		map.put("deathdateDay", jcbDeathdateDay.getSelectedItem().toString());
		map.put("deathdateMonth", jcbDeathdateMonth.getSelectedItem()
				.toString());
		map.put("dateYear", txtDateYear.getText());
		map.put("deathdateYear", txtDeathdateYear.getText());
		map.put("discoveries", jepDiscovery.getText());
		map.put("etablishments", jepEtablishment.getText());
		map.put("wars", jepWar.getText());
		map.put("alliances", jepAlliance.getText());
		return map;

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
		jcbDeathdateDay = new JComboBox<String>(days);
		jcbDeathdateMonth = new JComboBox<String>(months);
		txtDeathdateYear = new JTextField("1337");

		addComponent(deathdate, lytDeathdate, jcbDeathdateDay, 1, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, jcbDeathdateMonth, 2, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, txtDeathdateYear, 3, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));

		addComponent(this, layout, deathdate, 1, 2, 1, 1, 1, 0, new Insets(5,
				5, 5, 5));
		// new TriggerTest();
	}

	void discoveriesPanel() {
		discoveries = new JPanel();
		discoveries.setBorder(BorderFactory.createTitledBorder("Discoverys"));

		GridBagLayout lytDiscovery = new GridBagLayout();

		discoveries.setLayout(lytDiscovery);

		String[] type = { "Continent", "Area", "Region" };

		jcbType = new JComboBox<String>(type);
		jcbType.addActionListener(this);
		jcbDiscovery = new JComboBox<String>(continent);
		chkValue = new JCheckBox("Value");
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		jepDiscovery = new JEditorPane();
		jspDiscovery = new JScrollPane(jepDiscovery);
		jspDiscovery
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspDiscovery
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspDiscovery
				.setPreferredSize(new Dimension(discoveries.getWidth(), 100));
		addComponent(discoveries, lytDiscovery, jcbType, 1, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoveries, lytDiscovery, jcbDiscovery, 2, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoveries, lytDiscovery, chkValue, 3, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoveries, lytDiscovery, btnAdd, 4, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoveries, lytDiscovery, jspDiscovery, 1, 2, 4, 1, 1, 1,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, discoveries, 1, 3, 2, 1, 1, 0.1, new Insets(
				5, 5, 5, 5));

	}

	void etablishmentsPanel() {
		etablishment = new JPanel();
		etablishment.setBorder(BorderFactory
				.createTitledBorder("Etablishments"));

		GridBagLayout lytEtablishment = new GridBagLayout();

		etablishment.setLayout(lytEtablishment);

		String[] type = { "Continent", "Area", "Region" };

		jcbType2 = new JComboBox<String>(type);
		jcbType2.addActionListener(this);
		jcbEtablishment = new JComboBox<String>(
				(String[]) this.selectables.get("continent"));
		chkValue2 = new JCheckBox("Value");
		btnAdd2 = new JButton("Add");
		btnAdd2.addActionListener(this);
		jepEtablishment = new JEditorPane();
		jspEtablishment = new JScrollPane(jepEtablishment);
		jspEtablishment
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspEtablishment
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspEtablishment.setPreferredSize(new Dimension(etablishment.getWidth(),
				100));
		addComponent(etablishment, lytEtablishment, jcbType2, 1, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(etablishment, lytEtablishment, jcbEtablishment, 2, 1, 1,
				1, 1, 0, new Insets(5, 5, 5, 5));
		addComponent(etablishment, lytEtablishment, chkValue2, 3, 1, 1, 1, 1,
				0, new Insets(5, 5, 5, 5));
		addComponent(etablishment, lytEtablishment, btnAdd2, 4, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(etablishment, lytEtablishment, jspEtablishment, 1, 2, 4,
				1, 1, 1, new Insets(5, 5, 5, 5));
		addComponent(this, layout, etablishment, 1, 4, 2, 1, 1, 0.1,
				new Insets(5, 5, 5, 5));

	}

	void warsPanel() {
		wars = new JPanel();
		wars.setBorder(BorderFactory.createTitledBorder("Wars"));

		GridBagLayout lytWars = new GridBagLayout();

		wars.setLayout(lytWars);

		btnAdd3 = new JButton("New...");
		btnAdd3.addActionListener(this);
		jepWar = new JEditorPane();
		jspWar = new JScrollPane(jepWar);
		jspWar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspWar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspWar.setPreferredSize(new Dimension(wars.getWidth(), 100));
		addComponent(wars, lytWars, btnAdd3, 1, 2, 1, 1, 1, 0, new Insets(5, 5,
				5, 5));
		addComponent(wars, lytWars, jspWar, 1, 1, 4, 1, 1, 1, new Insets(5, 5,
				5, 5));
		addComponent(this, layout, wars, 1, 5, 2, 1, 1, 0.1, new Insets(5, 5,
				5, 5));

	}

	void alliancesPanel() {
		alliances = new JPanel();
		alliances.setBorder(BorderFactory.createTitledBorder("Alliances"));

		GridBagLayout lytAlliances = new GridBagLayout();

		alliances.setLayout(lytAlliances);

		btnAdd4 = new JButton("New...");
		btnAdd4.addActionListener(this);
		jepAlliance = new JEditorPane();
		jspAlliance = new JScrollPane(jepAlliance);
		jspAlliance
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspAlliance
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspAlliance.setPreferredSize(new Dimension(alliances.getWidth(), 100));
		addComponent(alliances, lytAlliances, btnAdd4, 1, 2, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(alliances, lytAlliances, jspAlliance, 1, 1, 4, 1, 1, 1,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, alliances, 1, 6, 2, 1, 1, 0.1, new Insets(5,
				5, 5, 5));

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

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAdd) {

			jepDiscovery.setText(jepDiscovery.getText() + "discovery = { "
					+ jcbType.getSelectedItem().toString().toLowerCase()
					+ " = \"" + jcbDiscovery.getSelectedItem().toString()
					+ "\" value = "
					+ (chkValue.isSelected() ? "true" : "false") + " }\n");

		}
		if (e.getSource() == btnAdd2) {

			jepEtablishment.setText(jepEtablishment.getText()
					+ "etablishment = { "
					+ jcbType2.getSelectedItem().toString().toLowerCase()
					+ " = \"" + jcbEtablishment.getSelectedItem().toString()
					+ "\" value = "
					+ (chkValue2.isSelected() ? "true" : "false") + " }\n");

		}

		if (e.getSource() == jcbType) {
			switch (jcbType.getSelectedItem().toString()) {
			case "Area":
				jcbDiscovery.removeAllItems();
				for (String string : areas) {
					jcbDiscovery.addItem(string);
				}

				break;

			case "Continent":
				jcbDiscovery.removeAllItems();
				for (String string : continent) {
					jcbDiscovery.addItem(string);
				}
				break;

			case "Region":
				jcbDiscovery.removeAllItems();
				for (String string : regions) {
					jcbDiscovery.addItem(string);
				}
				break;
			default:

				System.out
						.println("Program failure ahead! Some stupid programmer made a heavy mistake!");
				break;
			}

		}
		if (e.getSource() == jcbType2) {
			switch (jcbType2.getSelectedItem().toString()) {
			case "Area":
				jcbEtablishment.removeAllItems();
				for (String string : areas) {
					jcbEtablishment.addItem(string);
				}

				break;

			case "Continent":
				jcbEtablishment.removeAllItems();
				for (String string : continent) {
					jcbEtablishment.addItem(string);
				}
				break;

			case "Region":
				jcbEtablishment.removeAllItems();
				for (String string : regions) {
					jcbEtablishment.addItem(string);
				}
				break;
			default:

				System.out
						.println("Program failure ahead! A stupid programmer made a heavy mistake!");
				break;
			}

		}

		if (e.getSource() == btnAdd3) {
			WarFrame war = new WarFrame();
			war.setVisible(true);

		}
		if (e.getSource() == btnAdd4) {
			AllianceFrame alliance = new AllianceFrame();
			alliance.setVisible(true);
		}

	}
}