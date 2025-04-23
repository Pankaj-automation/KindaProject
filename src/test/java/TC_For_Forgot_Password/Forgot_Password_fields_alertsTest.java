package TC_For_Forgot_Password;

import org.testng.annotations.AfterClass;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import TC_For_Signup.Carrier_Step_1_Alerts_verificationTest;
import utilities.Extentreportmanager;
import utilities.Reuseable;

public class Forgot_Password_fields_alertsTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;
	ExtentReports extent;
	ExtentTest test;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass()); // get logs if needed
		extent = Extentreportmanager.getExtentReports(); // get detailed report
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test = extent.createTest("Forgot_Password_fields_alertsTest");
		logger.info("*Started Forgot_Password_fields_alertsTest*");
		test.info("*Started Forgot_Password_fields_alertsTest*");

	}

	@Test(priority = 2)
	public void Email_field_alert() throws InterruptedException {
		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Send Recovery Email']")).click();

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Email *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("Email field Validation Message: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		test.pass("Email field Validation Message: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);

		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("thr");
		WebElement roleSelect1 = driver.findElement(By.xpath("//input[@placeholder='Email *']"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String validationMessage1 = (String) js1.executeScript("return arguments[0].validationMessage;", roleSelect);
		Thread.sleep(1000);

		//logger.info("If user try to enter invalid email format: " + validationMessage1);
	//	test.pass("If user try to enter invalid email format: " + validationMessage1);
		String message = "If user try to enter invalid email format: " + validationMessage1;
		logger.info(message);
		test.pass(message);


		driver.findElement(By.xpath("//input[@placeholder='Email *']")).clear();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("threestaff@yopmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Send Recovery Email']")).click();

	}

	@Test(priority = 3)
	public void Change_Password_Page_fields_alert() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Save Password']")).click();
		WebElement otpfield = driver.findElement(By.xpath("(//div[@class='text-red-500 mb-2 text-xs d-block'])[1]"));

		logger.info("Verification code field alert: " + otpfield.getText());
		test.pass("Verification code field alert: " + otpfield.getText());

		WebElement paswrd = driver
				.findElement(By.xpath("(//div[@class='invalid-feedback block star text-[12px]'])[1]"));

		logger.info("If password is not valid: " + paswrd.getText());
		test.pass("If password is not valid: " + paswrd.getText());

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Admine51%%");
		Thread.sleep(1000);

		WebElement confirmpaswrd = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]"));

		logger.info("If password is not matched: " + confirmpaswrd.getText());
		test.pass("If password is not matched: " + confirmpaswrd.getText());

		Thread.sleep(1000);
		logger.info("*Finished Forgot_Password_fields_alertsTest*");
		test.info("*Finished Forgot_Password_fields_alertsTest*");

	}

	@Test(priority = 4)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}
