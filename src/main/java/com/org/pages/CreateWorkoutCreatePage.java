package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.Dataprovider;
import com.org.utility.UIOperation;

public class CreateWorkoutCreatePage extends UIOperation {
	
	public CreateWorkoutCreatePage(WebDriver driver) {
		  super(driver);
	        this.driver = driver; 
	}
	static Logger logger = Logger.getLogger(CreateWorkoutCreatePage.class.getName());
	 public static final String distance_Kms="//md-toolbar[2]/div[1]/div[2]/div[1]/span[1]";
	 public static final String distanceincreaseindicator="//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[2]/div[1]/div[2]/div[2]/button[1]/ng-md-icon[1]";
	 public static final String save="//button[contains(text(),'save')]";
	

	public String getKms() {
		return getTextxpath(distance_Kms);
	}
	
	public void kmsworkedOutTotal(String kmsStr) {
		while (true) {
			if (getKms().equals(kmsStr))
				break;
			clickdistanceincreaseindicator();
		}
	}
	
	public void clickdistanceincreaseindicator() {
		 clickXpath(distanceincreaseindicator);
	}
	
	public void clicksave() {
		 clickXpath(save);
	        logger.info("# Clicked on link: save");
	}

}
