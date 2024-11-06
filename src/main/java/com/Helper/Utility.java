package com.Helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
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
	        WebDriverWait wait=new WebDriverWait( driver, Duration.ofSeconds(30));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        String highLightcondition= ConfigReader.getPropertyvalue("HighLighter");
	        if(highLightcondition.equalsIgnoreCase("True"))
	        {
	            highLightWebElement(driver, element);
	        }
	        return element;
	    }
	    
	    public static WebElement waitForElement(WebDriver driver ,By locator, int timeinseconds)
	    {
	        WebDriverWait wait=new WebDriverWait( driver, Duration.ofSeconds(timeinseconds));
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
	    
	    public static String generateRandomEmail(int lenght)
	    {
	    	String randomemail=RandomDataGenerator.generateRandomEmail(lenght);
	    	
	    	return randomemail;
	    }
	    
	    public static String genrateRandomPassword(int lenght)
	    {
	    	String randomPass=RandomDataGenerator.generateRandomPassword(lenght);
	    	
	    	return randomPass;
	    }
	    
	    public static String useRandomWord(String word, String word1)
	    {
	    	List<String> myWords = List.of(word, word1);
	    	String randomWord = RandomDataGenerator.getRandomElementFromList(myWords);
	    	return randomWord;
	    }
	    public static String useRandomWord(String word, String word1, String word2,String word3)
	    {
	    	List<String> myWords = List.of(word, word1,word2,word3);
	    	String randomWord = RandomDataGenerator.getRandomElementFromList(myWords);
	    	return randomWord;
	    }
		
	    public static void accpetAlerBySendingMessage(WebDriver driver, String altMess)
	    {
	    	TargetLocator target=driver.switchTo();
	    	Alert alert=target.alert();
	    	alert.sendKeys(altMess);
	    }
	
	

}
