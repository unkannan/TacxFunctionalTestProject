package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

public class TacxMainPage extends UIOperation{

	public TacxMainPage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(TacxMainPage.class.getName());
	
	 public static final String CreateAccount="create-account";
	 public static final String signup="signup";
	 public static final String Firstname="firstName";
	 public static final String Email="email";
	 public static final String Password="password";
	 public static final String Repeatpassword="repeatPassword";
	 public static final String agreeOption="//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[1]/div[1]";
	 public static final String ageOption="//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[2]/div[1]";
	

	public void clickCreateAccount() {
		 waitForElementID(CreateAccount);
	        assertAndClickID(CreateAccount);
	        logger.info("# Clicked on button: CreateAccount");
	}
	

	public void EnterSignUpDetails() {
		EnterText(Firstname,"name1");
		int randGen=(int)(Math.random() * (1000 - 50 + 1) + 50);
		EnterText(Email,"emailtxt"+randGen+"@gmail.com");
		EnterText(Password,"Abcde$1112");
		EnterText(Repeatpassword,"Abcde$1112");
		//driver.findElement(By.xpath("//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[1]/div[1]")).click();
		SelectOption(agreeOption);
		SelectOption(ageOption);		
	}

	public void clickSignUp() {
		 waitForElementID(signup);
	        assertAndClickID(signup);
	        logger.info("# Clicked on button: signup");
	}
}
