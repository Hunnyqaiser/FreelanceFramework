package test;

import com.Pages.LoginPage;
import com.base.BaseClass;

public class LoginTest extends BaseClass 
{
	LoginPage login=new LoginPage(driver);
	
	login.loginToApp();
	
	

}
