package testBase;

import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestSetup extends BaseClass{
	ExcelUtility excel=new ExcelUtility();

  @BeforeTest
  public void beforeTest() {
	  excel.excelConnect("C:\\Users\\Admin\\Desktop\\inputfiledemo.xlsx");
	  openBrowser("chrome");
	  openUrl("https://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
  }

  @AfterTest
  public void afterTest() {
	  excel.writeExcel("C:\\Users\\Admin\\Desktop\\inputfiledemo.xlsx");
	  closeBrowser();
  }

}
