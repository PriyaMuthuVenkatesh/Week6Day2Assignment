package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	public String sheetName;

	@Parameters({ "url", "username", "password" })

	@BeforeMethod
//all preconditions as part of leaftaps application
	public void preConditions(String url, String uName, String pwd) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	
	@DataProvider(name="getData")
	public String[][] fetchData() throws IOException
	{
		return ReadExcel.readData(sheetName);
	}
	

}
