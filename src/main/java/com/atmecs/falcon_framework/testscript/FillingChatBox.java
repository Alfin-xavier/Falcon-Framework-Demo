package com.atmecs.falcon_framework.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon_framework.testsuite.SampleTestSuiteBase;

public class FillingChatBox extends SampleTestSuiteBase 
{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleTest(String os, String osVersion, String br, String browserVersion) 
	{
		// Handling Frames
		report.info("Opening browser: " + br);
		browser.openURL("https://phptravels.com/demo", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();

		report.info("entering text: " + "Selenium");
		browser.getTextField().enterTextField(LocatorType.NAME, "q", "Selenium");
		report.info("pressing enter key");
		browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		report.info("waiting for 2 second");
		browser.getWait().HardPause(2000);
		String text = browser.getCurrentPageTitle();
		report.info("verifying page title");
		Verify.verifyString(text, "Selenium - Google Search", "Verifying String Message ");

	}
}
