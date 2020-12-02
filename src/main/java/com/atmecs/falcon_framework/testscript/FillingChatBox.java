package com.atmecs.falcon_framework.testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon_framework.pages.FillingChatFormPage;
import com.atmecs.falcon_framework.pages.TestDataObject;
import com.atmecs.falcon_framework.testsuite.SampleTestSuiteBase;
import com.atmecs.falcon_framework.util.FormFillingDataProvider;

public class FillingChatBox extends SampleTestSuiteBase
{
	String appUrl = PropertyParser.readEnvOrConfigProperty("appUrl");
	
	@BeforeMethod
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void initBrowser(String os, String osVersion, String br, String browserVersion)
	{
		this.os = os;
		this.osVersion = osVersion;
		this.br = br;
		this.browserVersion = browserVersion;
	}
	
	@Test(dataProvider = "readData", dataProviderClass = FormFillingDataProvider.class)
	public void Form_filling(TestDataObject testDataObject) 
	{
		// Handling Frames
		FillingChatFormPage fillingForm = new FillingChatFormPage(browser);
		
		fillingForm.navigation(appUrl, os, osVersion, br, browserVersion);
		
		fillingForm.switchToFrame();
		
		fillingForm.clickChatIcon();
		
		fillingForm.enterUserName(testDataObject.getUserName());
		
		fillingForm.enterMobileNumber(testDataObject.getMobileNumber());
		
		fillingForm.enterUserMail(testDataObject.getUserMail());
		
		fillingForm.clickCheckbox();
		
		fillingForm.selectValueFromDropDown();
		
		fillingForm.clickChatButton();
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		browser.closeBrowser();
	}
}

