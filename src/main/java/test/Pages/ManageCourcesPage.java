package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Helper.Utility;

public class ManageCourcesPage 
{
	WebDriver driver;
	public ManageCourcesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	protected By list_of_cources = By.xpath("//tr/td[2]");
	protected By delete_cources = By.xpath("//button[text()='Delete Courses']");
	protected By activate_cources = By.xpath("///button[text()='Activate Courses']");
	protected By de_activate_cources = By.xpath("//button[text()='Deactivate Courses']");
	protected By add_new_cources = By.xpath("//button[text()='Add New Course ']");
	
	protected By new_course_thumbnail = By.xpath("//input[@id='thumbnail']");
	protected By new_course_name = By.xpath("//input[@id='name']");
	protected By new_course_discription = By.xpath("//textarea[@id='description']");
	protected By new_course_instructor = By.xpath("//input[@id='instructorNameId']");
	protected By new_course_price = By.xpath("//input[@id='price']");
	protected By new_course_start_from = By.xpath("//input[@name='startDate']");
	protected By new_course_ends_on = By.xpath("//input[@name='endDate']");
	protected By new_course_catagory= By.xpath("//div[normalize-space()='Select Category']");
	protected By new_course_catagory_selec = By.xpath("//button[normalize-space()='Automation Testing']");
	protected By new_course_save = By.xpath("//button[normalize-space()='Save']");
	protected By new_course_cancel = By.xpath("//button[normalize-space()='Cancel']");
	
	
	public void addNewCourse()
	{
		Utility.waitForElement(driver, add_new_cources).click();
		Utility.waitForElement(driver, new_course_name).sendKeys("Selenium with Java");
		Utility.waitForElement(driver, new_course_discription).sendKeys("It's a Selenium Course With Java");
		Utility.waitForElement(driver, new_course_instructor).sendKeys("Mukaish Otwani");
		Utility.waitForElement(driver, new_course_price).sendKeys("20000");
		Utility.waitForElement(driver, new_course_start_from).clear();
		Utility.waitForElement(driver, new_course_start_from).sendKeys("11/19/2024");
		Utility.waitForElement(driver, new_course_ends_on).clear();
		Utility.waitForElement(driver, new_course_ends_on).sendKeys("06/30/2025");
		Utility.waitForElement(driver, new_course_catagory).click();
		Utility.waitForElement(driver, new_course_catagory_selec).click();
		Utility.waitForElement(driver, new_course_save).click();
	}
	
	
	
}
