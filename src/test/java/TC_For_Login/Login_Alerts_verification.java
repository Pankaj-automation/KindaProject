package TC_For_Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.Reuseable;

public class Login_Alerts_verification {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Login_Alerts_verification*");

	}
	@Test(priority = 2)
	void Enter_Email_field_alert() throws InterruptedException {
		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		logger.info("*Verify Email field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Enter Email *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("Enter Email field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		logger.info("*Verified Email field alert*");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");


	}
	@Test(priority = 3)
	void Enter_Password_field_alert() throws InterruptedException {

		
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Enter Password *']"));
		logger.info("*Verify Password field alert*");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("Enter Password field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");

		logger.info("*Verified Email field alert*");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		

	}
	@Test(priority = 4)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
		logger.info("*Finished Login_Alerts_verification*");

	
	
}}
