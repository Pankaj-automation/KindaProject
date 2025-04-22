package TC_For_Forgot_Password;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utilities.Reuseable;

public class Forgot_PasswordTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/otp-verify " + "Current URL: " + url);
		Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/otp-verify");
		logger.info("*Finished Forgot_PasswordTest*");
	}

	@Test(priority = 3)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
