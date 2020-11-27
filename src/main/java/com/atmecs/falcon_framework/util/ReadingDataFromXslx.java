package com.atmecs.falcon_framework.util;

import java.io.IOException;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon_framework.constant.FilePathConstants;

public class ReadingDataFromXslx 
{
	public static Object[][] data;
	
	public static Object[][] readExcelData(String sheetname) throws IOException
	{		
		XlsReader xlsReader = new XlsReader();
		
		xlsReader.setPath(FilePathConstants.HANDLINGFRAMES_FILE);
		
		int rowCount = xlsReader.getRowCount(sheetname);
		
		int columnCount = xlsReader.getColumnCount(sheetname);
		
		data= new Object[rowCount][columnCount];
		
		for(int rowIndex =1 ; rowIndex < rowCount + 1; rowIndex ++) 
		{ 
			for(int columnIndex = 0; columnIndex < columnCount; columnIndex ++) 
			{
				String datas = xlsReader.getCellDataByColumnIndex(sheetname, columnIndex, rowIndex);
				
				data[rowIndex - 1][columnIndex] = datas;
			}
		}
		return data;
    }
}
