package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	Properties p = new Properties();
	InputStream is;
	String propertyfile = "web.properties"; 
	
	public PropertiesReader(){
		try {
			is = getClass().getClassLoader().getResourceAsStream(propertyfile);
			
			if(is != null) {
				p.load(is);
			}else {
				throw new FileNotFoundException("property file '"+propertyfile+"' ");
			}			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getResult(String result) {
		return  p.getProperty(result);
		
	}
	
}
