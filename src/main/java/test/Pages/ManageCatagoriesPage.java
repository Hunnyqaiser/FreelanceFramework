package test.Pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Helper.Utility;

public class ManageCatagoriesPage 
{
	WebDriver driver;
	
	public ManageCatagoriesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	protected By manage_catagoris_text = By.xpath("//h1[normalize-space()='Manage Categories']");
	protected By add_new_catagory_btn = By.xpath("//button[normalize-space()='Add New Category']");
	protected By all_cat_names = By.xpath("//th[normalize-space()='Cateogry Name']/following::tr//td[1]");
	protected By automation_testing2 = By.xpath("//td[text()='Automation Testing2']");
	protected By delete_cat = By.xpath("//td[text()='Automation Testing2']/following::button[1]");
	protected By delete_button = By.xpath("//button[text()='Delete']");
	
	public void verifyManageCatagoriesIsDisplayed()
	{
		Utility.waitForElement(driver, manage_catagoris_text).isDisplayed();
	}

	
	public void FindNameAndNumberOfCatagories()
	{
		List<WebElement> listOfCatagories=driver.findElements(all_cat_names);
		
		for(WebElement ele:listOfCatagories)
		{
			System.out.println(ele.getText());
		}
		System.out.println("Number of Catagories is: "+listOfCatagories.size());
	}
	
	public void addNewCatagory(String catagoryName)
	{
		Utility.waitForElement(driver, add_new_catagory_btn).click();
		Alert alert=driver.switchTo().alert();
    	alert.sendKeys(catagoryName);
    	Utility.sleep(2);
    	alert.accept();
    	Utility.sleep(2);
	}
	
	public void deleteIfCatagoryAlreadyAvailable()
	{
		List<WebElement> listOfCatagories=driver.findElements(all_cat_names);
		
		for(WebElement ele:listOfCatagories)
		{
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase("Automation Testing2"))
			{
				Utility.waitForElement(driver, automation_testing2).click();
				Utility.waitForElement(driver, delete_cat).click();
				Utility.waitForElement(driver, delete_button).click();
			}
		}
	
		System.out.println("Number of Catagories is: "+listOfCatagories.size());
	}
	
	public String verifyCatagory()
	{
		String	catagoryText = null;
		{
			List<WebElement> listOfCatagories=driver.findElements(all_cat_names);
			
			for(WebElement ele:listOfCatagories)
			{
				catagoryText= ele.getText();
				System.out.println(catagoryText);
			}
	}
		return	catagoryText;
}
	}
