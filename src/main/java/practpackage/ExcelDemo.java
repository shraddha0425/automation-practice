package practpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtility;

public class ExcelDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.excelConnect("C:\\Users\\Admin\\Desktop\\inputfiledemo.xlsx");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
		for(int i=1;i<=excelUtility.lastRowNum("Sheet1");i++) {
			driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input")).sendKeys(excelUtility.getCellData("Sheet1", i, 0));
			driver.findElement(By.xpath("//input[@id='clearPass']")).sendKeys(excelUtility.getCellData("Sheet1", i, 1));
			new Select(driver.findElement(By.xpath("//select[@class='form-control']"))).selectByVisibleText("English (Indian)");
			driver.findElement(By.xpath("//form[@id='login_form']/descendant::button")).click();
			try {
				Actions action=new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//div[@title='Current user']"))).build().perform();
				action.moveToElement(driver.findElement(By.xpath("//div[@title='Current user']/descendant::li[contains(text(),'Logout')]"))).click().perform();
				excelUtility.setCellData("Sheet1", i, 2, "Pass");
			}
			catch (Exception e) {
				// TODO: handle exception
				excelUtility.setCellData("Sheet1", i, 2, "Fail");
			}
			
			Thread.sleep(3000);
			



		}
		excelUtility.writeExcel("C:\\Users\\Admin\\Desktop\\inputfiledemo.xlsx");
		driver.quit();

	}

}
