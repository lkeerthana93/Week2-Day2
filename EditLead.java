package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
		//set up driver
		WebDriverManager.chromedriver().setup();

		//Open the browser
		ChromeDriver driver = new ChromeDriver();

		//load the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		//maximise the browser window
		driver.manage().window().maximize();

		//Login to the application
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on LEads
		driver.findElement(By.linkText("Leads")).click();
		
		
		//Click on Create Leads
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter Companyname 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Ford");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Harry");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Chartered Accountant");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("hari.harry@gmail.com");
		
		//Dropdown element tag
		WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//create obj for select class and link the droopdown ele
		Select dd = new Select(ele);
		
		//choose based on visible text
		dd.selectByVisibleText("New York");
		
		//Create Lead
		driver.findElement(By.name("submitButton")).click();
		
		//Edit & Clear
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Hello");
		
		driver.findElement(By.name("submitButton")).click();
		
		
		String titlePage = driver.getTitle();
		System.out.println("Title of the page : " + titlePage);
		
	}

}
