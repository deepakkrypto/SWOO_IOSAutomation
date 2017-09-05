package Swoo_iOS.maven;



import java.util.ResourceBundle;


import io.appium.java_client.ios.IOSDriver;

@SuppressWarnings("deprecation")
public class UtilityiOS {
	
	public	IOSDriver dr=null;
	public static ResourceBundle rb ;
	

	public UtilityiOS(IOSDriver dr) {
		this.dr = dr;
		rb = ResourceBundle.getBundle("Object");
	}

	
	
		}
	
