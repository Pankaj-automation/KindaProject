package Carrier_Role;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.Extentreportmanager;
import utilities.Reuseable;
import utilities.Screenshot;

public class Trucks_Test {
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
		test = extent.createTest("Broken_images_on_websiteTest");
		driver.manage().window().maximize();
		test.info("*Started Trucks_Test*");
		logger.info("*Started Trucks_Test*");
	}

	@Test(priority = 2)
	public void Navigation() throws InterruptedException {

		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
		logger.info("*Logged in with carrier*");
		test.info("*Logged in with carrier*");
	}

	@Test(priority = 3)
	public void Search() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Trucks']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='simple-search']")).sendKeys("we");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		// Flag to check if value is found
		boolean found = false;

		for (WebElement row : rows) {
			if (row.getText().contains("we")) {
				found = true;

				break;
			}
		}
		logger.info("In table the searched value is there" +found);

		// Assertion
		Assert.assertTrue(found, "❌ Search result is not found in table!");

	}
	/*
	 * 
	 * @Test(priority = 4) public void Dwonload() {
	 * 
	 * }
	 * 
	 * @Test(priority = 5) public void Import() {
	 * 
	 * }
	 * 
	 * @Test(priority = 6) public void Add_Truck() {
	 * 
	 * }
	 * 
	 * @Test(priority = 7) public void Add_Truck_Validations() {
	 * 
	 * }
	 */

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
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		extent.flush(); // Writes everything to the file

		if (driver != null) {
			driver.quit();
		}
		test.info("*Finished Profile__Test*");
		logger.info("*Finished Profile__Test*");
	}
}
