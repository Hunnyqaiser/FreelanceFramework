package test.Pages;

import com.Helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    protected By welcome_msg = By.xpath("//h4[normalize-space()='Welcome Admin Manager to Learn Automation Courses']");
    protected By menu_btn = By.xpath("//img[@alt='menu']");
    protected By logout_btn = By.xpath("//button[normalize-space()='Sign out']");


    public void welcomeMsgShows()
    {
        Assert.assertTrue(Utility.waitForElement(driver, welcome_msg).isDisplayed());
    }

    public void signOutOfApp()
    {
        Utility.waitForElement(driver, menu_btn).click();
        Utility.waitForElement(driver, logout_btn).click();

    }
}
