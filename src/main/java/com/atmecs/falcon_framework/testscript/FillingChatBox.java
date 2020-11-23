package com.atmecs.falcon_framework.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Find;
import com.atmecs.falcon.automation.ui.selenium.PageHelper;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.WindowHandler.FrameHandler;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon_framework.testsuite.SampleTestSuiteBase;

public class FillingChatBox extends SampleTestSuiteBase {
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleTest(String os, String osVersion, String br, String browserVersion) throws InterruptedException {
		// Handling Frames
		report.info("Opening browser: " + br);
		browser.openURL("https://phptravels.com/demo", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();

		report.info("Waiting for sometimes to enable chatbox");
		browser.getWait().safeWait(10000);

		report.info("Switching to frame");
		String frame = "//iframe[@id='chat-widget']";
		browser.getWindowHandler().handleFrame().switchToFrame(frame );
		//browser.getDriver().switchTo().frame("//iframe[@id='chat-widget']");
		//browser.getWindowHandler().handleFrame().switchToFrame("//iframe[@id='chat-widget']");
		report.info("Switched successfully");

		report.info("Clicking chat icon");
		browser.getClick().clickButtonByName(LocatorType.XPATH, "//div[@class='lc-xqoq0v e16i86ec0']");
		//browser.getFindFromBrowser().findElementByClassName("lc-1z06j5z e1dmt1bi1").click();
		//browser.getDriver().findElement(By.xpath("//div[@class='lc-1z06j5z e1dmt1bi1']")).click();
		  
		report.info("Entering name");
		browser.getTextField().enterTextField(LocatorType.XPATH, "//input[@id='name']", "Abc");
		// browser.getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Abc");

		String number = "//input[@id='8jc8ik9hqge_157564443267307015']";
		report.info("Entering number");
		browser.getTextField().enterTextField(LocatorType.XPATH, number, "9823734854");
		// browser.getDriver().findElement(By.xpath("(//input[@class='lc-1gz7fd7e1xplv9i0'])[2]")).sendKeys("9823734854");

		report.info("Entering mail");
		browser.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		
		report.info("Click dropdown");
		browser.getClick().performClick(LocatorType.XPATH, "//div[@class='lc-sgcxhz egtcv0s0']");
			  
		/*
		 * browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		 * report.info("waiting for 2 second"); browser.getWait().HardPause(2000);
		 * 
		 * 
		 * String text = browser.getCurrentPageTitle();
		 * report.info("verifying page title"); Verify.verifyString(text, "phptravels",
		 * "Verifying String Message ");
		 * 
		 * 
		 */
	}
}
