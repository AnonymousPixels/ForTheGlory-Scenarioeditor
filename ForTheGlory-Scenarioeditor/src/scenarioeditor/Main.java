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
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Main class of the szenario editor. Contains main void to start the program
 * flow
 * 
 * @author Felix Beutter
 */

public class Main {

	static JFrame frame;
	static JPanel panel;
	static GridBagLayout layout;
	static JLabel lblPath, lblMods, lblName;
	static JTextField txfPath, txfName;
	static JButton btnPath, btnContinue, btnAccept;
	static JFileChooser chooser;
	static JComboBox<String> cbxMods = new JComboBox<>();
	static File file;
	static String path = "";
	static Color clrBackground = new Color(240, 240, 240), clrFont = new Color(0, 0, 0);
	static Font fntStandart = new Font("Verdana", 1, 12);

	static boolean finishedLoading = false;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error while setting LookAndFeel! Default Java LookAndFeel will be used...");
		}

		file = new File("");

		chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setDialogTitle(Strings.getString("Main.0"));

		layout = new GridBagLayout();

		frame = new JFrame(Strings.getString("Main.1"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(layout);

		panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(clrBackground);
		addComponent(frame, layout, panel, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));

		lblPath = new JLabel(Strings.getString("Main.2"), SwingConstants.LEFT);
		lblPath.setForeground(clrFont);
		lblPath.setFont(fntStandart);
		addComponent(panel, layout, lblPath, 0, 0, 1, 1, 1, 0, new Insets(10, 10, 10, 10));

		btnPath = new JButton(Strings.getString("Main.3"));
		btnPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = chooser.showOpenDialog(null);
				if (i == JFileChooser.APPROVE_OPTION) {

					file = chooser.getSelectedFile();
					path = file.getPath();
					txfPath.setText(path);
				}
			}
		});

		addComponent(panel, layout, btnPath, 1, 0, 1, 1, 0, 0, new Insets(10, 0, 10, 10));

		txfPath = new JTextField("C:\\Program Files (x86)\\Steam\\SteamApps\\common\\For The Glory\\");
		txfPath.setEditable(false);
		txfPath.setForeground(clrFont);
		txfPath.setBackground(Color.white);
		txfPath.setPreferredSize(new Dimension(300, 20));
		addComponent(panel, layout, txfPath, 0, 1, 2, 1, 1, 0, new Insets(0, 10, 10, 10));

		path = txfPath.getText();

		addComponent(panel, layout, new JPanel(), 0, 2, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		btnContinue = new JButton(Strings.getString("Main.4"));
		btnContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (path.trim() != null && !path.trim().equals("")) {

					String modDir = path + "//Mods";
					File[] modFiles = new File(modDir).listFiles();
					String[] mods = new String[1];

					mods[0] = Strings.getString("Main.10");

					for (int i = 0; i < modFiles.length; i++) {

						if (modFiles[i].isDirectory()) {

							String[] mods2 = new String[mods.length + 1];
							System.arraycopy(mods, 0, mods2, 0, mods.length);
							mods2[mods.length] = modFiles[i].getName();
							mods = mods2;
						}
					}

					cbxMods = new JComboBox<String>(mods);
					cbxMods.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							if (cbxMods.getSelectedItem().equals(Strings.getString("Main.10"))) {
								txfName.setVisible(true);
								lblName.setVisible(true);
								frame.pack();
							} else {
								txfName.setVisible(false);
								lblName.setVisible(false);
								frame.pack();
							}
						}
					});
					addComponent(panel, layout, cbxMods, 0, 4, 2, 1, 1, 0, new Insets(0, 10, 10, 10));
					cbxMods.setVisible(false);

					lblMods.setVisible(true);
					cbxMods.setVisible(true);
					lblName.setVisible(true);
					txfName.setVisible(true);
					btnAccept.setVisible(true);

					btnPath.setEnabled(false);
					btnContinue.setEnabled(false);

					frame.pack();
				} else
					JOptionPane.showMessageDialog(null, Strings.getString("Main.5"), Strings.getString("Main.6"),
							JOptionPane.ERROR_MESSAGE);

				// System.out.println("MAX DU PFOSTEN");
			}
		});
		addComponent(panel, layout, btnContinue, 1, 2, 1, 1, 0, 0, new Insets(0, 10, 10, 10));

		lblMods = new JLabel(Strings.getString("Main.7"), SwingConstants.LEFT);
		lblMods.setForeground(Color.black);
		lblMods.setFont(fntStandart);
		addComponent(panel, layout, lblMods, 0, 3, 2, 1, 1, 0, new Insets(10, 10, 5, 10));
		lblMods.setVisible(false);

		lblName = new JLabel(Strings.getString("Main.8"), SwingConstants.LEFT);
		lblName.setForeground(Color.black);
		lblName.setFont(new Font("Verdana", 0, 12));
		addComponent(panel, layout, lblName, 0, 5, 2, 1, 1, 0, new Insets(5, 10, 5, 10));
		lblName.setVisible(false);

		txfName = new JTextField();
		txfName.setEditable(true);
		txfName.setForeground(Color.black);
		txfName.setBackground(Color.white);
		addComponent(panel, layout, txfName, 0, 6, 2, 1, 1, 0, new Insets(0, 10, 10, 10));
		txfName.setVisible(false);

		btnAccept = new JButton(Strings.getString("Main.9"));
		btnAccept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread loadingThread = new Thread(new Runnable() {

					@Override
					public void run() {

						Thread loadLoadingGUI = new Thread(new Runnable() {

							@Override
							public void run() {

								try {
									loadGUI();
								} catch (IOException | InterruptedException e) {

									e.printStackTrace();
								}
							}
						});
						loadLoadingGUI.start();

						try {
							new GUI();
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

				if (cbxMods.getSelectedItem().equals(Strings.getString("Main.10"))) {

					if (txfName.getText().trim() != null && !txfName.getText().trim().equals("")) {

						System.out.println("Text:" + txfName.getText() + "!");

						loadingThread.start();
					} else
						JOptionPane.showMessageDialog(null, Strings.getString("Main.11"), Strings.getString("Main.6"),
								JOptionPane.ERROR_MESSAGE);
				} else
					loadingThread.start();
			}
		});
		addComponent(panel, layout, btnAccept, 1, 7, 1, 1, 0, 0, new Insets(0, 10, 10, 10));
		btnAccept.setVisible(false);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	static String getModFolderName() {

		String s = "";

		if (cbxMods.getSelectedItem().equals(Strings.getString("Main.10")))
			s = txfName.getText().trim();
		else
			s = (String) cbxMods.getSelectedItem();

		s = path + s;

		return s;
	}

	static void addComponent(Container cont, GridBagLayout gbl, Component c, int x, int y, int width, int height,
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

	static void loadGUI() throws IOException, InterruptedException {

		frame.setTitle(Strings.getString("loading"));

		btnPath.setEnabled(false);
		btnContinue.setEnabled(false);
		txfPath.setEditable(false);

		btnPath.setVisible(false);
		btnContinue.setVisible(false);
		txfPath.setVisible(false);
		lblPath.setVisible(false);

		try {
			panel.removeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(Main.class.getResource("/loading.gif"));

		JLabel label = new JLabel(Strings.getString("load"));
		label.setForeground(clrFont);
		label.setFont(fntStandart);
		addComponent(panel, layout, label, 0, 0, 1, 1, 0, 0, new Insets(5, 5, 5, 5));

		addComponent(panel, layout, new JPanel(), 1, 0, 1, 1, 1, 0, new Insets(0, 0, 0, 0));

		JLabel gif = new JLabel(icon);
		addComponent(panel, layout, gif, 2, 0, 1, 1, 0, 0, new Insets(5, 0, 5, 5));

		gif.setVisible(false);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		addComponent(panel, layout, progressBar, 0, 1, 3, 1, 1, 0, new Insets(5, 5, 5, 5));

		frame.pack();
		frame.setLocationRelativeTo(null);

		while (!finishedLoading)
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		frame.setVisible(false);
	}
}
