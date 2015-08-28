package scenariogenerator;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class GlobalDataPanel extends JPanel {

	private static final long serialVersionUID = -247067539212798277L;
	JLabel lblType;
	GridBagLayout layout;
	JPanel date, deathdate, discoverys;
	JComboBox jcbDateDay, jcbDateMonth, jcbDeathdateDay, jcbDeathdateMonth,
			jcbType, jcbDiscovery;
	JTextField txtDateYear, txtDeathdateYear;
	JButton btnAdd;
	JCheckBox chkValue;
	JEditorPane jepDiscovery;
	JScrollPane jspDiscovery;

	String[] countries, areas, regions;

	Map map, selectables;

	public GlobalDataPanel(Map<String, String> map,
			Map<String, String[]> selectables) {
		super();

		layout = new GridBagLayout();

		this.map = map;
		this.selectables = selectables;

		countries = selectables.get("country");
		areas = selectables.get("area");
		regions = selectables.get("region");

		this.setLayout(layout);

		datePnl();
		deathdatePnl();
		discoveriesPanel();

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

		addComponent(this, layout, date, 1, 1, 1, 1, 1, 0, new Insets(5, 5, 5,
				5));
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
		jcbDeathdateDay = new JComboBox<String>(days);
		jcbDeathdateMonth = new JComboBox<String>(months);
		txtDeathdateYear = new JTextField("1337");

		addComponent(deathdate, lytDeathdate, jcbDeathdateDay, 1, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, jcbDeathdateMonth, 2, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));
		addComponent(deathdate, lytDeathdate, txtDeathdateYear, 3, 1, 1, 1, 1,
				1, new Insets(5, 5, 5, 5));

		addComponent(this, layout, deathdate, 2, 1, 1, 1, 1, 0, new Insets(5,
				5, 5, 5));
		// new TriggerTest();
	}

	void discoveriesPanel() {
		discoverys = new JPanel();
		discoverys.setBorder(BorderFactory.createTitledBorder("Discoverys"));

		GridBagLayout lytDiscovery = new GridBagLayout();

		discoverys.setLayout(lytDiscovery);

		String[] type = { "Continent", "Area", "Region" };

		jcbType = new JComboBox<String>(type);
		jcbDiscovery = new JComboBox((String[]) this.selectables.get("region"));
		chkValue = new JCheckBox("Value");
		btnAdd = new JButton("Add");
		jepDiscovery = new JEditorPane();
		jspDiscovery = new JScrollPane(jepDiscovery);
		jspDiscovery
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspDiscovery
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addComponent(discoverys, lytDiscovery, jcbType, 1, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoverys, lytDiscovery, jcbDiscovery, 2, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoverys, lytDiscovery, chkValue, 3, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoverys, lytDiscovery, btnAdd, 4, 1, 1, 1, 1, 0,
				new Insets(5, 5, 5, 5));
		addComponent(discoverys, lytDiscovery, jspDiscovery, 1, 2, 4, 1, 1, 1,
				new Insets(5, 5, 5, 5));
		addComponent(this, layout, discoverys, 1, 2, 2, 1, 1, 0.1, new Insets(
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
