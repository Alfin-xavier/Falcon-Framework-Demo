package com.atmecs.falcon_framework.pages;

import org.openqa.selenium.By;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon_framework.constant.FilePathConstants;
import com.atmecs.falcon_framework.testscript.FillingChatBox;
import com.atmecs.falcon_framework.util.PropertyReader;

public class FillingChatFormPage extends BasePage
{
	Browser browser;
	
	private ReportLogService report = new ReportLogServiceImpl(FillingChatBox.class);
	
	PropertyReader formFilling = new PropertyReader(FilePathConstants.FORM_FILLING_PATH);
	
	public FillingChatFormPage(Browser browser) 
	{
		super(browser);
	}

	public void navigation(String appUrl,String os, String osVersion, String br, String browserVersion)
	{
		report.info("Opening browser: " + br);
		browser.openURL(appUrl, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		browser.getWait().safeWait(10000);
	}
	
	public void enterUserName(String string)
	{
		browser.getWait().safeWait(3000);
		report.info("Entering name");
		browser.getTextField().enterTextField(LocatorType.XPATH, formFilling.get("username"), string);
	}
	
	public void enterMobileNumber(String string)
	{
		browser.getWait().safeWait(3000);
		report.info("Entering number");
		browser.getTextField().enterTextField(LocatorType.XPATH, formFilling.get("mobile"), string);
	}
	
	public void enterUserMail(String string)
	{
		browser.getWait().safeWait(3000);
		report.info("Entering mail");
		browser.getTextField().enterTextField(LocatorType.XPATH, formFilling.get("usermail"), string);
	}
	
	public void clickChatButton()
	{
		browser.getWait().safeWait(3000);
		report.info("Starting the chat");
		browser.getClick().performClick(LocatorType.XPATH, formFilling.get("chatbutton"));
		browser.getWait().safeWait(2000);
	}
	
	public void switchToFrame()
	{
		report.info("Switching to frame");
		browser.getWindowHandler().handleFrame()
				.switchToFrame(browser.getDriver().findElement(By.xpath(formFilling.get("frame"))));
	}
	
	public void clickChatIcon()
	{
		browser.getWait().safeWait(3000);
		report.info("Clicking chat icon");
		browser.getClick().performClick(LocatorType.XPATH, formFilling.get("chaticon"));
	}
	
	public void clickCheckbox()
	{
		browser.getWait().safeWait(3000);
		report.info("Clicking the Checkbox");
		browser.getClick().performClick(LocatorType.XPATH, formFilling.get("checkbox"));
	}
	
	public void selectValueFromDropDown()
	{
		browser.getWait().safeWait(3000);
		report.info("Clicking dropdown");
		browser.getDropdown().selectByVisibleText(LocatorType.XPATH, formFilling.get("dropdown_selection"), "Yes");
	
	}
}
