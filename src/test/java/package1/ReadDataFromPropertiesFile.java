package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("Browser");
		System.out.println(Browser);
		
		

	}

}
