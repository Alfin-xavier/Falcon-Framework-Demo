/***
 *
 */
package com.atmecs.falcon_framework.testsuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon_framework.util.ReadingDataFromXslx;

public class SampleTestSuiteBase {
	public Browser browser;

	@BeforeClass
	public void preSetup() {
		browser = new Browser();
	}

	@AfterClass
	public void teardown() {
		browser.closeBrowser();
	}

	@DataProvider
	public Object[][] readData(Method method) throws IOException
	{
		ReadingDataFromXslx.readExcelData(method.getName());
		
		return ReadingDataFromXslx.readExcelData(method.getName());
	}
}