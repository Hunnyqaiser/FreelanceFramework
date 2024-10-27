package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.DataProvider.ConfigReader;
import com.Factory.BrowserFactory;
import com.Helper.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentReportListner implements ITestListener {
	
	ExtentReports extentReports=ExtentManager.getInstance();
	ExtentTest extentTest;
	
	public void onTestSuccess(ITestResult result)
	{
		if(ConfigReader.getPropertyvalue("ScreenshotOnSuccess").equalsIgnoreCase("True"))
	{
		String screenshotString= Utility.captureScreenshotAsByte(BrowserFactory.getDriver());
		extentTest.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotString).build());
	
	}
	else
	{
		extentTest.pass("Test Passed");
	}}
	
	public void onTestFailure(ITestResult result)
	{
		if(ConfigReader.getPropertyvalue("ScreenshotOnFailure").equalsIgnoreCase("True"))
		{
			String screenshotString=Utility.captureScreenshotAsByte(BrowserFactory.getDriver());
			extentTest.fail("Test failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotString).build());
		
		}
		else
		{
			extentTest.fail("Test Failed"+result.getThrowable().getMessage());
		}
		/*WebDriver driver= BrowserFactory.getDriver();
		String screenshotString=Utility.captureScreenshotAsByte(driver);
		extentTest.fail("Test Failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotString).build());
	*/
		}
	
	public void onTestSkipped(ITestResult result)
	{
		if(ConfigReader.getPropertyvalue("ScreenshotOnSkip").equalsIgnoreCase("True"))
		{
			String screenshotString=Utility.captureScreenshotAsByte(BrowserFactory.getDriver());
			extentTest.skip("Test Skipped"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotString).build());
		
		}
		else
		{
			extentTest.skip("Test Skipped"+result.getThrowable().getMessage());
		}}
	
	public void onTestStart(ITestResult result)
	{
		extentTest=extentReports.createTest(result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context)
	{
		extentReports.flush();
		
	}

}
