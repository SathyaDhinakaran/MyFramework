package com.myproject.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src=new File("./Config/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			 pro=new Properties();
			 pro.load(fis);
		    } 
		catch (Exception e) 
		{
			System.out.println("Unable to load config file>>"+e.getMessage());
			
		} 
		
	}

	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getDataFromConfig(String keyTosearch)
	{
		return pro.getProperty(keyTosearch);
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURl");
	}
}
