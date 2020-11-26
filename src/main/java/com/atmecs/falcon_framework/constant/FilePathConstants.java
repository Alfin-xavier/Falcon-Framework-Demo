package com.atmecs.falcon_framework.constant;

import java.io.File;

public class FilePathConstants 
{
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;

	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;
	public final static String ATMECS_HOME = LOCATOR_HOME + "atmecs" + File.separator;

	public final static String LIB_HOME = USER_HOME + "lib" + File.separator;

	public final static String HOME_LOCATOR_PATH = ATMECS_HOME
			+ "HomeAtmecsIncDigitalSolutionsProductEngineeringServices.properties";
	
	public final static String FORM_FILLING_PATH = ATMECS_HOME + "HandlingFrames.properties";
	
	public final static String TESTDATA_HOME = RESOURCES_HOME + "testdatas" + File.separator;
	public final static String HANDLINGFRAMES_FILE = TESTDATA_HOME + "HandlingFrames.xlsx";
	

}
