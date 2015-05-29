package eventgenerator;

import java.awt.Toolkit;
import java.util.Properties;

public class FTG {

	public static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static Properties properties= new Properties();
	public static String version = "1.0";
	
	public static void main(String[] args) {
		
		//if(width < 1280 || height < 720) System.exit(0);
		
		new GUI();
	}
}