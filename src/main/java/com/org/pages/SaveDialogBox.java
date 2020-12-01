package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

public class SaveDialogBox  extends UIOperation {
	
	public SaveDialogBox(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(SaveDialogBox.class.getName());
	 public static final String title="//md-dialog-content[1]/form[1]/md-input-container[1]/input[1]";//"//*[@id=\"input_5\"]";
	 public static final String Save="//button[contains(text(),'Save')]";
	
	
	public void clickSave() {
		 clickXpath(Save);
		 logger.info("# Clicked save button");
	}
	
	public void entertitle(String textEnter) {
		EnterTextXpath(title,textEnter);
	        logger.info("# Title Entered :"+ textEnter);
	}

	
	
	

}
