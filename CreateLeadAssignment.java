package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssignment extends BaseClass {

	@BeforeTest
	public void setData() {
		sheetName = "CL";
	}

	@Test(dataProvider = "getData", priority=-2)
	public void lead(String cName, String fName, String lName, String fLocal, String dept, String descr, String email,
			String city) {
		// TODO Auto-generated method stub

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fLocal);
		driver.findElement(By.name("departmentName")).sendKeys(dept);
		driver.findElement(By.name("description")).sendKeys(descr);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		Select option = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		option.selectByVisibleText(city);
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
