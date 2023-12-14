package Utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig 
{

	Properties properties;
	String path= "Config.properties";
	
	public Readconfig() 
	{
		try {
		properties=new Properties();
		
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/*public String getBaseUrl()
	{
		String value=properties.getProperty("baseurl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified config file");
	}*/
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified config file");
	}

	
	
	
	
}
