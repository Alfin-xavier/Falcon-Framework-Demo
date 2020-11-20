package com.atmecs.falcon_framework.testscript;

import org.openqa.selenium.By;
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

	String frame = "//iframe[@id='chat-widget']";

	@SuppressWarnings("deprecation")
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleTest(String os, String osVersion, String br, String browserVersion) 
	{
		// Handling Frames
		report.info("Opening browser: " + br);
		browser.openURL("https://phptravels.com/demo", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();

		report.info("Waiting for sometimes to enable chatbox");
		browser.getWait().HardPause(10000);

		report.info("Switching to frame");
		browser.getDriver().switchTo().frame("//iframe[@name='chat-widget']");

		report.info("Clicking chat icon");
		browser.getDriver().findElement(By.xpath("//div[@class='lc-1z06j5z e1dmt1bi1']")).click();
		
		report.info("Entering name");
		browser.getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Abc");
		
		report.info("Entering number");
		browser.getDriver().findElement(By.xpath("(//input[@class='lc-1gz7fd7 e1xplv9i0'])[2]")).sendKeys("9823734854");
		
		report.info("Entering mail");
		browser.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		
		
		/*
		 * browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		 * report.info("waiting for 2 second"); browser.getWait().HardPause(2000);
		 * 
		 * 
		 * String text = browser.getCurrentPageTitle();
		 * report.info("verifying page title"); Verify.verifyString(text, "phptravels",
		 * "Verifying String Message ");
		 */

	}
}
