package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9566082191");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		Thread.sleep(3000);

		String LeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("The first Lead id is" + LeadID);


		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following::input[@name='id']")).sendKeys(LeadID);

		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(5000);
		String DisplayText = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		String ExpectedText= "No records to display";
		if (DisplayText.equals(ExpectedText))
		{
			System.out.println("Successful deletion");
		}
		else
		{
			System.out.println("Deletion was not successful");
		}
		driver.close();
	}
}