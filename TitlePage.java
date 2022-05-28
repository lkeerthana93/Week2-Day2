package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitlePage {
	
	public static void main(String[] args) {
		
		//set up driver
				WebDriverManager.chromedriver().setup();

				//Open the browser
				ChromeDriver driver = new ChromeDriver();


				//maximise the browser window
				driver.manage().window().maximize();

				//load the url
				driver.get("https://acme-test.uipath.com/login");
				
				driver.findElement(By.name("email")).sendKeys("kumar.testleaf@gmail.com");
				driver.findElement(By.name("password")).sendKeys("leaf@12");
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				System.out.println(driver.getTitle());
				
				driver.findElement(By.xpath("//a[text()='Log Out']")).click();
				
			//	driver.close();
	}

}
