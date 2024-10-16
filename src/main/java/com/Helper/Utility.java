package com.Helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.DataProvider.ConfigReader;

public class Utility 
{
	 public static String  captureScreenshotAsByte(WebDriver driver)
	    {
	        TakesScreenshot ts=(TakesScreenshot)driver;
	        String ScreenshotAsBase64=ts.getScreenshotAs(OutputType.BASE64);
	        return ScreenshotAsBase64;
	    }
	    public static WebElement highLightWebElement(WebDriver driver, WebElement element)
	    {
	        JavascriptExecutor jsexe=(JavascriptExecutor)driver;
	        jsexe.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')",element);
	        sleep(1);
	        jsexe.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",element);
	        return element;
	    }
	    public static void sleep(int timeInSeconds)
	    {
	        try {
	            Thread.sleep(timeInSeconds*1000);
	        } catch (InterruptedException e)
	        {
	            Reporter.log("Log INFO: something went wrong in sleep Thread: "+e.getMessage(), true);
	        }
	    }
	    public static WebElement waitForElement(WebDriver driver ,By locator)
	    {
	        WebDriverWait wait=new WebDriverWait( driver, Duration.ofSeconds(20));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        String highLightcondition= ConfigReader.getPropertyvalue("HighLighter");
	        if(highLightcondition.equalsIgnoreCase("True"))
	        {
	            highLightWebElement(driver, element);
	        }
	        return element;
	    }
	    public static String currentDate()
	    {
	        SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_MM_yyyy");
	        String newFormat=myformat.format(new Date());
	        return newFormat;
	    }
	    
	    public static void selectByValue(WebDriver driver, By locator, String valueToSelect) 
	    {
	    	Select select=new Select(Utility.waitForElement(driver, locator));
	    	select.selectByValue(valueToSelect);
	    	
	    }
	    
	    public static void selectByValue(WebDriver driver, By locator, int intToSelect) 
	    {
	    	Select select=new Select(Utility.waitForElement(driver, locator));
	    	select.selectByIndex(intToSelect);
	    }
	    public static void selectByVisibleText(WebDriver driver, By locator, String visibleTextToSelect) 
	    {
	    	Select select=new Select(Utility.waitForElement(driver, locator));
	    	select.selectByVisibleText(visibleTextToSelect);
	    }
	

}
