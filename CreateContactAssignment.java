package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAssignment extends BaseClass {

	private static final CharSequence desc = null;

	@BeforeTest
	public void setData() {
		sheetName="CreateContact";
	}
	
	@Test(dataProvider="getData", priority=-1, invocationCount=3)

	public void createContact(String fName, String lName, String fLocal, String lLocal, String dept, String descr,String email, String city, String update ) {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(fName);
		driver.findElement(By.id("lastNameField")).sendKeys(lName);
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(fLocal);
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(lLocal);
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(dept);
		driver.findElement(By.id("createContactForm_description")).sendKeys(descr);
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
		Select option = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		option.selectByVisibleText(city);
		driver.findElement(By.name("submitButton")).click();

		// edit contact
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_description")).sendKeys(update);
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// print title of the page
		System.out.println(driver.getTitle());

	}

}
