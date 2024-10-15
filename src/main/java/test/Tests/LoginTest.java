package test.Tests;

import com.DataProvider.DataProvidersClass;
import com.base.BaseClass;
import org.testng.annotations.Test;
import test.Pages.HomePage;
import test.Pages.LoginPage;

public class LoginTest extends BaseClass 
{
	@Test(dataProvider = "TestData", dataProviderClass = DataProvidersClass.class)
	public void validLoginToApp(String email, String pass)
	{
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		login.loginToApp(email, pass);
		home.welcomeMsgShows();


	}
	

}
