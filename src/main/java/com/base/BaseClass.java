package com.base;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.DataProvider.ConfigReader;
import com.Factory.BrowserFactory;

public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeClass
	public void browserSetup()
	{
		String browserToUse= ConfigReader.getPropertyvalue("browser");
		String url=ConfigReader.getPropertyvalue("appURL");
		Reporter.log("seting up Browser, running before class!!", true);
		driver = BrowserFactory.getBrowser(browserToUse, url);
		Reporter.log("Browser is up and running, running before class!!", true);		

	}
	
	@AfterClass
	public void teardownBrowser()
	{
		Reporter.log("Browser is about to teardown, running after class!!", true);
		BrowserFactory.closeBrowser();
		Reporter.log("Browser closed and quit!!", true);

	}
	
}
