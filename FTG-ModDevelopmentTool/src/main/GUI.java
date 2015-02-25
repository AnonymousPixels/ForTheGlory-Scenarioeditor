package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	public static JFrame frame;
	public static JPanel trigger, szenario, input, preview;
	
	public static int width, height;
	
	public GUI() {
		
		frame = new JFrame("FTG Mod Development Tool | " + FTG.version);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		
		inputPnl();
		triggerPnl();
		szenarioPnl();
		previewPnl();
		
		frame.setVisible(true);
	}
	
	void inputPnl() {
		
		input = new JPanel();
		input.setBorder(BorderFactory.createTitledBorder("Input"));
		input.setBounds(10, 10, 625, 230);
		input.setLayout(null);

		frame.add(input);
	}
	
	void triggerPnl() {
		
		trigger = new JPanel();
		trigger.setBorder(BorderFactory.createTitledBorder("Trigger"));
		trigger.setBounds(645, 10, 625, 345);
		trigger.setLayout(null);
	
		frame.add(trigger);
	}
	
	void szenarioPnl() {
		
		szenario = new JPanel();
		szenario.setBorder(BorderFactory.createTitledBorder("Szenario"));
		szenario.setBounds(10, 250, 625, 430);
		szenario.setLayout(null);

		frame.add(szenario);
	}
	
	void previewPnl() {
		
		preview = new JPanel();
		preview.setBorder(BorderFactory.createTitledBorder("Preview"));
		preview.setBounds(645, 365, 625, 315);
		preview.setLayout(null);
		
		frame.add(preview);
	}
}
