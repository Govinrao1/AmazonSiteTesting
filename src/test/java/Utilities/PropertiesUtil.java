package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	  // to get properties from properties file
	 private static Properties properties;

	    static {
	        properties = new Properties();
	        try {
	            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\"
	          + "Org.Selenium_Project\\src\\test\\resources\\Properties\\ConfigFile.properties");
	            properties.load(fileInputStream);
	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	}

