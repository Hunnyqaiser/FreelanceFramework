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
<<<<<<< HEAD

=======
	protected By signUp_btn = By.xpath("//a[normalize-space()='New user? Signup']");
	
>>>>>>> 146c8360d83bac67465f12928b57685c77621f2b
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
	
	public Sign_upPage clickOnSignUpButton()
	{
		Utility.waitForElement(driver, signUp_btn).click();
		Sign_upPage signup=new Sign_upPage(driver);
		return signup;
	}

}
