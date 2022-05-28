package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		//set up driver
		WebDriverManager.chromedriver().setup();

		//Open the browser
		ChromeDriver driver = new ChromeDriver();


		//maximise the browser window
		driver.manage().window().maximize();

		//Add Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//load the url
		driver.get("https://en-gb.facebook.com/");


		//Click on create account
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();

		//Enter First name & Lastname
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Keerthana");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("L");

		//Enter Mobile number & New password
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8870829249");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Keer@123");

		//Dropdown for DOB
		//Day
		WebElement dday = driver.findElement(By.xpath("//select[@id='day']"));
		Select dd = new Select((dday));
		dd.selectByValue("8");

		//Month
		WebElement dmon = driver.findElement(By.xpath("//select[@id='month']"));
		Select dm = new Select((dmon));
		dm.selectByVisibleText("Dec");

		//Year
		WebElement dyear = driver.findElement(By.xpath("//select[@id='year']"));
		Select dy = new Select((dyear));
		dy.selectByValue("1993");

			
		//Radio
		driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[@value='1']")).click();
		
		}				
}
