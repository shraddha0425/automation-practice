package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import utility.BaseClass;

public class LoginPage extends BaseClass {
	By usernameField= By.xpath("//input[@id='authUser']");
	By passwordField= By.xpath("//input[@id='clearPass']");
	By langDropDown= By.xpath("//select[@class='form-control']");
	By loginButton= By.xpath("//button[@id='login-button']");
	
	public void verifyLoginTitle() {
	Assert.assertEquals(verifyTitle("OpenEMR Login"),true);
	}
	
	public void LoginOpenEMR(String un,String pw,String lang) {
		type(usernameField,un);
		type(passwordField,pw);
		select(langDropDown,lang);
		click(loginButton);
	}

	

}
