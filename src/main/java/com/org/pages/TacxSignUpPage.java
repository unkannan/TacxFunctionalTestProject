package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

public class TacxSignUpPage extends UIOperation{

	public TacxSignUpPage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(TacxSignUpPage.class.getName());
	
	 public static final String CreateAccount="create-account";
	 public static final String signup="signup";
	 public static final String Firstname="firstName";
	 public static final String Email="email";
	 public static final String Password="password";
	 public static final String Repeatpassword="repeatPassword";
	 public static final String agreeCheck="//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[1]/div[1]";
	 public static final String ageCheck="//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[2]/div[1]";
	

	public void clickCreateAccount() {
		try {
			clickID(CreateAccount);
		}
    	catch(Exception e) {}
	        logger.info("# Clicked on button: CreateAccount");
	}
	

	public void EnterSignUpDetails() {
		EnterTextid(Firstname,"name1");
			logger.info("# Firstname entered : name1");
		int randGen=(int)(Math.random() * (10000 - 50 + 1) + 50);
		EnterTextid(Email,"emailtxt"+randGen+"@gmail.com");
			logger.info("# Email entered : emailtxt"+randGen+"@gmail.com");
		EnterTextid(Password,"Abcde$1112");
			logger.info("# Password entered :");
		EnterTextid(Repeatpassword,"Abcde$1112");
			logger.info("# Repeatpassword entered :");
		clickXpath(agreeCheck);
			logger.info("# agree checkbox checked");
		clickXpath(ageCheck);		
			logger.info("# age checkbox checked");
	}

	public void clickSignUp() {
	        clickID(signup);
	        logger.info("# Clicked on button: signup");
	}
}
