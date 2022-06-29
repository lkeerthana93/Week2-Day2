package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("lk@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		Thread.sleep(3000);
		String Leadname = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]//a")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

		Thread.sleep(3000);
		String expectedTitle="Duplicate Lead | opentaps CRM";
		String Title=driver.getTitle();
		//System.out.println(Title);
		if(expectedTitle.equals(Title))
		{
			System.out.println("The title of the page is Duplicate Lead");
		}
		else
		{
			System.out.println("The title of the page isn't Duplicate Lead");
		}
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Create Lead']")).click();

		String dupname = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if(dupname.equals(Leadname))
		{
			System.out.println("The duplicate lead is same as captured name");
		}
		else
		{
			System.out.println("The duplicate lead is not the same as captured name");
		}

		driver.close();
	}
}
