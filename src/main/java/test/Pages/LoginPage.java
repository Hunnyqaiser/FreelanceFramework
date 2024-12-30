package test.Pages;
import com.Helper.Utility;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


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
	protected By signUp_btn = By.xpath("//a[normalize-space()='New user? Signup']");
	protected By num_of_courses = By.xpath("//div[@class='course-card row']/following-sibling::div//h2");
	protected By num_of_socialMedia = By.xpath("//div[@class='social-btns']//a");
	
	protected By  email_field_text = By.name("email1");
	
	protected By password_field_text = By.name("password1");
	
	public String verifyEmailFiledText()
	{
		
		String emailfieldText=Utility.waitForElement(driver, email_field_text).getText();
		return emailfieldText;
	}
	
	public String verifyPasswordFiledText()
	{
		
		String passwordfieldText=Utility.waitForElement(driver, password_field_text).getText();
		return passwordfieldText;
	}
	
	
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
	
	
	public void urlValidation()
	{
		String url=	driver.getCurrentUrl();
		url.contentEquals("login");
	}
	
	public Sign_upPage clickOnSignUpButton()
	{
		Utility.waitForElement(driver, menu_btn).click();
		Utility.waitForElement(driver, login_btn).click();
		Utility.waitForElement(driver, signUp_btn).click();
		Sign_upPage signup=new Sign_upPage(driver);
		return signup;
	}
	
	public int checkNumOfCourses()
	{
		Reporter.log(driver.getTitle(), true);
		
		List<WebElement> listofCourses = driver.findElements(num_of_courses);
		
		for(WebElement ele : listofCourses)
		{
			System.out.println(ele.getText());
		}
		int numberofCourses =listofCourses.size();
		Utility.waitForElement(driver, menu_btn).click();
		return numberofCourses;
	}
	
	public int checkNumOfSocialMedia()
	{
		List<WebElement> listOfSocial =	driver.findElements(num_of_socialMedia);
		int numberoficons = listOfSocial.size();
		Reporter.log("Total Number of Social Media app icons are: "+numberoficons,true);
		return numberoficons;
	}
	
	public String verifyEnterEmailTextAvailable()
	{
		String emailTextString= Utility.waitForElement(driver, email_field_text).getText();
		
		return emailTextString;
	}

}
