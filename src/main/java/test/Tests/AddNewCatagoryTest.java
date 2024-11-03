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
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		MCP.FindNameAndNumberOfCatagories();
	}
	
	@Test(priority = 3)
	public void addNewCatagory()
	{
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		MCP.addNewCatagory("Automation Testing");
		System.out.println("Names and number of Catagories after adding my own!!!");
		MCP.FindNameAndNumberOfCatagories();
	}
	
	@Test(priority = 4)
	public void verifyAddedCatagory()
	{
		ManageCatagoriesPage MCP=new ManageCatagoriesPage(driver);
		boolean status=	MCP.verifyCatagory().equalsIgnoreCase("Automation Testing");
		
		Assert.assertTrue(status, "Catagory Created Successfully!! ");
	}

}