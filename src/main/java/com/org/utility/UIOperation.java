
package com.org.utility;

import static org.testng.Assert.assertTrue;
import com.org.enums.AppValidationConstantMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public abstract class UIOperation {

    protected WebDriver driver;

    
    
    public UIOperation(WebDriver driver) {
        this.driver = driver;
    }
 
    /**
     * This function is to assert and click on the id element.
     */
    protected void assertAndClickID(String id) {
        assertElementPresentById(id);
        driver.findElement(By.id(id)).click();
    }

    /**
     * This function is assert and get the text present in element.
     */
    protected String assertAndGetText(String xpath) {
        assertElementPresent(xpath);
        return driver.findElement(By.xpath(xpath)).getText();
    }
     /**
     * This function is to assert element is present by id.
     */
    private void assertElementPresentById(String id) {
        assertTrue(isElementPresentById(id), "Element " + id + " not found.");
    }
    
    

    /**
     * This function is to verify weather element is present or not.
     */
    private boolean isElementPresentById(String id) {
        try {
            driver.findElement(By.id(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This function is to get element visibility.
     */
    protected boolean isElementVisible(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This function is to assert element by xpath.
     *
     * @param xpath: locator as xpath
     */
    protected void assertElementPresent(String xpath) {
    	waitForElement(xpath);
        assertTrue(isElementPresent(xpath), "Element " + xpath + " not found.");
    }
    protected void RefreshPage() {
    	driver.navigate().refresh();
    }
    /**
     * This function is to get the presence os element.
     *
     * @param xpath: locator as xpath
     * @return true/false
     */
    protected boolean isElementPresent(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    protected boolean isElementIDPresent(String id) {
        try {
            driver.findElement(By.id(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    protected String assertAndGetAttributeValueID(String ID) {
    	assertElementPresentById(ID);
        return driver.findElement(By.id(ID)).getAttribute("value");
    }
    
    /**
     * This function is to assert and get value by attribute.
     
    protected String assertAndGetAttributeValue(String xpath, String attribute) {
        assertElementPresent(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    /**
     * This function is to wait for element.
     *
     * @param xpath: locator as xpath
     */
    protected void waitForElement(String xpath) {
    	System.out.println(xpath);
        new WebDriverWait(driver, AppValidationConstantMessages.EXPLICIT_WAIT_TIME)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    
    protected void waitForElementID(String id) {
        new WebDriverWait(driver, AppValidationConstantMessages.EXPLICIT_WAIT_TIME)
            .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    /**
     * This function is to wait for element to be clickable.
     *
     * @param xpath: locator as xpath
     */
    protected void waitForElementClickable(String xpath) {
        new WebDriverWait(driver, AppValidationConstantMessages.EXPLICIT_WAIT_TIME)
            .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * This function is to wait for element visibility.
     */
    protected void waitForElementVisibility(String xpath) {
        new WebDriverWait(driver, AppValidationConstantMessages.EXPLICIT_WAIT_TIME)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * This function is to wait for element invisibility.
     */
    protected void waitForElementInvisibility(String xpath) {
        new WebDriverWait(driver, AppValidationConstantMessages.EXPLICIT_WAIT_TIME)
            .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * This function is to select option by visible text.
     */
    protected void selectByVisibleText(String xpath, String txt) {
        waitForElement(xpath);
        WebElement ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        select.selectByVisibleText(txt);
    }

    /**
     * This function is to select option by value.
     */
    protected void selectByValue(String xpath, String value) {
        waitForElement(xpath);
        WebElement ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        select.selectByValue(value);
    }
    
    /**
     * This function is to select option by value.
     */
    protected void selectByValue_UsingID(String id, String value) {
        waitForElementID(id);
        WebElement ele = driver.findElement(By.id(id));
        Select select = new Select(ele);
        select.selectByValue(value);
    }
    
	public void DropDownValue(String idStr,String xpathStr,String currency)  {
		waitForElementID(idStr);
		WebElement selectFromCurrencyDropDown = driver.findElement(By.id(idStr));
		
		Actions action = new Actions(driver);
			action.moveToElement(selectFromCurrencyDropDown);
				action.click();
					action.build().perform();
		
		waitForElement(xpathStr);
			driver.findElement(By.xpath(xpathStr)).sendKeys(currency);
				action.sendKeys(Keys.ENTER).build().perform();
	}

    /**
     * This function is get the first selected option fron Select element.
     */
    protected String getSelectTextByAttribute(String xpath, String attribute) {
        waitForElement(xpath);
        WebElement ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        return select.getFirstSelectedOption().getAttribute(attribute);
    }

    protected boolean isElementEnable(String xpath) {
    	waitForElement(xpath);
        if(driver.findElement(By.xpath(xpath)).isEnabled())
        	return true;
        	return false;
    }
    
    protected void EnterText(String locator,String text) {
    	waitForElementID(locator);
    	driver.findElement(By.id(locator)).sendKeys(text);
    	
	}
    
    protected void SelectOption(String locator) {
    	 waitForElement(locator);
    	 driver.findElement(By.xpath(locator)).click();
    }
}
