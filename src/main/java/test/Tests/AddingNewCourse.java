package test.Tests;

import org.testng.annotations.Test;

import com.base.BaseClass;

import test.Pages.HomePage;
import test.Pages.LoginPage;
import test.Pages.ManageCourcesPage;

public class AddingNewCourse extends BaseClass
{
	
	
	@Test
	public void checkTheCoursedAlreadyAvailble()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ManageCourcesPage Mcp=new ManageCourcesPage(driver);
		login.loginToApp("admin@email.com", "admin@123");
		home.welcomeMsgShows();
		home.getListOfAvailableCourses();
		home.travelToAddNewCourse();
		Mcp.addNewCourse();
		home.getListOfAvailableCourses();
	}
	

}
