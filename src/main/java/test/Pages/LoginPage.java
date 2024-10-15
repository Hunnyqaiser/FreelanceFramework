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
	protected By user_field = By.xpath("");
	protected By pass_field = By.xpath("");
	protected By login_btn = By.xpath("//button[normalize-space()='Log in']");
	protected By forgot_pass = By.xpath("");
	
	
	public void loginToApp()
	{
		Utility.waitForElement(driver, menu_btn).click();
		Utility.waitForElement(driver, login_btn).click();
		}

}
