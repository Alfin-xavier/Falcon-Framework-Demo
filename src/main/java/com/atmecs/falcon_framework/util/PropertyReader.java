package com.atmecs.falcon_framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader 
{
	Properties properties;
	public PropertyReader(String filePath)
	{
		properties = new Properties();
		try 
		{
			properties.load(new FileInputStream(new File(filePath)));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public String get(String key)
	{
		return properties.getProperty(key);
	}
}
