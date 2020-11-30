package com.atmecs.falcon_framework.util;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class FormFillingDataProvider 
{
	@DataProvider
	public Object[][] readData(Method method) throws IOException
	{
		ReadingDataFromXslx.readExcelData(method.getName());
		
		return ReadingDataFromXslx.readExcelData(method.getName());
	}
}
