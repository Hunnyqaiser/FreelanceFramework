package test.Pages;
import com.Helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	protected By menu_btn = By.xpath("//img[@alt='menu']");
	protected By user_field = By.xpath("//input[@id='email1']");
	protected By pass_field = By.xpath("//input[@name='password1']");
	protected By login_btn = By.xpath("//button[normalize-space()='Log in']");
	protected By signIn_btn = By.xpath("//button[@class='submit-btn']");
	
	
	public HomePage loginToApp(String user_name, String password)
	{
		Utility.waitForElement(driver, menu_btn).click();
		Utility.waitForElement(driver, login_btn).click();
		Utility.waitForElement(driver, user_field).sendKeys(user_name);
		Utility.waitForElement(driver, pass_field).sendKeys(password);
		Utility.waitForElement(driver, signIn_btn).click();

		HomePage home=new HomePage(driver);
		return home;
		}

}
