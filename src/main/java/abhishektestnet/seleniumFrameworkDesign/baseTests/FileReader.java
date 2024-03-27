package abhishektestnet.seleniumFrameworkDesign.baseTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileReader {

	public static String readPropertyFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"/src/main/resources/abhishektestnet/seleniumFrameworkDesign/propertyFiles/globalData.properties");
		prop.load(fis);
		return prop.get(key).toString();
		
	}
	
	public static List<HashMap<String, String>> readJsonFileIntoMap(String jsonFileName) throws StreamReadException, DatabindException, IOException {
		String filePath = System.getProperty("user.dir")+"/src/main/resources/JsonFiles/";
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> listMap = mapper.readValue(new File(filePath+jsonFileName), new TypeReference<List<HashMap<String,String>>>(){});
		return listMap;
	}
	
	public static void readCSVToMap() {
		
	}
}
