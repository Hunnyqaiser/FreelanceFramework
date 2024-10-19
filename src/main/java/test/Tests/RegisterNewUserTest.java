package test.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.DataProvider.DataProvidersClass;
import com.base.BaseClass;
import test.Pages.LoginPage;
import test.Pages.Sign_upPage;

public class RegisterNewUserTest extends BaseClass 
{
	
	
	@Test(dataProvider="TestDataForAddingUser", dataProviderClass = DataProvidersClass.class)
	public void registerNewUserWithDataProvider(String name, String email, String pass, String intrest, String gender, String state, String hobby)
	{
		LoginPage login=new LoginPage(driver);
		login.clickOnSignUpButton();
		Sign_upPage signup=new Sign_upPage(driver);
		signup.registerUser(name, email, pass, intrest, gender, state, hobby);
		boolean status=signup.signUpMess();
		Assert.assertTrue(status, "Registration failed");
	}
	
	@Test()
	public void registerUserWithFaker()
	{
		
		LoginPage login=new LoginPage(driver);
		login.clickOnSignUpButton();
		Sign_upPage signup=new Sign_upPage(driver);
		signup.registerUser(null, null, null, null, null, null, null);
		
	}

}
