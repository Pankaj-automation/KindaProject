package TC_For_Login;

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

public class Driver_LoginTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Driver_LoginTest*");

	}
@Test(priority = 2)
void Enter_Valid_U_P() throws InterruptedException {
	
	driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("threedriver@yopmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Kinda@123");
	driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
	Thread.sleep(2000);
	String url = driver.getCurrentUrl();
	logger.info("Expected URL: https://kinda.jcsoftwaresolution.in/task " + "Current URL"+url);
	Assert.assertEquals(url, "https://kinda.jcsoftwaresolution.in/task");
	logger.info("*Finished Driver_LoginTest*");

}
@Test(priority = 3)
public void QuitBrowser() throws IOException, InterruptedException {
	Thread.sleep(3000);
	if (driver != null) {
		driver.quit();
	}


}
}
