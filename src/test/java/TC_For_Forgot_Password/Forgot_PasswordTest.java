package TC_For_Forgot_Password;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utilities.Extentreportmanager;
import utilities.Reuseable;

public class Forgot_PasswordTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;
	ExtentReports extent;
	ExtentTest test;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		extent = Extentreportmanager.getExtentReports();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test = extent.createTest("Forgot_PasswordTest");

		test.info("*Started Forgot_PasswordTest*");
		logger.info("*Started Forgot_PasswordTest*");


	}

	@Test(priority = 2)
	public void Forgot_Password() throws InterruptedException {

		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("threestaff@yopmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Send Recovery Email']")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		test.pass("Expected URL: https://kinda.jcsoftwaresolution.in/otp-verify " + "Current URL: " + url);
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/otp-verify");
		test.info("*Finished Forgot_PasswordTest*");
		logger.info("*Finished Forgot_PasswordTest*");

	}

	@Test(priority = 3)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(2000);
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}
