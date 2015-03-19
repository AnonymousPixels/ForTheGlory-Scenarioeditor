package main;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static JFrame frame;
	public static JPanel panel, panel2;

	public Main() {

		frame = new JFrame("Trigger & Commands");
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setSize(1280, 720);

		panel = new JPanel();
//		panel.setBackground(Color.lightGray);
		panel.setSize(frame.getWidth(), frame.getHeight()/2);
		panel.setLayout(new FlowLayout());
		
		panel2 = new JPanel();
//		panel2.setBackground(Color.red);
		panel2.setSize(frame.getWidth(), frame.getHeight()/2);
		panel2.setLayout(new FlowLayout());
		
		frame.setVisible(true);

		
		 new CommandPanel();
		new TriggerPanel();


	}

}
