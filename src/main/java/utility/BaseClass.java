package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	
	public WebDriver openBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			return driver;
		case "firefox":
			driver =new FirefoxDriver();
			return driver;

		default:
			System.out.println("Invalid Browser Name");
			return null;
		}
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public WebElement getElement(By by) {
		return driver.findElement(by);}
	
	public void type(By by, String text) {
		getElement(by).clear();
		getElement(by).sendKeys(text);
	}
	
	public void click(By by) {
		getElement(by).click();
	}
	
	public void select(By by,String option) {
		new Select(getElement(by)).selectByVisibleText(option);
	}
	
	public void mouseMove(By by) {
		new Actions(driver).moveToElement(getElement(by)).build().perform();
	}
	
	public void mouseClick(By by) {
		new Actions(driver).moveToElement(getElement(by)).click().perform();
	}
	
	public String getElementText(By by) {
		return getElement(by).getText();
	}
	
	public void sleep() {
		try {
			Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean verifyTitle(String titleName) {
		if(driver.getTitle().equals(titleName))
			return true;
		else
			return false;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void CaptureScreenshot(String path) {
		try {
			TakesScreenshot scr=(TakesScreenshot)driver;
			FileUtils.copyFile(scr.getScreenshotAs(OutputType.FILE), new File(path+"\\error.png"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
		
	}


