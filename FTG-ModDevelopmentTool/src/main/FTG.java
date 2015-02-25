package main;

import java.awt.Toolkit;

public class FTG {

	public static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static String version = "pre 0.1";
	
	public static void main(String[] args) {
		
		//if(width < 1280 || height < 720) System.exit(0);
		
		new GUI();
	}
}