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
    	alert.accept();
    	Utility.sleep(2);
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
