package TC_For_Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utilities.Reuseable;

import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

public class Carrier_LoginTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Carrier_LoginTest*");

	}
@Test(priority = 2)
void Enter_Valid_U_P() throws InterruptedException {
	
	driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
	driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
	Thread.sleep(2000);
	String url = driver.getCurrentUrl();
	logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/profile " + "Current URL"+url);
	AssertJUnit.assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
	logger.info("*Finished Carrier_LoginTest*");

}
@Test(priority = 12)
public void QuitBrowser() throws IOException, InterruptedException {
	Thread.sleep(3000);
	if (driver != null) {
		driver.quit();
	}
}


}
