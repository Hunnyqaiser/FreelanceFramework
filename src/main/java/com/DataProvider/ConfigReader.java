package com.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Reporter;

public class ConfigReader 
{
	public static String getPropertyvalue(String key)
	{
		Properties property=new Properties();
		try {
			property.load(new FileInputStream(new File("./ConfigFiles/Config.properties")));
		} 
		catch (IOException e) 
		{
			Reporter.log("Issue with loading the Config.properties file "+e.getMessage());;
		}
		return key;
	}
	
}

