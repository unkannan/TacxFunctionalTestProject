package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

public class Dashboardpage extends UIOperation {
	
	public Dashboardpage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(Dashboardpage.class.getName());
	
	 public static final String CreateWorkout="//md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[4]/button[1]/div[1]";
	 public static final String SignOut="//div[contains(text(),'Sign Out')]";

	public void clickCreateWorkOut() {
		 clickXpath(CreateWorkout);
	        logger.info("# Clicked on menu: Create Workout");
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void clickSignOut() {
		 clickXpath(SignOut);
	        logger.info("# Clicked on button: SignOut");
	}
}
