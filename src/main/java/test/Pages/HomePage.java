package test.Pages;

import com.Helper.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    protected By welcome_msg = By.xpath("//h4[normalize-space()='Welcome Admin Manager to Learn Automation Courses']");
    protected By menu_btn = By.xpath("//img[@alt='menu']");
    protected By logout_btn = By.xpath("//button[normalize-space()='Sign out']");
    protected By cources_name_list = By.xpath("//div[@class='bottom-div col-lg-24']//h2"); //also "//div[@class='course-card row']"
    protected By list_of_courses= By.xpath("//div[@class='course-content']");
    protected By manage_btn = By.xpath("//span[normalize-space()='Manage']");
    protected By manage_cources = By.xpath("//a[text()='Manage Courses']");
    protected By manage_catagories = By.xpath("//a[text()='Manage Categories']");
    
    
    
    
    public void welcomeMsgShows()
    {
        Assert.assertTrue(Utility.waitForElement(driver, welcome_msg).isDisplayed());
    }

    public void signOutOfApp()
    {
        Utility.waitForElement(driver, menu_btn).click();
        Utility.waitForElement(driver, logout_btn).click();
    }
    
    public void getListOfAvailableCourses()
    {
    	List<WebElement> list	=driver.findElements(cources_name_list);
    	
    	Reporter.log("Size of list is: "+list.size(), true);
    	
    	for(WebElement ele : list)
    	{
    		System.out.println(ele.getText());
    	}
    }
    
    public ManageCourcesPage travelToAddNewCourse()
    {
    	Utility.waitForElement(driver, manage_btn).click();
    	Utility.waitForElement(driver, manage_cources).click();
    	ManageCourcesPage mcp=new ManageCourcesPage(driver);
    	return mcp;
    }
    
}
