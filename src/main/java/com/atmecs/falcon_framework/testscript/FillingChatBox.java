package com.atmecs.falcon_framework.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon_framework.constant.FilePathConstants;
import com.atmecs.falcon_framework.constant.LocatorKeyContainer;
import com.atmecs.falcon_framework.testsuite.SampleTestSuiteBase;
import com.atmecs.locatorSmartFixTool.models.SmartFixPageFileHandler;

public class FillingChatBox extends SampleTestSuiteBase 
{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleTest(String os, String osVersion, String br, String browserVersion) throws InterruptedException 
	{
		// Handling Frames
		report.info("Opening browser: " + br);
		browser.openURL(SmartFixPageFileHandler.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
								LocatorKeyContainer.BROWSER_URL), os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();

		report.info("Waiting for sometimes to enable chatbox");
		browser.getWait().safeWait(15000);

		report.info("Switching to frame");
		browser.getWindowHandler().handleFrame().switchToFrame(browser.getDriver()
									.findElement(By.xpath(SmartFixPageFileHandler
									.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
									LocatorKeyContainer.SWITCHING_FRAME))));
		
		browser.getWait().safeWait(5000);
		report.info("Clicking chat icon");
		browser.getDriver().findElement(By.xpath(SmartFixPageFileHandler
							.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
							LocatorKeyContainer.CLICK_CHAT_ICON))).click();
		
		browser.getWait().safeWait(5000);
		report.info("Entering name");
		browser.getTextField().enterTextField(LocatorType.XPATH, SmartFixPageFileHandler
								.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
								 LocatorKeyContainer.USER_NAME), "Abc");

		browser.getWait().safeWait(5000);
		report.info("Entering number");
		browser.getTextField().enterTextField(LocatorType.XPATH, SmartFixPageFileHandler
									.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
									 LocatorKeyContainer.MOBILE_NUMBER), "9823734854");

		browser.getWait().safeWait(5000);
		report.info("Entering mail");
		browser.getTextField().enterTextField(LocatorType.XPATH, SmartFixPageFileHandler
									.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
									 LocatorKeyContainer.USER_MAIL), "abc@gmail.com");
		
		browser.getWait().safeWait(5000);
		report.info("Clicking the Checkbox");
		browser.getClick().clickOnCheckBox(LocatorType.XPATH, SmartFixPageFileHandler
								.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
								 LocatorKeyContainer.CLICK_CHECKBOX));
		
		browser.getWait().safeWait(5000);
		report.info("Clicking dropdown");
		browser.getDropdown().selectByVisibleText(LocatorType.XPATH, SmartFixPageFileHandler
										.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
										 LocatorKeyContainer.SELECT_VALUE_FROM_DROPDOWN), "Yes");

		browser.getWait().safeWait(5000);
		report.info("Starting the chat");
		browser.getFindFromBrowser().findElementByXpath(SmartFixPageFileHandler
							.getLocatorValue(FilePathConstants.FORM_FILLING_PATH,
							 LocatorKeyContainer.START_CHAT)).click();
		browser.getWait().safeWait(2000);
	}
}
