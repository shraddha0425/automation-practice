package seleniumPract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutDDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
		String[][] arr=new String[][]{{"admin","pass"},{"physician","physician"},{"clinician","clinician"}};
		/*for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}*/
		driver.findElement(By.xpath("//input[@id='authUser']")).sendKeys("admin");

	}

}
