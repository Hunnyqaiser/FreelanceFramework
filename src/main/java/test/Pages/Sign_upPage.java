package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.Helper.Utility;

public class Sign_upPage 
{
	WebDriver  driver;
	public Sign_upPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	protected By name_field = By.xpath("//input[@id='name']");
	protected By email_field = By.xpath("//input[@id='email']");
	protected By password_field = By.xpath("//input[@id='password']");
	protected By statetoselect = By.xpath("//select[@id='state']");
	protected By hobbies_field = By.xpath("//select[@id='hobbies']");
	protected By signup_btn = By.xpath("//button[normalize-space()='Sign up']");
	protected By successful_msg = By.xpath("//div[contains(text(),'Signup successfully, Please login!')]");
	
public void registerUser(String name, String email, String pass, String intrest, String gender, String state, String hobby)
{
	Utility.waitForElement(driver, name_field).sendKeys(name);
	Utility.waitForElement(driver, email_field).sendKeys(email);
	Utility.waitForElement(driver, password_field).sendKeys(pass);
	Utility.waitForElement(driver, By.xpath("//label[normalize-space()='"+intrest+"']")).click();
	Utility.waitForElement(driver, By.xpath("//label[normalize-space()='"+gender+"']")).click();
	Utility.selectByValue(driver, statetoselect, state);
	Utility.selectByValue(driver, hobbies_field, hobby);
	Utility.waitForElement(driver, signup_btn).click();
}

public boolean signUpMess()
{
	boolean status = false;
	
	try {
		status = Utility.waitForElement(driver, successful_msg, 10).isDisplayed();
	} 
	catch (Exception e)
	{
		Reporter.log(""+e.getMessage());
	}
	

	return status;
}
}
