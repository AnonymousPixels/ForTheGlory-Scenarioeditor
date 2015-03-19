package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

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

	public static int width, height;

	public GUI() {

		layout = new GridBagLayout();

		frame = new JFrame("FTG Mod Development Tool | " + FTG.version);
		frame.setSize(900, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);

		optionsPnl();
		datePnl();
		deathdatePnl();
		triggerPnl();
		scenarioPnl();
		previewPnl();

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
		addComponent(options, lytOptions, scrComment, 3, 3, 2, 2, 0, 1,
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

		addComponent(frame.getContentPane(), layout, trigger, 1, 3, 2, 1, 1, 1,
				new Insets(5, 5, 5, 5));
		// new TriggerTest();
	}

	void scenarioPnl() {

		scenario = new JPanel();
		scenario.setBorder(BorderFactory.createTitledBorder("Scenario"));

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

}
