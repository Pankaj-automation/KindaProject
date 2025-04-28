package Carrier_Role;

import java.io.IOException;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Profile__Test {
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
		test.info("*Started Profile__Test*");
		logger.info("*Started Profile__Test*");

	}

	@Test(priority = 2)
	void Login_with_carrier() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		test.pass("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
		test.info("*Logged in with carrier*");
		logger.info("*Logged in with carrier*");

	}

	@Test(priority = 3)
	void Edit_Profile() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("(//button[normalize-space()='View profile'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Edit Profile']")).click();
		Thread.sleep(1000);
		WebElement upl = driver.findElement(By.id("bannerImage"));
		upl.sendKeys("/home/jc-raj/Music/Automation/KindaProject/src/test/java/testBase/pexels-18393328-6470943.jpg");
		test.info("*Profile Image changed*");
		logger.info("*Profile Image changed*");
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(3000);

		String url = driver.getCurrentUrl();
		logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		test.pass("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		Thread.sleep(1000);
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
		test.info("*Profile Image Updated*");
		logger.info("*Profile Image Updated*");

	}

	@Test(priority = 4)
	void Change_Password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='bg-gray-200 px-4 cursor-pointer py-2 text-black rounded-xl']"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[contains(@type,'password')])[1]")).sendKeys("C");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys("A");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[contains(@type,'password')])[3]")).sendKeys("B");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(1000);

		WebElement confirmpaswrd = driver
				.findElement(By.xpath("//div[normalize-space()='Min Length must be 8 characters long']"));
		Thread.sleep(1000);
		String actualText = confirmpaswrd.getText();
		String expectedText = "Min Length must be 8 characters long";
		Assert.assertEquals(actualText, expectedText, "❌ Password mismatch validation failed!");
		test.pass( "Expected alert: " +expectedText+"Actual alert: "+actualText); 
		logger.info( "Expected alert: " +expectedText+"Actual alert: "+actualText); 

		Thread.sleep(1000);
		
		WebElement confirmpaswrd1 = driver
				.findElement(By.xpath("(//div[contains(@class,'invalid-feedback block star text-[12px]')])[1]"));

		String actualText1 = confirmpaswrd1.getText();
		String expectedText1 = "Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a number, and a special character.";
		Assert.assertEquals(actualText1, expectedText1, "❌ Password mismatch validation failed!");
		Thread.sleep(1000);
		WebElement confirmpaswrd2 = driver
				.findElement(By.xpath("//div[normalize-space()='Confirm Password is not matched with New Password']"));
		test.pass( "Expected alert: " +expectedText1+"Actual alert: "+actualText1); 
		logger.info( "Expected alert: " +expectedText1+"Actual alert: "+actualText1); 
		String actualText2 = confirmpaswrd2.getText();
		String expectedText2 = "Confirm Password is not matched with New Password";
		Assert.assertEquals(actualText2, expectedText2, "❌ Password mismatch validation failed!");
		Thread.sleep(1000);
		test.pass( "Expected alert: " +expectedText2+"Actual alert: "+actualText2); 
		logger.info( "Expected alert: " +expectedText2+"Actual alert: "+actualText2); 
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[1]")).sendKeys("Carrier@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys("Carrier@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[3]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[3]")).sendKeys("Carrier@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(1000);
		test.info("*Password Changed*"); 
		logger.info("*Password Changed*"); 
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		Thread.sleep(1000);
		logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL" + url);
		AssertJUnit.assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
		test.info("*Logged in with updated Passwrod*"); 
		logger.info("*Logged in with updated Passwrod*"); 
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

	@Test(priority = 4)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		if (driver != null) {
			driver.quit();
		}	test.info("*Finished Profile__Test*");
		logger.info("*Finished Profile__Test*");
	}

	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}
