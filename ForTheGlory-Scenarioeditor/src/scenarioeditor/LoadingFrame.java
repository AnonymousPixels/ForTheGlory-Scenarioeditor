package scenarioeditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingFrame implements Runnable {

	JFrame frame;
	JPanel panel;
	JLabel label, lblGif;
	ImageIcon icon;
	GridBagLayout layout;
	Color clrBackground = new Color(240, 240, 240);
	
	public void run() {
		
		layout = new GridBagLayout();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLayout(layout);
		frame.setUndecorated(true);
		
		panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(clrBackground);
		addComponent(frame, layout, panel, 0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0));
		
		label = new JLabel(Strings.getString("loading"));
		label.setForeground(Color.black);
		label.setFont(new Font("Verdana", 0, 12));
		addComponent(panel, layout, label, 0, 0, 1, 1, 0, 0, new Insets(5, 5, 5, 5));
		
		icon = new ImageIcon(LoadingFrame.class.getResource("/loading.gif"));
		
		lblGif = new JLabel(icon);
		addComponent(panel, layout, lblGif, 1, 0, 1, 1, 0, 0, new Insets(5, 0, 5, 5));
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		while(GUI.loadingGUI) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		frame.setVisible(false);
		GUI.terminatedLoadingGUI = true;
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
}
