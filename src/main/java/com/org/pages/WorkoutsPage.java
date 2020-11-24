package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.org.utility.UIOperation;

public class WorkoutsPage extends UIOperation {
	
	public WorkoutsPage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(WorkoutsPage.class.getName());
	 public static final String Workouts="//body[1]/section[3]/md-sidenav[1]/div[1]/md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[2]/button[1]/div[1]";
	 public static final String workoutstitle="//h4";
	
	
	public void clickWorkouts() {
		FluentwaitForElement(workoutstitle);
		 clickXpath(Workouts);
		  logger.info("# Clicked on link: Workouts");
	}
	
	public String getworkoutTitleNewlyCreated() {
		 return getTextxpath(workoutstitle);
	}
	
}
