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
	public void registerNewUserWithDataProvider(String name,String state)
	{
		System.out.println("Thread Name is: "+Thread.currentThread().getName());
		LoginPage login=new LoginPage(driver);
		login.clickOnSignUpButton();
		Sign_upPage signup=new Sign_upPage(driver);
		signup.registerUser(name, state);
		boolean status=signup.signUpMess();
		Assert.assertTrue(status, "Registration failed");
	}
	
	

}
