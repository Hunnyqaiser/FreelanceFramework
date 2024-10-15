package test.Tests;

import com.base.BaseClass;
import org.testng.annotations.Test;
import test.Pages.LoginPage;

public class LoginTest extends BaseClass 
{
	@Test
	public void validLoginToApp()
	{
		LoginPage login=new LoginPage(driver);
		login.loginToApp();

	}
	

}
