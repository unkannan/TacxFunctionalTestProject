
package com.org.utility;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.org.enums.AppValidationConstantMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;


 
public abstract class UIOperation {

    protected WebDriver driver;

    
    
    public UIOperation(WebDriver driver) {
        this.driver = driver;
    }
    
    protected void clickXpath(String locator) {
    	driver.findElement(By.xpath(locator)).click();
    }
    
    /**
     * This function is to assert and click on the id element.
     */
    protected void clickID(String locator) {
        driver.findElement(By.id(locator)).click();
    }
  
    protected void EnterTextid(String locator,String text){
    	driver.findElement(By.id(locator)).sendKeys(text);
    }
    
    protected void EnterTextXpath(String locator, String textEnter) {
    	driver.findElement(By.xpath(locator)).sendKeys(textEnter);
	}
    protected String getTextxpath(String locator){
    	return driver.findElement(By.xpath(locator)).getText();
    }
    
    protected void FluentwaitForElement(final String xpathLocator) {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(1000, TimeUnit.SECONDS)			
				.pollingEvery(10, TimeUnit.SECONDS)			
				.ignoring(WebDriverException.class);
		
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
						return driver.findElement(By.xpath(xpathLocator));
				}
		});
    }
}
