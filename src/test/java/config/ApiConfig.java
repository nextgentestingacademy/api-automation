package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {

	public static String getBaseUri() {
		Properties properties = new Properties();
		
		InputStream input = ApiConfig.class.getClassLoader()
				.getResourceAsStream("config.properties");
		
		if(input == null) {
			throw new IllegalStateException
			("config.properties not found");
		}
		
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String baseUri=properties.getProperty("base.uri");
		
		if(baseUri == null || baseUri.isBlank()) {
			throw new IllegalStateException
			("base.uri is missing from the config.properties");
		}
		
		return baseUri;
	}
	
}
