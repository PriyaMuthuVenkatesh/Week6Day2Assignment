package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadX extends BaseClass {
	
	@BeforeTest
	public void setData()
	{
		 sheetName="CreateLead";
	}
	
	@Test(dataProvider="getData",enabled=false)

	public  void createLead(String cName,String fName,String lName) {
	
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@name='companyName'][@class='inputBox']")).sendKeys(cName);
		driver.findElement(By.xpath("//input[@name='firstName'][@class='inputBox']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@name='lastName'][@class='inputBox']")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		

	}

}
