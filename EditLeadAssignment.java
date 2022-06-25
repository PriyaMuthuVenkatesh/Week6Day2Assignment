package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssignment extends BaseClass{
	
	@BeforeTest
	public void setData() {
		sheetName="EL";
	}
	
	@Test(dataProvider="getData", priority=1)
	public void editLead(String fName, String cName) throws InterruptedException {

		//		* 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

//		* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		 Thread.sleep(2000);

//		* 8	Enter first name
		driver.findElement(By.xpath("//input[@name='firstName' and @id='ext-gen248']")).sendKeys(fName);
		 Thread.sleep(2000);

//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(2000);

//		* 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		 Thread.sleep(2000);

//		* 11 Verify title of the page
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("View Lead | opentaps CRM"))
			System.out.println("Title verified as " + title);
		else
			System.out.println("Incorrect title");

//		* 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

//		* 13 Change the company name
		WebElement cmpName = driver.findElement(By.id("updateLeadForm_companyName"));
		cmpName.clear();
		cmpName.sendKeys(cName);

//		* 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

//		* 15 Confirm the changed name appears
		String changedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if (changedName.contains(cName)) {
			System.out.println("Changed name is " + changedName);
		}

		else
			System.out.println("Incorrect name");



	}

}
