package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import utility.BaseClass;

public class HomePage extends BaseClass {

	By profileIcon=By.xpath("//div[@title='Current user']");
	By logoutButton=By.xpath("//div[@title='Current user']/descendant::li[contains(text(),'Logout')]");
	
	public void verifyHomePageTitle() {
		Assert.assertEquals(verifyTitle("OpenEMR"), true);
	}
	
	public void logoutOpenEMR() {
	mouseMove(profileIcon);
	mouseClick(logoutButton);
	}

}
