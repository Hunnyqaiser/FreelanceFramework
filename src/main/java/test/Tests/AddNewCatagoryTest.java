package test.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.DataProvider.DataProvidersClass;
import com.Helper.Utility;
import com.base.BaseClass;
import test.Pages.HomePage;
import test.Pages.LoginPage;
import test.Pages.ManageCatagoriesPage;

public class AddNewCatagoryTest extends BaseClass
{
	@Test(dataProvider = "TestData", dataProviderClass = DataProvidersClass.class, priority = 1)
	public void navigateToPage(String name, String pass)
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		HomePage HP=new HomePage(driver);
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		login.loginToApp(name, pass);
		HP.travelToManageCatagoriesPage();
		MCP.verifyManageCatagoriesIsDisplayed();
	}
	
	@Test(priority = 2)
	public void getCatagoriesDetails()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		MCP.FindNameAndNumberOfCatagories();
	}
	
	@Test(priority = 3)
	public void deleteIfAutomation2Availale()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		MCP.deleteIfCatagoryAlreadyAvailable();
	}
	

	@Test(priority = 4)
	public void addNewCatagory()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		MCP.addNewCatagory("Automation Testing2");
		System.out.println("Names and number of Catagories after adding my own!!!");
		MCP.FindNameAndNumberOfCatagories();
	}

	
	@Test(priority = 5)
	public void verifyAddedCatagory()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		boolean status=	MCP.verifyCatagory().equalsIgnoreCase("Automation Testing");
		Assert.assertFalse(status, "Category with same name already exists");
		//Assert.assertTrue(status, "Catagory Created Successfully!!");
	}

}
