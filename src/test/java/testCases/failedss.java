package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Extentreportmanager;
import utilities.Reuseable;
import utilities.Screenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.Screenshot;

import testBase.ScreenshotBase;

public class failedss  {
	
	
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
		test = extent.createTest("Links_Persent_or_NotTest");
		driver.manage().window().maximize();
		test.info("*Started Links_Persent_or_NotTest*");
		logger.info("*Started Links_Persent_or_NotTest*");

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
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/otp-verifyy");
		test.info("*Finished Forgot_PasswordTest*");
		logger.info("*Finished Forgot_PasswordTest*");
	}

	@AfterMethod
	public void tearDown1(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.takeScreenshot(driver, result.getName()); // Fixed
			test.fail("Test Failed: " + result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Passed");
		}
	}
	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}

}
	
	
	
	
	
	
	
	
	