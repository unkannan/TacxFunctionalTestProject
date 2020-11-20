package com.org.utility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.org.DriverFactory.DriverManager;
import com.org.DriverFactory.DriverManagerFactory;
import com.org.enums.AppValidationConstantMessages;
import com.org.enums.DriverType;

public class StartApplication {
	private static Properties prop = ConfigFileReader.ReadProperties();
	String URL = prop.getProperty("url");
    //String BROWSER = prop.getProperty("browser");
    public WebDriver driver;
    DriverManager driverManager;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    	driver=driverManager.getDriver();
        System.out.println("Setup");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(AppValidationConstantMessages.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (driver != null) {
        //   driver.quit();
        }
    }
}
