package com.atmecs.falcon_framework.util;

import java.io.IOException;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon_framework.constant.FilePathConstants;
import com.atmecs.falcon_framework.pages.TestDataObject;

public class ReadingDataFromXslx 
{
	public static Object[][] data;
	
	public static Object[][] readExcelData(String sheetname) throws IOException
	{		
		XlsReader xlsReader = new XlsReader();
		
		xlsReader.setPath(FilePathConstants.HANDLINGFRAMES_FILE);
		
		int rowCount = xlsReader.getRowCount(sheetname);
		
		int columnCount = xlsReader.getColumnCount(sheetname);
		
		data= new Object[rowCount][1];
		
		for(int rowIndex = 1 ; rowIndex < rowCount + 1; rowIndex ++) 
		{ 
			TestDataObject testData = new TestDataObject();
			
			testData.setUserName(xlsReader.getCellDataByColumnIndex(sheetname, 0, rowIndex));
			
			testData.setMobileNumber(xlsReader.getCellDataByColumnIndex(sheetname, 1, rowIndex));
			
			testData.setUserMail(xlsReader.getCellDataByColumnIndex(sheetname, 2, rowIndex));
			
			data[rowIndex - 1][0] = testData;
		
		}
		return data;
    }
}
