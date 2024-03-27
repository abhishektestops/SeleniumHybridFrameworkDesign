package abhishektestnet.seleniumFrameworkDesign.baseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

	public static String readPropertyFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"/src/main/resources/abhishektestnet/seleniumFrameworkDesign/propertyFiles/globalData.properties");
		prop.load(fis);
		return prop.get(key).toString();
		
	}
}
