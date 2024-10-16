package test.Tests;

import org.testng.annotations.Test;

import com.DataProvider.DataProvidersClass;
import com.base.BaseClass;

import test.Pages.Sign_upPage;

public class RegisterNewUserTest extends BaseClass 
{
	
	
	@Test(dataProvider="TestDataForAddingUser", dataProviderClass = DataProvidersClass.class)
	public void registerNewUserWithDataProvider(String name, String email, String pass, String intrest, String gender, String state, String hobby)
	{
		Sign_upPage signup=new Sign_upPage(driver);
		signup.registerUser(name, email, pass, intrest, gender, state, hobby);
	}

}
