package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Helper.Utility;



public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	protected By menu_btn = By.xpath("//img[@alt='menu']");
	protected By user_field = By.xpath("");
	protected By pass_field = By.xpath("");
	protected By login_btn = By.xpath("//button[normalize-space()='Log in']");
	protected By forgot_pass = By.xpath("");
	
	
	public void loginToApp()
	{
		driver.findElement(menu_btn).click();
		driver.findElement(login_btn).click();
		}

}
