package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

public class CreateWorkoutPage extends UIOperation {
	
	public CreateWorkoutPage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(CreateWorkoutPage.class.getName());
	 public static final String Distance="//p[contains(text(),'Distance')]";
	 public static final String Continue="//button[contains(text(),'Continue')]";
	 public static final String Power="//p[contains(text(),'Power')]";
	

	public void clickDistance() {
		 clickXpath(Distance);
	        logger.info("# Clicked on link: Distance");
	}
	
	public void clickContinue() {
		 clickXpath(Continue);
	        logger.info("# Clicked on link: Continue");
	}
	
	public void clickPower() {
		 clickXpath(Power);
	        logger.info("# Clicked on link: Power");
	}

}
