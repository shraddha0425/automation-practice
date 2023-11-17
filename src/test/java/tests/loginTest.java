package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestSetup;
import utility.BaseClass;
import utility.ExcelUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class loginTest extends TestSetup{
	BaseClass base=new BaseClass();
	ExcelUtility excel=new ExcelUtility();
  @Test
  public void login() {
	  LoginPage lp=new LoginPage();
	  HomePage hp=new HomePage();
	  try {
		  for(int i=1;i<=excel.lastRowNum("Sheet1");i++)
		  {
		  lp.verifyLoginTitle();
		  lp.LoginOpenEMR(excel.getCellData("Sheet1", i, 0), excel.getCellData("Sheet1", i, 1), "English (Indian)");
		  base.sleep();
		  try {
		 // hp.verifyHomePageTitle();
		  excel.setCellData("Sheet1", i, 2, "Right Data");
		  hp.logoutOpenEMR();
		  base.sleep();
		  lp.verifyLoginTitle();
		  base.CaptureScreenshot("C:\\Users\\Admin\\eclipse-workspace\\OpenEMR\\src\\test\\resources");}
		  catch (Exception e) {
			excel.setCellData("Sheet1", i, 2, "Wrong Data");
		}
	  }
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  base.CaptureScreenshot("C:\\Users\\Admin\\eclipse-workspace\\OpenEMR\\src\\test\\resources");
	}
  }
 

}
