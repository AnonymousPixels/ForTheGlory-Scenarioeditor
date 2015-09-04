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

import javax.crypto.Cipher;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Main {

	static JFrame frame;
	static JPanel panel;
	static GridBagLayout layout;

	static JLabel lblPath;
	static JTextField txfPath;
	static JButton btnPath, btnContinue;

	static JFileChooser chooser;
	static File file;
	static String path = "";

	static Color clrBackground = new Color(240, 240, 240), clrFont = new Color(
			0, 0, 0);
	static Font fntStandart = new Font("Sans Serif", 1, 12);

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out
					.println("Error while setting LookAndFeel! Default Java LookAndFeel will be used...");
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
		addComponent(frame, layout, panel, 0, 0, 1, 1, 1, 1, new Insets(0, 0,
				0, 0));

		lblPath = new JLabel(Strings.getString("Main.2"), SwingConstants.LEFT);
		lblPath.setForeground(clrFont);
		lblPath.setFont(fntStandart);
		addComponent(panel, layout, lblPath, 0, 0, 1, 1, 1, 0, new Insets(10,
				10, 10, 10));

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

		addComponent(panel, layout, btnPath, 1, 0, 1, 1, 0, 0, new Insets(10,
				0, 10, 10));

		txfPath = new JTextField();
		txfPath.setEditable(false);
		txfPath.setForeground(clrFont);
		txfPath.setBackground(Color.white);
		txfPath.setPreferredSize(new Dimension(300, 20));
		addComponent(panel, layout, txfPath, 0, 1, 2, 1, 1, 0, new Insets(0,
				10, 10, 10));

		addComponent(panel, layout, new JPanel(), 0, 2, 1, 1, 1, 0, new Insets(
				0, 0, 0, 0));

		btnContinue = new JButton(Strings.getString("Main.4"));
		btnContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (path != null && path != "") {

					frame.setVisible(false);
					try {
						new GUI();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null,
							Strings.getString("Main.5"),
							Strings.getString("Main.6"),
							JOptionPane.ERROR_MESSAGE);
			}
		});
		addComponent(panel, layout, btnContinue, 1, 2, 1, 1, 0, 0, new Insets(
				0, 10, 10, 10));

		frame.pack();
		frame.setLocationRelativeTo(null);
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
}