package com.atmecs.falcon_framework.pages;


import com.atmecs.falcon.automation.ui.selenium.Browser;

public class BasePage
{
	public Browser browser;
	
	public BasePage(Browser browser)
	{
		this.browser = browser;
	}
	
	public String os, osVersion, br, browserVersion;
	
}
