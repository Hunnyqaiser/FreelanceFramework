package com.Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class BrowserFactory 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver getBrowser(String browser, String appURL) 
	{
		if(browser.equalsIgnoreCase("Chrome")|| browser.equalsIgnoreCase("Google Chrome"))
			{
				Reporter.log("running getBrowser from Browser factory", true);
				driver =new ChromeDriver();
				Reporter.log("Chrome Loaded", true);
			}
		else if (browser.equalsIgnoreCase("FireFox")||browser.equalsIgnoreCase("Mozilla Firefox"))
		{
			driver=new FirefoxDriver();
			}
		else if(browser.equalsIgnoreCase("Safari")||browser.equalsIgnoreCase("Apple safari"))
		{
			driver=new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")|| browser.equalsIgnoreCase("Microsoft Edge"))
		{
			driver=new EdgeDriver();
			}
		else 
		{
			Reporter.log("Error seting up browser we only support Chrome, Edge, Firefox and Safari only!!!!", true);
			}
		Reporter.log("before driver.get url!!!!!", true);
		driver.get(appURL);
		Reporter.log("after driver.get url!!!!!", true);
		driver.manage().window().maximize();
		Reporter.log(driver.getCurrentUrl(), true);
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
	

}
