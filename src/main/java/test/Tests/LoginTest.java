package test.Tests;

import com.DataProvider.DataProvidersClass;
import com.Helper.Utility;
import com.base.BaseClass;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import test.Pages.HomePage;
import test.Pages.LoginPage;

public class LoginTest extends BaseClass 
{
	@Test(dataProvider = "TestData", dataProviderClass = DataProvidersClass.class, priority = 1)
	public void validLoginToApp(String email, String pass)
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		login.loginToApp(email, pass);
		boolean	loginstatus = home.welcomeMsgShows();
		Assert.assertTrue(loginstatus);
	}
	
	
	@Test(priority = 2)
	public void getNumbOfCoursesOnPage()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		Utility.sleep(3);
		System.out.println(login.verifyEmailFiledText());
		int number = login.checkNumOfCourses();
		
		if (number>0)
		{
			Assert.assertTrue(number>0);
			Reporter.log("Number of Courses is "+ number, true);
		}
		else
		{
			Assert.assertTrue(number<=0);
			Reporter.log("Test failed Number of Courses is less than 0 "+ number, true);
		}
		
	}
	@Test (priority =3)
	public void getNumberOfSocialMediaIcons()
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		Utility.sleep(3);
		int num=	login.checkNumOfSocialMedia();
		boolean status= false;
		
		if(num>0)
		{
			Assert.assertTrue(status =  true);
			Reporter.log("number of social media apps is more than 0: number is:"+ num);
		}
		else
		{
			Assert.assertFalse(status);
			Reporter.log("Test failed number of social media apps is 0");
		}
	}
	
	
}
