package test.Tests;

import com.DataProvider.DataProvidersClass;
import com.base.BaseClass;
import org.testng.annotations.Test;
import test.Pages.LoginPage;

public class LoginTest extends BaseClass 
{
	@Test(dataProvider = "TestData", dataProviderClass = DataProvidersClass.class)
	public void validLoginToApp()
	{
		LoginPage login=new LoginPage(driver);
		login.loginToApp();

	}
	

}
