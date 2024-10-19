package test.Tests;

import org.testng.annotations.Test;

import com.base.BaseClass;

import test.Pages.HomePage;
import test.Pages.LoginPage;

public class AddingNewCourse extends BaseClass
{
	
	
	@Test
	public void checkTheCoursedAlreadyAvailble()
	{
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		
		login.loginToApp("admin@email.com", "admin@123");
		home.welcomeMsgShows();
		home.getListOfAvailableCourses();
	}

}
